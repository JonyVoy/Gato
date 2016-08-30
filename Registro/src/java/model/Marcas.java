
package model;

import java.util.Objects;


public class Marcas {
    private int idMarca;
    private String Marca;

    @Override
    public String toString() {
        return "Marcas{" + "idMarca=" + idMarca + ", Marca=" + Marca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idMarca;
        hash = 89 * hash + Objects.hashCode(this.Marca);
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
        final Marcas other = (Marcas) obj;
        if (this.idMarca != other.idMarca) {
            return false;
        }
        if (!Objects.equals(this.Marca, other.Marca)) {
            return false;
        }
        return true;
    }

    
    
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    
}
