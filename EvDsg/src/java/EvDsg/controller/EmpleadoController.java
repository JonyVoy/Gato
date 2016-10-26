package EvDsg.controller;

import EvDsg.ejb.EmpleadoFacadeLocal;
import EvDsg.model.Empleado;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "empleadoController")
@ViewScoped
public class EmpleadoController implements Serializable {

    @EJB
    private EmpleadoFacadeLocal empleadoEJB;
    @Inject
    private Empleado empleado;

    private List<Empleado> empleados;

    @PostConstruct
    public void init() {
        empleados = empleadoEJB.findAll();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    public void registrar() {
        try {

            empleadoEJB.create(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Empleado Registrado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacta al admin."));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        }
    }
    
    public void modificar (Empleado empleado){
     empleadoEJB.edit(empleado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Usuario Modificado"));

    }
     public void eliminar(Empleado empleado){
              empleadoEJB.remove(empleado);
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Empleado Eliminado"));
     }
    
}
