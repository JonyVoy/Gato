
package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Persona;
import registrodao.PersonaDAO;

@ManagedBean
@ViewScoped

public class PersonaBean {
    private Persona persona = new Persona();
    private List<Persona> lstPersonas;

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void registrar() throws Exception{
        
        PersonaDAO dao;
        try{
            dao= new PersonaDAO();
            dao.registrar(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Guardados"));
            this.listar("V");
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contacta al admin."));
        }finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        }
    }
    
     public void listar(String valor) throws Exception{
        
        PersonaDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new PersonaDAO();
                        lstPersonas = dao.listar();
            }
            
            }else{
                dao=new PersonaDAO();
                lstPersonas = dao.listar();
            }                        
        }catch(Exception e){
            throw e;
        }
    }
 //------------------------------listaFiltrada para la Entrega 
      public void listarpent(String valor) throws Exception{
        
        PersonaDAO dao;
        try{
            if(valor.equals("F")){
                if (isPostBack()==false){
                        dao= new PersonaDAO();
                        lstPersonas = dao.listarpent();
            }
            
            }else{
                dao=new PersonaDAO();
                lstPersonas = dao.listarpent();
            }                        
        }catch(Exception e){
            throw e;
        }
    }
 //----------------------------    
     public void LeerId(Persona per) throws Exception{
        
        PersonaDAO dao;
        Persona temp;
        
        try{
            dao= new PersonaDAO();
            temp = dao.LeerId(per);
            
            if(temp != null){
                this.persona = temp;
            }
        }catch(Exception e){
            throw e;
        }
    }
     
     
     public void modificar() throws Exception{
        
        PersonaDAO dao;
        try{
            dao= new PersonaDAO();
            dao.modificar(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Correctamente Modificados"));
            this.listar("V");
            
        }catch(Exception e){
            throw e;
        }
    }
     
    
     public void eliminar(Persona per) throws Exception{
        
        PersonaDAO dao;
        try{
            dao= new PersonaDAO();
            dao.eliminar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado Correctamente"));
            this.listar("V");
            
        }catch(Exception e){
            throw e;
        }
    }
     
}
