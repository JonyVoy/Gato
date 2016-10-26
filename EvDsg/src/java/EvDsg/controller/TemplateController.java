
package EvDsg.controller;

import EvDsg.model.Usuarios;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "templateController")
@SessionScoped
public class TemplateController implements Serializable{

   
    public void verificarSesion() {
        try{
            FacesContext context = FacesContext.getCurrentInstance();
        Usuarios us = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            if(us == null){
                context.getExternalContext().redirect("./../../Acceso_Denegado.xhtml");
            }
        }catch(Exception e){
        
        }
        
    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
 
    public String mostrarUsuario(){
        Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getUsuario();
        
    }
    
}
