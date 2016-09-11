package EvDsg.controller;

import EvDsg.ejb.UsuariosFacadeLocal;
import EvDsg.model.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "indexController")
@ViewScoped
public class IndexController implements Serializable {

    @EJB
    private UsuariosFacadeLocal EJBUsuario;
    private Usuarios usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuarios();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        Usuarios us;
        String redireccion = null;
        try {
            us = EJBUsuario.iniciarSesion(usuario);
            if (us != null) {
                redireccion = "/Protegidos/principal";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error!", "Datos Incorrectos"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso!", "Error"));

        }
        return redireccion;
    }
}
