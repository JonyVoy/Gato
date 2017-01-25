/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrodao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void Conectar() throws Exception{
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://STEVEPC\\SQLSERVLOCAL:1433;databaseName=RegDisp","sa","joonsteve1993");
    
        }catch(Exception e){
            throw e;
        }
    }
    
    public void Cerrar() throws Exception{
        try{
            if(cn != null){
                if(cn.isClosed() == false){
                    cn.close();
                }
            }
        }catch(Exception e){
            throw e;
        }
    }
}
