package EvDsg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Menu")
public class Menu implements Serializable{
    
    @Id
    private int codigo;
    
    @Size (max = 50)
    @Column(name = "nombre")
    private String nombre;
    
    @Size (max = 2)
    @Column(name = "tipoUsuario")
    private String tipoUsuario;
    
    @Column(name = "estado")
    private boolean estado = true;
    
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    
    @Size(max = 50)
    @Column(name = "icono")
    private String icono;
     
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
    
    
}
