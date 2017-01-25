package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accesorios")
public class Accesorio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAc;
    @Column(name = "nombreacc")
    private String nombreacc;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idAc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accesorio other = (Accesorio) obj;
        if (this.idAc != other.idAc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Accesorios{" + "idAc=" + idAc + '}';
    }

    
    
    public int getIdAc() {
        return idAc;
    }

    public void setIdAc(int idAc) {
        this.idAc = idAc;
    }

    public String getNombreacc() {
        return nombreacc;
    }

    public void setNombreacc(String nombreacc) {
        this.nombreacc = nombreacc;
    }

    
}