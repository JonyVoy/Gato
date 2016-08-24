/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.detalles;
import registrodao.DetDAO;

@ManagedBean
@ViewScoped

public class detallesBean {
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

    
private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }


public void listardet(String valor) throws Exception{
        
        DetDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new DetDAO();
                        lstdetalle = dao.listardet();
            }
            
            }else{
                dao=new DetDAO();
                lstdetalle = dao.listardet();
            }                        
        }catch(Exception e){
            throw e;
        }
    }

public void LeerId(detalles det) throws Exception{
        
        DetDAO dao;
        detalles temp;
        
        try{
            dao= new DetDAO();
            temp = dao.LeerId(det);
            
            if(temp != null){
                this.detalle = temp;
            }
        }catch(Exception e){
            throw e;
        }
    }
}
