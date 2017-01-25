package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Dispositivos")
public class Dispositivo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "imei")
    @NotNull
    @Size(max = 15)
    private String imei;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "noInv")
    private String noInv;
    @Column(name = "Fecha_llegada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_llegada;
    @Column(name = "Fecha_entrega")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_entrega;
    @Column(name = "Fecha_cambio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_cambio;
    @Column(name = "disponible")
    private Boolean disponible;
    @Column(name = "tipoDispositivo")
    private String tipoDispositivo;
    

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
     * @return the disponible
     */
    public Boolean getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the tipoDispositivo
     */
    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    /**
     * @param tipoDispositivo the tipoDispositivo to set
     */
    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }
}
