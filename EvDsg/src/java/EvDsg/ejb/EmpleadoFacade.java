
package EvDsg.ejb;

import EvDsg.model.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "EvDsgPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    @Override
    public List<Empleado> inactivos() {
        List<Empleado> inactivo;
        String inactivos;
        try{
        inactivos="FROM Empleado u WHERE u.estado = 1";
        Query query = em.createQuery(inactivos);
        
        inactivo= query.getResultList();
        }catch(Exception e){
            throw e;
        }
    return inactivo;
    }
    
}
