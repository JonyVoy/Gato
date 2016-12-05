package EvDsg.controller;

import EvDsg.ejb.EmpleadoFacadeLocal;
import EvDsg.ejb.EvaluacionFacadeLocal;
import EvDsg.model.Empleado;
import EvDsg.model.Evaluacion;
import java.io.IOException;
import java.io.Serializable;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Named(value = "corteController")
@ViewScoped
public class CorteController implements Serializable {

    private List<Empleado> lstempleados;
    private List<Empleado> lstempleadosActivos;
    private List<Evaluacion> lstevaluacion;
    private List<Evaluacion> lstcorte;
    private int codigoEmpleado;
    private String Periodo;
    private String Año;
    private Date Fecha = Date.from(Instant.now());

    JasperPrint jasperPrint;

    @EJB
    private EmpleadoFacadeLocal empleadoEJB;
    @EJB
    private EvaluacionFacadeLocal evaluacionEJB;

    @PostConstruct
    public void init() {
        lstempleadosActivos = empleadoEJB.inactivos();
        lstempleados = empleadoEJB.findAll();
    }

    public void busqueda() throws IOException {

        try {
            lstevaluacion = evaluacionEJB.busqueda(codigoEmpleado, Fecha, Periodo, Año);
            if (lstevaluacion != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO!!", "Se encontro una evaluación para el dia de hoy"));
            } else {

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error!", "No existe evaluación diaria"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../../Protegidos/NuevaEv.xhtml");
        }

    }

    public void busquedaMensual() {
        try {
            lstcorte = evaluacionEJB.busquedaMensual(codigoEmpleado, Periodo, Año);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "AVISO!!", "No hay datos para generar el reporte"));
        }
    }

//  Reporte
    public void initial() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(lstcorte);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("\\resources\\Reportes\\Reporte.jasper");
        jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
    }

    public void PDF() throws JRException, IOException {
        initial();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=Corte_Mensual.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
//  Fin

    public List<Evaluacion> getLstcorte() {
        return lstcorte;
    }

    public void setLstcorte(List<Evaluacion> lstcorte) {
        this.lstcorte = lstcorte;
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

    public List<Empleado> getLstempleadosActivos() {
        return lstempleadosActivos;
    }

    public void setLstempleadosActivos(List<Empleado> lstempleadosActivos) {
        this.lstempleadosActivos = lstempleadosActivos;
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
