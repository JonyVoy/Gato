package registrodao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Dispositivo;
import model.detalles;




public class DispositivoDAO extends DAO {

       
    public void registrar(Dispositivo disp) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Dispositivo (Imei,Modelo,Marca,Numero_inv,Fecha_llegada, idPersona) values(?,?,?,?,?,?)");
            st.setString(1, disp.getImei());
            st.setString(2, disp.getModelo());
            st.setString(3, disp.getMarca());
            st.setString(4, disp.getNoInv());
            st.setDate(5,new java.sql.Date(disp.getFecha_llegada().getTime()));
            st.setInt(6, disp.getIdPersona());
            
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public List<Dispositivo> listar() throws Exception{
        List<Dispositivo> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT id, Imei, Modelo, Marca, Numero_inv, Fecha_llegada,idPersona FROM Dispositivo");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Dispositivo disp = new Dispositivo();
                disp.setId(rs.getInt("id"));
                disp.setImei(rs.getString("Imei"));
                disp.setModelo(rs.getString("Modelo"));
                disp.setMarca(rs.getString("Marca"));
                disp.setNoInv(rs.getString("Numero_inv"));
                disp.setFecha_llegada(rs.getDate("Fecha_llegada"));
                disp.setIdPersona(rs.getInt("idPersona"));
                lista.add(disp);
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    } 
//--------------------------------------------Lista para seccion de entrega
    
    public List<Dispositivo> listardispent() throws Exception{
        List<Dispositivo> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT id, Imei, Modelo, Marca, Numero_inv, Fecha_llegada,idPersona FROM Dispositivo where idPersona = 0");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Dispositivo disp = new Dispositivo();
                disp.setId(rs.getInt("id"));
                disp.setImei(rs.getString("Imei"));
                disp.setModelo(rs.getString("Modelo"));
                disp.setMarca(rs.getString("Marca"));
                disp.setNoInv(rs.getString("Numero_inv"));
                disp.setFecha_llegada(rs.getDate("Fecha_llegada"));
                disp.setIdPersona(rs.getInt("idPersona"));
                lista.add(disp);
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    } 
    
   //-----------------------------------------------------------------------------------------------------------   
    public Dispositivo LeerId(Dispositivo disp) throws Exception{
        Dispositivo dispo = null;
        ResultSet rs;
           try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT id, Imei, Modelo, Marca, Numero_inv,Fecha_llegada,idPersona FROM Dispositivo WHERE id = ?");
            st.setInt(1, disp.getId());
            rs = st.executeQuery();
           
           while(rs.next()){
                dispo = new Dispositivo();
                dispo.setId(rs.getInt("id"));
                dispo.setImei(rs.getString("Imei"));
                dispo.setModelo(rs.getString("Modelo"));
                dispo.setMarca(rs.getString("Marca"));
                dispo.setNoInv(rs.getString("Numero_inv"));
                dispo.setFecha_llegada(rs.getDate("Fecha_llegada"));
                dispo.setIdPersona(rs.getInt("idPersona"));
                
                
            }   
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
          return dispo;       
    }
    
    public void modificar(Dispositivo disp) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Dispositivo SET Imei = ?, Modelo = ?, Marca = ?, Numero_inv = ?,idPersona = ?,Fecha_llegada = ? WHERE id= ?" );
            st.setString(1, disp.getImei());
            st.setString(2, disp.getModelo());
            st.setString(3, disp.getMarca());
            st.setString(4, disp.getNoInv());
            st.setInt(5, disp.getIdPersona());
            st.setDate(6,new java.sql.Date(disp.getFecha_llegada().getTime()));
            st.setInt(7, disp.getId());
            
            
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }


public void eliminar(Dispositivo disp) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE Dispositivo WHERE id= ?" );
            st.setInt(1, disp.getId());
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }


    public void asignar(Dispositivo disp) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Dispositivo SET Imei = ?, Modelo = ?, Marca = ?, Numero_inv = ?,idPersona = ? WHERE id= ?" );
            st.setString(1, disp.getImei());
            st.setString(2, disp.getModelo());
            st.setString(3, disp.getMarca());
            st.setString(4, disp.getNoInv());
            st.setInt(6, disp.getId());
            st.setInt(5, disp.getIdPersona());
            
            
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    /* Detalles de la entrega del dispositivo
    public List<detalles> listardet() throws Exception{
        List<detalles> lista;
        ResultSet rs;
        lista = new ArrayList();
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("Select Accesorios.Nombre, Detalle_Entrega.cantidad,Detalle_Entrega.idEntrega,Entrega.Fecha_ent,Dispositivo.Marca,Dispositivo.Modelo,Persona.Nombre_emp,Persona.Pat_emp,Persona.Mat_emp,Detalle_Entrega.idDisp\n" +
                                                                "From Accesorios\n" +
                                                                "Inner Join Detalle_Entrega On Accesorios.idAc = Detalle_Entrega.idAc\n" +
                                                                "Inner Join Entrega On Detalle_Entrega.idEntrega=Entrega.idEntrega\n" +
                                                                "Inner Join Dispositivo on Dispositivo.id=Detalle_Entrega.idDisp\n" +
                                                                "Inner Join Persona on Persona.id=Dispositivo.idPersona");
            
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                detalles det = new detalles();
                det.setNombre(rs.getString("Nombre"));
                det.setCantidad(rs.getInt("cantidad"));
                det.setIdEntrega(rs.getInt("idEntrega"));
                det.setFecha_ent(rs.getDate("Fecha_ent"));
                det.setMarca(rs.getString("Marca"));
                det.setModelo(rs.getString("Modelo"));
                det.setNombre_emp(rs.getString("Nombre_emp"));
                det.setPat_emp(rs.getString("Pat_emp"));
                det.setMat_emp(rs.getString("Mat_emp"));
                det.setIdDisp(rs.getInt("idDisp"));
                lista.add(det);
                
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    } 
    
    public detalles LeerId(detalles det) throws Exception{
        detalles detall = null;
        ResultSet rs;
           try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("Select Accesorios.Nombre, Detalle_Entrega.cantidad,Detalle_Entrega.idEntrega,Entrega.Fecha_ent,Dispositivo.Marca,Dispositivo.Modelo,Persona.Nombre_emp,Persona.Pat_emp,Persona.Mat_emp\n" +
                                                                        "From Accesorios\n" +
                                                                        "Inner Join Detalle_Entrega On Accesorios.idAc = Detalle_Entrega.idAc\n" +
                                                                        "Inner Join Entrega On Detalle_Entrega.idEntrega=Entrega.idEntrega\n" +
                                                                        "Inner Join Dispositivo on Dispositivo.id=Detalle_Entrega.idDisp\n" +
                                                                        "Inner Join Persona on Persona.id=Dispositivo.idPersona\n" +
                                                                        "where idDisp = ?");
            st.setInt(1, det.getIdDisp());
            rs = st.executeQuery();
           
            while(rs.next()){
                detall = new detalles();
                detall.setNombre(rs.getString("Nombre"));
                detall.setCantidad(rs.getInt("cantidad"));
                detall.setIdEntrega(rs.getInt("idEntrega"));
                detall.setFecha_ent(rs.getDate("Fecha_ent"));
                detall.setMarca(rs.getString("Marca"));
                detall.setModelo(rs.getString("Modelo"));
                detall.setNombre_emp(rs.getString("Nombre_emp"));
                detall.setPat_emp(rs.getString("Pat_emp"));
                detall.setMat_emp(rs.getString("Mat_emp"));
                detall.setIdDisp(rs.getInt("idDisp"));
                
                
            }   
            
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
          return detall;       
    }
*/
   
}
