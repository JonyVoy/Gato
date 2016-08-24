
package registrodao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Accesorios;


public class DetalleDAO extends DAO {

       
    public void registrar(Accesorios acc) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Accesorios (Nombre) values(?)");
            st.setString(1, acc.getNombreacc());
            
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public List<Accesorios> listar() throws Exception{
        List<Accesorios> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT idAc, Nombre FROM Accesorios");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Accesorios acc = new Accesorios();
                acc.setIdAc(rs.getInt("idAc"));
                acc.setNombreacc(rs.getString("Nombre"));
                
               
                lista.add(acc);
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    } 
    
    public Accesorios LeerId(Accesorios acc) throws Exception{
        Accesorios acco = null;
        ResultSet rs;
           try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT idAc,Nombre FROM Accesorios WHERE idAc = ?");
            st.setInt(1, acc.getIdAc());
            rs = st.executeQuery();
           
           while(rs.next()){
                acco = new Accesorios();
                acco.setIdAc(rs.getInt("idAc"));
                acco.setNombreacc(rs.getString("Nombre"));                            
            }   
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
          return acco;       
    }
    
    public void modificar(Accesorios acc) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Accesorios SET Nombre = ? WHERE idAc = ?" );
            st.setString(1, acc.getNombreacc());
            st.setInt(2, acc.getIdAc());
          
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }


public void eliminar(Accesorios acc) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE Accesorios WHERE idAc= ?" );
            st.setInt(1, acc.getIdAc());
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
}
