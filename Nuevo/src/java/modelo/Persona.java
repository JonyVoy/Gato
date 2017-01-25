package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Nombre_emp")
    private String Nombre;
    @Column(name = "pat_emp")
    private String Apaterno;
    @Column(name = "mat_emp")
    private String Amaterno;
    @OneToOne
    @JoinColumn(name = "area_id")
    private AreasDisponible area;
    
    @Column(name = "No_emp")
    private int No_Emp;

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Persona other = (Persona) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

     
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApaterno() {
        return Apaterno;
    }

    public void setApaterno(String Apaterno) {
        this.Apaterno = Apaterno;
    }

    public String getAmaterno() {
        return Amaterno;
    }

    public void setAmaterno(String Amaterno) {
        this.Amaterno = Amaterno;
    }
    public int getNo_Emp() {
        return No_Emp;
    }

    public void setNo_Emp(int No_Emp) {
        this.No_Emp = No_Emp;
    } 

    /**
     * @return the area
     */
    public AreasDisponible getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(AreasDisponible area) {
        this.area = area;
    }
    
}
