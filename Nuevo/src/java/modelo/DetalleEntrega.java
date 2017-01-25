package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleEntrega")
public class DetalleEntrega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDetalle;
    @Column(name = "cantidad")
    private int cantidad;
    @OneToMany
    @JoinColumn(name = "accesorio_id")
    private Accesorio accesorio;

    /**
     * @return the idDetalle
     */
    public int getIdDetalle() {
        return idDetalle;
    }

    /**
     * @param idDetalle the idDetalle to set
     */
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the accesorio
     */
    public Accesorio getAccesorio() {
        return accesorio;
    }

    /**
     * @param accesorio the accesorio to set
     */
    public void setAccesorio(Accesorio accesorio) {
        this.accesorio = accesorio;
    }
}
