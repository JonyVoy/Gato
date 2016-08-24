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
import model.Detalle_Entrega;
import model.Entrega;


public class EntregaDAO extends DAO{
    public void registrar(Entrega entrega, List<Detalle_Entrega> lista) throws Exception{
        try{
            this.Conectar();
            this.getCn().setAutoCommit(false);
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Entrega (Fecha_ent, idPer_ent) values(?,?)");
            st.setDate(1, new java.sql.Date(entrega.getFecha_ent().getTime()));
            st.setInt(2, entrega.getIdPer_ent());
            st.executeUpdate();
            st.close();
            
            PreparedStatement st2 = this.getCn().prepareStatement("SELECT MAX(idEntrega) from Entrega");
            ResultSet rs;
            int idEntrega = 0;
            rs = st2.executeQuery();
            while(rs.next()){
              idEntrega = rs.getInt(1);
                
            }
            rs.close();
            for(Detalle_Entrega det : lista){
                
                   PreparedStatement st3 = this.getCn().prepareStatement("INSERT INTO Detalle_Entrega (idEntrega,idAc,cantidad,idDisp) values(?,?,?,?)");
                   st3.setInt(1, idEntrega);
                   st3.setInt(2, det.getAccesorios().getIdAc());
                   st3.setInt(3, det.getCantidad());
                   st3.setInt(4, det.getIdDisp());
                                     
                   st3.executeUpdate();
                   st3.close();
        
            }
            PreparedStatement st4 = this.getCn().prepareStatement("select top 1(idDisp) from Detalle_Entrega order by idDet desc");
            ResultSet rs2;
            int idDisp = 0;
            rs2 = st4.executeQuery();
            while(rs2.next()){
              idDisp = rs2.getInt(1);
                
            }
            rs.close();
            
            PreparedStatement st5 = this.getCn().prepareStatement("UPDATE Dispositivo SET idPersona = ? WHERE id= ?" );
            st5.setInt(1, entrega.getIdPer_ent());
            st5.setInt(2, idDisp);
            st5.executeUpdate();
            st5.close();
            
            this.getCn().commit();
           }catch(Exception e){
               this.getCn().rollback();
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    
}
