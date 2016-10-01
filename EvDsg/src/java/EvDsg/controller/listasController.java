package EvDsg.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "listasController")
@ViewScoped
public class listasController implements Serializable {

    private List<SelectItem> relacion;
    private List<SelectItem> factoresEO;
    private List<SelectItem> factoresRHA;
    private List<SelectItem> factoresRHP;

    @PostConstruct
    public void init() {
        SelectItemGroup rel = new SelectItemGroup("Relacion laboral");
        rel.setSelectItems(new SelectItem[]{new SelectItem("BASE", "BASE"), new SelectItem("CONFIANZA", "CONFIANZA")});
        relacion = new ArrayList<>();
        relacion.add(rel);

        SelectItemGroup facEO = new SelectItemGroup("Calificación");
        facEO.setSelectItems(new SelectItem[]{new SelectItem("100", "E = Excelente"),
            new SelectItem("75", "B = Bien"),
            new SelectItem("50", "R = Regular"),
            new SelectItem("25", "M = Mal")});
        factoresEO = new ArrayList<>();
        factoresEO.add(facEO);
               
        SelectItemGroup facRHA = new SelectItemGroup("Verificar asistencia");
        facRHA.setSelectItems(new SelectItem[]{new SelectItem("Portacion del uniforme", "Portacion Del Uniforme"),
            new SelectItem("0", "Asistencia"),
            new SelectItem("1", "Falta")});
        factoresRHA = new ArrayList<>();
        factoresRHA.add(facRHA);
        
        SelectItemGroup facRHP = new SelectItemGroup("Verificar puntualidad");
        facRHP.setSelectItems(new SelectItem[]{new SelectItem("Portacion del uniforme", "Portacion Del Uniforme"),
            new SelectItem("0", "Puntual"),
            new SelectItem("1", "Retardo")});
        factoresRHP = new ArrayList<>();
        factoresRHP.add(facRHP);
    }

    public List<SelectItem> getFactoresRHA() {
        return factoresRHA;
    }

    public void setFactoresRHA(List<SelectItem> factoresRHA) {
        this.factoresRHA = factoresRHA;
    }

    public List<SelectItem> getFactoresRHP() {
        return factoresRHP;
    }

    public void setFactoresRHP(List<SelectItem> factoresRHP) {
        this.factoresRHP = factoresRHP;
    }

    
    public List<SelectItem> getFactoresEO() {
        return factoresEO;
    }

    public void setFactoresEO(List<SelectItem> factoresEO) {
        this.factoresEO = factoresEO;
    }

    public List<SelectItem> getRelacion() {
        return relacion;
    }

    public void setRelacion(List<SelectItem> relacion) {
        this.relacion = relacion;
    }

}
