
package model;

import java.util.Objects;


public class AreasDisponibles {
    private int idArea;
    private String NombreArea;

    @Override
    public String toString() {
        return "AreasDisponibles{" + "idArea=" + idArea + ", NombreArea=" + NombreArea + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.NombreArea);
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
        final AreasDisponibles other = (AreasDisponibles) obj;
        if (!Objects.equals(this.NombreArea, other.NombreArea)) {
            return false;
        }
        return true;
    }

    
    
    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return NombreArea;
    }

    public void setNombreArea(String NombreArea) {
        this.NombreArea = NombreArea;
    }
    
    
}
