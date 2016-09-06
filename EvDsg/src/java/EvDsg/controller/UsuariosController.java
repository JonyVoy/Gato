
package EvDsg.controller;

import EvDsg.ejb.UsuariosFacadeLocal;
import EvDsg.model.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "usuariosController")
@ViewScoped
public class UsuariosController implements Serializable{

   @EJB
    private UsuariosFacadeLocal usuariosEJB;
    private Usuarios usuarios;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    @PostConstruct
    public void init(){
        usuarios = new Usuarios();
    }
    
    public void registrar(){
        try{
            usuariosEJB.create(usuarios);
        }catch(Exception e){
        }
    }
    
}
