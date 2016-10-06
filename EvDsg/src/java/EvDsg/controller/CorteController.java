
package EvDsg.controller;

import EvDsg.ejb.EmpleadoFacadeLocal;
import EvDsg.ejb.EvaluacionFacadeLocal;
import EvDsg.model.Empleado;
import EvDsg.model.Evaluacion;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "corteController")
@ViewScoped
public class CorteController implements Serializable{
private List<Empleado> lstempleados;
private List<Evaluacion> lstevaluacion;
private int codigoEmpleado;
private String Periodo;
private String Año;
private Date Fecha;
    
  @EJB
  private EmpleadoFacadeLocal empleadoEJB;
  @EJB 
  private EvaluacionFacadeLocal evaluacionEJB;
  
  @PostConstruct
  public void init(){
   lstempleados = empleadoEJB.findAll();
  }

  public void busqueda(){
      try{
      lstevaluacion = evaluacionEJB.busqueda(codigoEmpleado, Fecha , Periodo, Año);
      }catch(Exception e){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "ERROR"));

      }
    }
  
  public void busquedaMensual(){
      try{
      lstevaluacion = evaluacionEJB.busquedaMensual(codigoEmpleado, Periodo, Año);
      }catch(Exception e){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "ERROR"));

      }
    }

  
    public List<Evaluacion> getLstevaluacion() {
        return lstevaluacion;
    }

    public void setLstevaluacion(List<Evaluacion> lstevaluacion) {
        this.lstevaluacion = lstevaluacion;
    }
  
    public List<Empleado> getLstempleados() {
        return lstempleados;
    }

    public void setLstempleados(List<Empleado> lstempleados) {
        this.lstempleados = lstempleados;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public String getAño() {
        return Año;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
 
  
  
}
