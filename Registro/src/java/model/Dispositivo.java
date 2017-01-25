package model;

import java.util.Date;


public class Dispositivo {
    
    private int id;
    private String imei;
    private String modelo;
    private String marca;
    private String noInv;
    private Date Fecha_llegada;
    private Persona personaAsignada;
    private Date Fecha_entrega;
    private Date Fecha_cambio;
    

    public Date getFecha_cambio() {
        return Fecha_cambio;
    }

    public void setFecha_cambio(Date Fecha_cambio) {
        this.Fecha_cambio = Fecha_cambio;
    }
  

    
    
    public Date getFecha_entrega() {
        return Fecha_entrega;
    }

    public void setFecha_entrega(Date Fecha_entrega) {
        this.Fecha_entrega = Fecha_entrega;
    }  

    public Date getFecha_llegada() {
        return Fecha_llegada;
    }

    public void setFecha_llegada(Date Fecha_llegada) {
        this.Fecha_llegada = Fecha_llegada;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNoInv() {
        return noInv;
    }

    public void setNoInv(String noInv) {
        this.noInv = noInv;
    }

    /**
     * @return the personaAsignada
     */
    public Persona getPersonaAsignada() {
        return personaAsignada;
    }

    /**
     * @param personaAsignada the personaAsignada to set
     */
    public void setPersonaAsignada(Persona personaAsignada) {
        this.personaAsignada = personaAsignada;
    }
        
}
