
package EvDsg.ejb;

import EvDsg.model.Usuarios;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Usuarios iniciarSesion(Usuarios us);
    
    List<Usuarios> inactivos();
}
