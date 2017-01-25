package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Entrega")
public class Entrega implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int idEntrega;
    @Column(name = "Fecha_ent")
    private Date Fecha_ent;    
    @OneToMany
    @JoinColumn(name = "persona_id")
    private Persona persona = new Persona();
    @OneToMany
    @JoinColumn(name = "dispositivo_id")
    private Dispositivo dispositivo;
    @ManyToOne(cascade = CascadeType.ALL)
    private List<DetalleEntrega> listaAccesorios;    

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

    /**
     * @return the dispositivo
     */
    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    /**
     * @param dispositivo the dispositivo to set
     */
    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    /**
     * @return the listaAccesorios
     */
    public List<DetalleEntrega> getListaAccesorios() {
        return listaAccesorios;
    }

    /**
     * @param listaAccesorios the listaAccesorios to set
     */
    public void setListaAccesorios(List<DetalleEntrega> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    
}
