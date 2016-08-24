package model;


public class Accesorios {
    
    private int idAc;
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
        final Accesorios other = (Accesorios) obj;
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