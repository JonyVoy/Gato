/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Accesorios;

import model.Detalle_Entrega;
import model.Dispositivo;
import model.Entrega;
import registrodao.EntregaDAO;

@ManagedBean
@ViewScoped
public class entregaBean {
    private Entrega entrega = new Entrega();
    private Accesorios accesorios = new Accesorios();
    private int cantidad;
    private int idDisp;
    private List<Detalle_Entrega> lista = new ArrayList();
    

    public int getIdDisp() {
        return idDisp;
    }

    public void setIdDisp(int idDisp) {
        this.idDisp = idDisp;
    }

    
    public List<Detalle_Entrega> getLista() {
        return lista;
    }

    public void setLista(List<Detalle_Entrega> lista) {
        this.lista = lista;
    }

    public Accesorios getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(Accesorios accesorios) {
        this.accesorios = accesorios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void agregar(){
        Detalle_Entrega det = new Detalle_Entrega();
        det.setCantidad(cantidad);
        det.setAccesorios(accesorios);
        det.setIdDisp(idDisp);
        det.setIdAc(idDisp);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Articulos agregados"));
            
        this.lista.add(det);
    }
    
    public void registrar() throws Exception{
        EntregaDAO dao;
        try{
            dao = new EntregaDAO();
            dao.registrar(entrega, lista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se asigno el dispositivo"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacta al admin."));
        }finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        }
    } 
   }
