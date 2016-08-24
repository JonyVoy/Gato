
package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Accesorios;
import registrodao.AccesoriosDAO;


@ManagedBean
@ViewScoped

public class AccesoriosBean {
    
    private Accesorios accesorios = new Accesorios();
    private List<Accesorios> lstAccesorios;

    public List<Accesorios> getLstAccesorios() {
        return lstAccesorios;
    }

    public void setLstAccesorios(List<Accesorios> lstAccesorios) {
        this.lstAccesorios = lstAccesorios;
    }
    
    public Accesorios getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(Accesorios accesorios) {
        this.accesorios = accesorios;
    }
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void registrar() throws Exception{
        
        AccesoriosDAO dao;
        try{
            dao= new AccesoriosDAO();
            dao.registrar(accesorios);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Guardados"));
            this.listar("V");
        }catch(Exception e){
            throw e;
        }
    }
    
     public void listar(String valor) throws Exception{
        
        AccesoriosDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new AccesoriosDAO();
                        lstAccesorios = dao.listar();
            }
            
            }else{
                dao=new AccesoriosDAO();
                lstAccesorios = dao.listar();
            }                        
        }catch(Exception e){
            throw e;
        }
    }
     
     public void LeerId(Accesorios disp) throws Exception{
        
        AccesoriosDAO dao;
        Accesorios temp;
        
        try{
            dao= new AccesoriosDAO();
            temp = dao.LeerId(disp);
            
            if(temp != null){
                this.accesorios = temp;
            }
        }catch(Exception e){
            throw e;
        }
    }
     
     
     public void modificar() throws Exception{
        
        AccesoriosDAO dao;
        try{
            dao= new AccesoriosDAO();
            dao.modificar(accesorios);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Modificados"));
            this.listar("V");
            
        }catch(Exception e){
            throw e;
        }
    }
       
     public void eliminar(Accesorios disp) throws Exception{
        
        AccesoriosDAO dao;
        try{
            dao= new AccesoriosDAO();
            dao.eliminar(disp);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado Correctamente"));
            this.listar("V");
            
        }catch(Exception e){
            throw e;
        }
    }


}

