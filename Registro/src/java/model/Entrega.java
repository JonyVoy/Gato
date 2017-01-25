/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class Entrega {
    private int idEntrega;
    private Date Fecha_ent;
    private int idPer_ent;
    private Persona persona = new Persona();
    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Date getFecha_ent() {
        return Fecha_ent;
    }

    public void setFecha_ent(Date Fecha_ent) {
        this.Fecha_ent = Fecha_ent;
    }

    public int getIdPer_ent() {
        return idPer_ent;
    }

    public void setIdPer_ent(int idPer_ent) {
        this.idPer_ent = idPer_ent;
    }
    
    
}
