
package EvDsg.ejb;

import EvDsg.model.Evaluacion;
import java.util.List;
import javax.ejb.Local;

@Local
 public interface EvaluacionFacadeLocal {
    
     void create(Evaluacion evaluacion);

    void edit(Evaluacion evaluacion);

    void remove(Evaluacion evaluacion);

    Evaluacion find(Object id);

    List<Evaluacion> findAll();

    List<Evaluacion> findRange(int[] range);

    int count();
}
