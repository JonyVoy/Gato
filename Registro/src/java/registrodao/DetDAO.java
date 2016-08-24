/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrodao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.detalles;

/**
 *
 * @author Jony
 */
public class DetDAO extends DAO{
    
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
}
