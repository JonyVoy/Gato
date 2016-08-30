
package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Marcas;
import registrodao.MarcasDAO;


@ManagedBean
@ViewScoped

public class MarcasBean {
    
    private Marcas marcas = new Marcas();
    private List<Marcas> lstMarcas;

    public List<Marcas> getLstMarcas() {
        return lstMarcas;
    }

    public void setLstMarcas(List<Marcas> lstMarcas) {
        this.lstMarcas = lstMarcas;
    }
    
    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void registrar() throws Exception{
        
        MarcasDAO dao;
        try{
            dao= new MarcasDAO();
            dao.registrar(marcas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Guardados"));
            this.listarmarcas("V");
        }catch(Exception e){
            throw e;
        }
    }
    
     public void listarmarcas(String valor) throws Exception{
        
        MarcasDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new MarcasDAO();
                        lstMarcas = dao.listarmarcas();
            }
            
            }else{
                dao=new MarcasDAO();
                lstMarcas = dao.listarmarcas();
            }                        
        }catch(Exception e){
            throw e;
        }
    }
     
     public void LeerId(Marcas marca) throws Exception{
        
        MarcasDAO dao;
        Marcas temp;
        
        try{
            dao= new MarcasDAO();
            temp = dao.LeerId(marca);
            
            if(temp != null){
                this.marcas = temp;
            }
        }catch(Exception e){
            throw e;
        }
    }
     
       
     public void eliminar(Marcas marca) throws Exception{
        
        MarcasDAO dao;
        try{
            dao= new MarcasDAO();
            dao.eliminar(marca);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado Correctamente"));
            this.listarmarcas("V");
            
        }catch(Exception e){
            throw e;
        }
    }


}

