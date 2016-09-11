package EvDsg.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuarios")

public class Usuarios implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name ="codigoUsuario" , nullable = false)
    private Persona codigoUsuario;
    
    @Size(max = 50)
    @Column(name = "Usuario")
    private String usuario;
    
    @Size(max = 50)
    @Column(name = "Clave")
    private String clave;
    
    @Size(max = 1)
    @Column(name = "Tipo")
    private String tipo;
    
    @Column(name = "Estado")
    private Short estado = 1;
    
    @Size(max = 100)
    @Column(name = "Email")
    private String email;

    public Persona getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Persona codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigoUsuario);
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
        final Usuarios other = (Usuarios) obj;
        if (!Objects.equals(this.codigoUsuario, other.codigoUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "codigoUsuario=" + codigoUsuario + '}';
    }
    
    
    
    
}
