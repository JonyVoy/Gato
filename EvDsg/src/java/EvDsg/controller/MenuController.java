
package EvDsg.controller;

import EvDsg.ejb.MenuFacadeLocal;
import EvDsg.model.Menu;
import EvDsg.model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@Named(value = "menuController")
@SessionScoped
public class MenuController implements Serializable{

       @EJB
    private MenuFacadeLocal EJBMenu;
    private List<Menu> lista;
    private MenuModel model;

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
 
    
    @PostConstruct
    public void init(){
        this.listarMenus();
        model = new DefaultMenuModel();
        this.menuPermisos();
    }
    
    public void listarMenus(){
        try{
        lista = EJBMenu.findAll();
        }catch(Exception e){
        
        }
    }
    
    public void menuPermisos(){
         Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        for (Menu m : lista){
            if(m.getTipoUsuario().equals(us.getTipo())){
                DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                item.setUrl(m.getUrl());
                item.setIcon(m.getIcono());
        model.addElement(item);
            }
           
        }
    }
}
