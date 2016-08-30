
package registrodao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Marcas;

public class MarcasDAO extends DAO {

       
    public void registrar(Marcas marca) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Marcas (Marca) values(?)");
            st.setString(1, marca.getMarca());
            
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public List<Marcas> listarmarcas() throws Exception{
        List<Marcas> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT idMarca, Marca FROM Marcas");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Marcas marca = new Marcas();
                marca.setIdMarca(rs.getInt("idMarca"));
                marca.setMarca(rs.getString("Marca"));
                
               
                lista.add(marca);
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    } 
    
    public Marcas LeerId(Marcas marca) throws Exception{
        Marcas marcas = null;
        ResultSet rs;
           try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT idMarca,Marca FROM Marcas WHERE idMarca = ?");
            st.setInt(1, marca.getIdMarca());
            rs = st.executeQuery();
           
           while(rs.next()){
                marcas = new Marcas();
                marcas.setIdMarca(rs.getInt("idMarca"));
                marcas.setMarca(rs.getString("Marca"));                            
            }   
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
          return marcas;       
    }
    

public void eliminar(Marcas marca) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE Marcas WHERE idMarca= ?" );
            st.setInt(1, marca.getIdMarca());
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
}
