package EvDsg.controller;

import EvDsg.ejb.EmpleadoFacadeLocal;
import EvDsg.ejb.EvaluacionFacadeLocal;
import EvDsg.model.Empleado;
import EvDsg.model.Evaluacion;
import EvDsg.model.Persona;
import EvDsg.model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "evaluacionController")
@ViewScoped
public class EvaluacionController implements Serializable {

    @EJB
    private EvaluacionFacadeLocal evaluacionEJB;
    @EJB
    private EmpleadoFacadeLocal empleadoEJB;

    @Inject
    private Evaluacion evaluacion;
    @Inject
    private Empleado empleado;
    
    private List<Empleado> lstempleados;

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getLstempleados() {
        return lstempleados;
    }

    public void setLstempleados(List<Empleado> lstempleados) {
        this.lstempleados = lstempleados;
    }
    
    

    @PostConstruct
    public void init() {
     lstempleados = empleadoEJB.findAll();
    }

    public void registrar() {

        Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        evaluacion.setCodigoEmpleado(empleado);
        evaluacion.setCodigoPersona(us.getCodigoUsuario());
        evaluacionEJB.create(evaluacion);

    }

}
