
package registrodao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.AreasDisponibles;


public class AreasDisponiblesDAO extends DAO {

       
    public void registrar(AreasDisponibles area) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Areas (Nombre) values(?)");
            st.setString(1, area.getNombreArea());
            
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public List<AreasDisponibles> listarareas() throws Exception{
        List<AreasDisponibles> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT idArea, Nombre FROM Areas");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                AreasDisponibles area = new AreasDisponibles();
                area.setIdArea(rs.getInt("idArea"));
                area.setNombreArea(rs.getString("Nombre"));
                
               
                lista.add(area);
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    } 
    
    public AreasDisponibles LeerId(AreasDisponibles area) throws Exception{
        AreasDisponibles areas = null;
        ResultSet rs;
           try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT idArea,Nombre FROM Areas WHERE idArea = ?");
            st.setInt(1, area.getIdArea());
            rs = st.executeQuery();
           
           while(rs.next()){
                areas = new AreasDisponibles();
                areas.setIdArea(rs.getInt("idArea"));
                areas.setNombreArea(rs.getString("Nombre"));                            
            }   
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
          return areas;       
    }
    

public void eliminar(AreasDisponibles area) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE Areas WHERE idArea= ?" );
            st.setInt(1, area.getIdArea());
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
}
