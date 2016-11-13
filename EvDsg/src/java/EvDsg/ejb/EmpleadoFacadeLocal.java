
package EvDsg.ejb;

import EvDsg.model.Empleado;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EmpleadoFacadeLocal {

    void create(Empleado empleado);

    void edit(Empleado empleado);

    void remove(Empleado empleado);

    Empleado find(Object id);

    List<Empleado> findAll();

    List<Empleado> findRange(int[] range);

    int count();
    
    List<Empleado> inactivos();
}
