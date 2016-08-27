
package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Dispositivo;
import model.detalles;
import registrodao.DispositivoDAO;


@ManagedBean
@ViewScoped

public class DispositivoBean {
    
    private Dispositivo dispositivo = new Dispositivo();
    private List<Dispositivo> lstDispositivo;
    private List<Dispositivo> lstDispositivoEnt;

    public List<Dispositivo> getLstDispositivoEnt() {
        return lstDispositivoEnt;
    }

    public void setLstDispositivoEnt(List<Dispositivo> lstDispositivoEnt) {
        this.lstDispositivoEnt = lstDispositivoEnt;
    }
    
    
    public List<Dispositivo> getLstDispositivo() {
        return lstDispositivo;
    }

    public void setLstDispositivo(List<Dispositivo> lstDispositivo) {
        this.lstDispositivo = lstDispositivo;
    }
    
    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void registrar() throws Exception{
        
        DispositivoDAO dao;
        try{
            dao= new DispositivoDAO();
            dao.registrar(dispositivo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Guardados"));
            this.listar("V");
        }catch(Exception e){
            throw e;
        }
    }
    
     public void listar(String valor) throws Exception{
        
        DispositivoDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new DispositivoDAO();
                        lstDispositivo = dao.listar();
            }
            
            }else{
                dao=new DispositivoDAO();
                lstDispositivo = dao.listar();
            }                        
        }catch(Exception e){
            throw e;
        }
    }
 //--------------------------------------------------Lista filtrada para campo entrega-----------
     public void listardispent(String valor) throws Exception{
        
        DispositivoDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new DispositivoDAO();
                        lstDispositivoEnt = dao.listardispent();
            }
            
            }else{
                dao=new DispositivoDAO();
                lstDispositivoEnt = dao.listardispent();
            }                        
        }catch(Exception e){
            throw e;
        }
    }
 //------------------------------------------------------------------------------------------------    
     public void LeerId(Dispositivo disp) throws Exception{
        
        DispositivoDAO dao;
        Dispositivo temp;
        
        try{
            dao= new DispositivoDAO();
            temp = dao.LeerId(disp);
            
            if(temp != null){
                this.dispositivo = temp;
            }
        }catch(Exception e){
            throw e;
        }
    }
     
     
     public void modificar() throws Exception{
        
        DispositivoDAO dao;
        try{
            dao= new DispositivoDAO();
            dao.modificar(dispositivo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Modificados"));
            this.listar("V");
            
        }catch(Exception e){
            throw e;
        }
    }
       
     public void eliminar(Dispositivo disp) throws Exception{
        
        DispositivoDAO dao;
        try{
            dao= new DispositivoDAO();
            dao.eliminar(disp);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado Correctamente"));
            this.listar("V");
            
        }catch(Exception e){
            throw e;
        }
    }
     
    public void asignar() throws Exception{
        
        DispositivoDAO dao;
        try{
            dao= new DispositivoDAO();
            dao.asignar(dispositivo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Modificados"));
            this.listar("V");
            
        }catch(Exception e){
            throw e;
        }
    }
// Detalles
  /*  
    private detalles detalle = new detalles();
    private List<detalles> lstdetalle;

    public detalles getDetalle() {
        return detalle;
    }

    public void setDetalle(detalles detalle) {
        this.detalle = detalle;
    }

    public List<detalles> getLstdetalle() {
        return lstdetalle;
    }

    public void setLstdetalle(List<detalles> lstdetalle) {
        this.lstdetalle = lstdetalle;
    }

    

public void listardet(String valor) throws Exception{
        
        DispositivoDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new DispositivoDAO();
                        lstdetalle = dao.listardet();
            }
            
            }else{
                dao=new DispositivoDAO();
                lstdetalle = dao.listardet();
            }                        
        }catch(Exception e){
            throw e;
        }
    }

public void LeerId(detalles det) throws Exception{
        
        DispositivoDAO dao;
        detalles temp;
        
        try{
            dao= new DispositivoDAO();
            temp = dao.LeerId(det);
            
            if(temp != null){
                this.detalle = temp;
            }
        }catch(Exception e){
            throw e;
        }
    }
*/
    
}

