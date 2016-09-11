
package EvDsg.ejb;

import EvDsg.model.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "EvDsgPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
}
