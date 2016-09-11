
package EvDsg.controller;

import EvDsg.ejb.UsuariosFacadeLocal;
import EvDsg.model.Persona;
import EvDsg.model.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "usuariosController")
@ViewScoped
public class UsuariosController implements Serializable{

    @EJB
    private UsuariosFacadeLocal usuariosEJB;
  
   private Usuarios usuario;
   private Persona persona;
    
    @PostConstruct
    public void init(){
     usuario = new Usuarios();
     persona = new Persona();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar(){
        try{
            this.usuario.setCodigoUsuario(persona);
            usuariosEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Guardados"));
            }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacta al admin."));
        }finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        }
        }
    }
