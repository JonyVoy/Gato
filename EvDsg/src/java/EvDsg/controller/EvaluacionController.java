package EvDsg.controller;

import EvDsg.ejb.EmpleadoFacadeLocal;
import EvDsg.ejb.EvaluacionFacadeLocal;
import EvDsg.model.Empleado;
import EvDsg.model.Evaluacion;
import EvDsg.model.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
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
    private List<SelectItem> lstpuntualidad;
   
    
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

    public void registrarEO() {
        evaluacion.setCodigoEmpleado(empleado);
        evaluacionEJB.create(evaluacion);
    }

    public List<SelectItem> getLstpuntualidad() {
        return lstpuntualidad;
    }

    public void setLstpuntualidad(List<SelectItem> lstpuntualidad) {
        this.lstpuntualidad = lstpuntualidad;
    }

    
    
    public void modificarEO(Evaluacion evaluacion) {
        try {
            Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            evaluacion.setCodigoPersonaEO(us.getCodigoUsuario());
            evaluacionEJB.edit(evaluacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Empleado Evaluado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Se cancelo la evaluacion"));

        }

    }

    public void modificarJI(Evaluacion evaluacion) {
        try {
            Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            evaluacion.setCodigoPersonaJI(us.getCodigoUsuario());
            evaluacionEJB.edit(evaluacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Empleado Evaluado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Se cancelo la evaluacion"));

        }
    }
    
    public void modificarRH(Evaluacion evaluacion) {
        try {
            Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            evaluacion.setCodigoPersonaRH(us.getCodigoUsuario());
            evaluacionEJB.edit(evaluacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Empleado Evaluado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Se cancelo la evaluacion"));

        }
    }
    
    public void cargalista(Evaluacion evaluacion){
    switch (evaluacion.getAsistencia()){
    
        case 0:
            SelectItemGroup facRHP = new SelectItemGroup("Verificar puntualidad");
        facRHP.setSelectItems(new SelectItem[]{
            new SelectItem("0", "Puntual"),
            new SelectItem("1", "Retardo")});
        lstpuntualidad = new ArrayList<>();
        lstpuntualidad.add(facRHP);
            break;
            
            case 1:
            SelectItemGroup fac = new SelectItemGroup("Verificar puntualidad");
        fac.setSelectItems(new SelectItem[]{
            new SelectItem("0", "No evaluable")});
        lstpuntualidad = new ArrayList<>();
        lstpuntualidad.add(fac);
            break;
               
         
    }
    }
}
