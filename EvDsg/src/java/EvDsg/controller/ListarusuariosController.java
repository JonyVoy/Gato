
package EvDsg.controller;

import EvDsg.ejb.EmpleadoFacadeLocal;
import EvDsg.ejb.UsuariosFacadeLocal;
import EvDsg.model.Empleado;
import EvDsg.model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "listarusuariosController")
@ViewScoped
public class ListarusuariosController implements Serializable{

   @EJB 
   private UsuariosFacadeLocal usuariosEJB;
   private List<Usuarios> usuarioslst;
   private List<Usuarios> usuariosinactivos;
  

   
    public List<Usuarios> getUsuariosinactivos() {
        return usuariosinactivos;
    }

    public void setUsuariosinactivos(List<Usuarios> usuariosinactivos) {
        this.usuariosinactivos = usuariosinactivos;
    }

    public List<Usuarios> getUsuarioslst() {
        return usuarioslst;
    }

    public void setUsuarioslst(List<Usuarios> usuarioslst) {
        this.usuarioslst = usuarioslst;
    }
   
   
   
   @PostConstruct
   public void init(){
    usuarioslst = usuariosEJB.findAll();
    usuariosinactivos = usuariosEJB.inactivos();
    
   }
}
