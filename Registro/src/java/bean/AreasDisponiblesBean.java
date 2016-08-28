
package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AreasDisponibles;
import registrodao.AreasDisponiblesDAO;


@ManagedBean
@ViewScoped

public class AreasDisponiblesBean {
    
    private AreasDisponibles areas = new AreasDisponibles();
    private List<AreasDisponibles> lstAreasDisponibles;

    public List<AreasDisponibles> getLstAreasDisponibles() {
        return lstAreasDisponibles;
    }

    public void setLstAreasDisponibles(List<AreasDisponibles> lstAreasDisponibles) {
        this.lstAreasDisponibles = lstAreasDisponibles;
    }
    
    public AreasDisponibles getAreasDisponibles() {
        return areas;
    }

    public void setAreasDisponibles(AreasDisponibles areas) {
        this.areas = areas;
    }
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void registrar() throws Exception{
        
        AreasDisponiblesDAO dao;
        try{
            dao= new AreasDisponiblesDAO();
            dao.registrar(areas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Guardados"));
            this.listarareas("V");
        }catch(Exception e){
            throw e;
        }
    }
    
     public void listarareas(String valor) throws Exception{
        
        AreasDisponiblesDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new AreasDisponiblesDAO();
                        lstAreasDisponibles = dao.listarareas();
            }
            
            }else{
                dao=new AreasDisponiblesDAO();
                lstAreasDisponibles = dao.listarareas();
            }                        
        }catch(Exception e){
            throw e;
        }
    }
     
     public void LeerId(AreasDisponibles area) throws Exception{
        
        AreasDisponiblesDAO dao;
        AreasDisponibles temp;
        
        try{
            dao= new AreasDisponiblesDAO();
            temp = dao.LeerId(area);
            
            if(temp != null){
                this.areas = temp;
            }
        }catch(Exception e){
            throw e;
        }
    }
     
       
     public void eliminar(AreasDisponibles area) throws Exception{
        
        AreasDisponiblesDAO dao;
        try{
            dao= new AreasDisponiblesDAO();
            dao.eliminar(area);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado Correctamente"));
            this.listarareas("V");
            
        }catch(Exception e){
            throw e;
        }
    }


}

