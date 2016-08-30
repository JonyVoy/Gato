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
import model.Persona;


public class PersonaDAO extends DAO { 
    public void registrar(Persona per) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Persona (Nombre_emp,Pat_emp,Mat_emp,Area,No_Emp,estado) values(?,?,?,?,?,?)");
            st.setString(1, per.getNombre());
            st.setString(2, per.getApaterno());
            st.setString(3, per.getAmaterno());
            st.setString(4, per.getArea());
            st.setInt(5, per.getNo_Emp());
            st.setInt(6, per.getEstado());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    
    public List<Persona> listar() throws Exception{
        List<Persona> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT id,No_Emp, Nombre_emp, Pat_emp, Mat_emp, Area,estado FROM Persona where id>0 order by id desc");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setNo_Emp(rs.getInt("No_Emp"));
                per.setNombre(rs.getString("Nombre_emp"));
                per.setApaterno(rs.getString("Pat_emp"));
                per.setAmaterno(rs.getString("Mat_emp"));
                per.setArea(rs.getString("Area"));
                per.setEstado(rs.getInt("estado"));
                
                lista.add(per);
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    }
    
 //Lista para la entrega-----------------------------------------------   
     public List<Persona> listarpent() throws Exception{
        List<Persona> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT id,No_Emp, Nombre_emp, Pat_emp, Mat_emp, Area,estado FROM Persona where estado=1");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setNo_Emp(rs.getInt("No_Emp"));
                per.setNombre(rs.getString("Nombre_emp"));
                per.setApaterno(rs.getString("Pat_emp"));
                per.setAmaterno(rs.getString("Mat_emp"));
                per.setArea(rs.getString("Area"));
                per.setEstado(rs.getInt("estado"));
                
                lista.add(per);
            }   
        }catch(Exception e){
                throw e;
        }finally{
            this.Cerrar();
        }
            return lista;
    } 
 //---------------------------------------------------------------------------------------------------------------------------------------   
    public Persona LeerId(Persona disp) throws Exception{
        Persona pers = null;
        ResultSet rs;
           try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT id, Nombre_emp, Pat_emp,Mat_emp, Area,No_Emp,estado FROM Persona WHERE id = ?");
            st.setInt(1, disp.getId());
            rs = st.executeQuery();
           
           while(rs.next()){
                pers = new Persona();
                pers.setId(rs.getInt("id"));
                pers.setNombre(rs.getString("Nombre_emp"));
                pers.setApaterno(rs.getString("Pat_emp"));
                pers.setAmaterno(rs.getString("Mat_emp"));
                pers.setArea(rs.getString("Area"));
                pers.setNo_Emp(rs.getInt("No_Emp"));
                pers.setEstado(rs.getInt("estado"));
                
            }   
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
          return pers;       
    } 
    
    
    public void modificar(Persona per) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Persona SET Nombre_emp = ?, Pat_emp = ?, Mat_emp = ?, Area = ?, No_Emp = ?,estado = ? WHERE id= ?" );
            st.setString(1, per.getNombre());
            st.setString(2, per.getApaterno());
            st.setString(3, per.getAmaterno());
            st.setString(4, per.getArea());
            st.setInt(5, per.getNo_Emp());
            st.setInt(6, per.getEstado());
            st.setInt(7, per.getId());
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public void eliminar(Persona per) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE Persona WHERE id= ?" );
            st.setInt(1, per.getId());
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
  }
