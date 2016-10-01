

package EvDsg.ejb;

import EvDsg.model.Evaluacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EvaluacionFacade extends AbstractFacade<Evaluacion> implements EvaluacionFacadeLocal {
    @PersistenceContext(unitName = "EvDsgPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionFacade() {
        super(Evaluacion.class);
    }
    
}
