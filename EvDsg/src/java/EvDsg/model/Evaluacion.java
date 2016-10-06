package EvDsg.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Evaluacion")
public class Evaluacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoEvaluacion;

    @ManyToOne
    @JoinColumn(name = "codigoEmpleado",nullable = false)
    private Empleado codigoEmpleado;

    @ManyToOne
    @JoinColumn(name = "codigoPersonaEO")
    private Persona codigoPersonaEO;
    
    @ManyToOne
    @JoinColumn(name = "codigoPersonaJI")
    private Persona codigoPersonaJI;
    
    @ManyToOne
    @JoinColumn(name = "codigoPersonaRH")
    private Persona codigoPersonaRH;

    
    @Column(name = "Uniforme",nullable = true)
    private int Uniforme;

    
    @Column(name = "LimpiezaOficinas",nullable = true)
    private int LimpiezaOficinas;

    
    @Column(name = "ComunesInternas",nullable = true)
    private int ComunesInternas;

    
    @Column(name = "Sanitarios",nullable = true)
    private int Sanitarios;

    
    @Column(name = "SupervisionAreas",nullable = true)
    private int SupervisionAreas;

    
    @Column(name = "RevisionBase",nullable = true)
    private int RevisionBase;

    
    @Column(name = "RevisionConfianza",nullable = true)
    private int RevisionConfianza;

    
    @Column(name = "Comunes",nullable = true)
    private int Comunes;

    
    @Column(name = "LimpiezaHerramientas",nullable = true)
    private int LimpiezaHerramientas;

    
    @Column(name = "CalidadMaterial",nullable = true)
    private int CalidadMaterial;

    
    @Column(name = "Puntualidad",nullable = true)
    private int Puntualidad;

    
    @Column(name = "Asistencia",nullable = true)
    private int Asistencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FechaEv",columnDefinition = "DATETIME",insertable = false)
    private Date FechaEv;

    @Column(name = "Periodo")
    private String Periodo;
    
    @Column(name = "Año")
    private String Año;

    public String getAño() {
        return Año;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }
    
    
    public String getPeriodo() {
        return Periodo;
    }

    public int getCodigoEvaluacion() {
        return codigoEvaluacion;
    }

    public void setCodigoEvaluacion(int codigoEvaluacion) {
        this.codigoEvaluacion = codigoEvaluacion;
    }

    public Empleado getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Empleado codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Persona getCodigoPersonaEO() {
        return codigoPersonaEO;
    }

    public void setCodigoPersonaEO(Persona codigoPersonaEO) {
        this.codigoPersonaEO = codigoPersonaEO;
    }

    public Persona getCodigoPersonaJI() {
        return codigoPersonaJI;
    }

    public void setCodigoPersonaJI(Persona codigoPersonaJI) {
        this.codigoPersonaJI = codigoPersonaJI;
    }

    public Persona getCodigoPersonaRH() {
        return codigoPersonaRH;
    }

    public void setCodigoPersonaRH(Persona codigoPersonaRH) {
        this.codigoPersonaRH = codigoPersonaRH;
    }

        
    public int getUniforme() {
        return Uniforme;
    }

    public void setUniforme(int Uniforme) {
        this.Uniforme = Uniforme;
    }

    public int getLimpiezaOficinas() {
        return LimpiezaOficinas;
    }

    public void setLimpiezaOficinas(int LimpiezaOficinas) {
        this.LimpiezaOficinas = LimpiezaOficinas;
    }

    public int getComunesInternas() {
        return ComunesInternas;
    }

    public void setComunesInternas(int ComunesInternas) {
        this.ComunesInternas = ComunesInternas;
    }

    public int getSanitarios() {
        return Sanitarios;
    }

    public void setSanitarios(int Sanitarios) {
        this.Sanitarios = Sanitarios;
    }

    public int getSupervisionAreas() {
        return SupervisionAreas;
    }

    public void setSupervisionAreas(int SupervisionAreas) {
        this.SupervisionAreas = SupervisionAreas;
    }

    public int getRevisionBase() {
        return RevisionBase;
    }

    public void setRevisionBase(int RevisionBase) {
        this.RevisionBase = RevisionBase;
    }

    public int getRevisionConfianza() {
        return RevisionConfianza;
    }

    public void setRevisionConfianza(int RevisionConfianza) {
        this.RevisionConfianza = RevisionConfianza;
    }

    public int getComunes() {
        return Comunes;
    }

    public void setComunes(int Comunes) {
        this.Comunes = Comunes;
    }

    public int getLimpiezaHerramientas() {
        return LimpiezaHerramientas;
    }

    public void setLimpiezaHerramientas(int LimpiezaHerramientas) {
        this.LimpiezaHerramientas = LimpiezaHerramientas;
    }

    public int getCalidadMaterial() {
        return CalidadMaterial;
    }

    public void setCalidadMaterial(int CalidadMaterial) {
        this.CalidadMaterial = CalidadMaterial;
    }

    public int getPuntualidad() {
        return Puntualidad;
    }

    public void setPuntualidad(int Puntualidad) {
        this.Puntualidad = Puntualidad;
    }

    public int getAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(int Asistencia) {
        this.Asistencia = Asistencia;
    }

    public Date getFechaEv() {
        return FechaEv;
    }

    public void setFechaEv(Date FechaEv) {
        this.FechaEv = FechaEv;
    }

      

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.codigoEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evaluacion other = (Evaluacion) obj;
        if (this.codigoEvaluacion != other.codigoEvaluacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "codigoEvaluacion=" + codigoEvaluacion + '}';
    }

    
}
