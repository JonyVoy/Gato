

package EvDsg.ejb;

import EvDsg.model.Evaluacion;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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

    @Override
    public List<Evaluacion> busqueda(int codigoEmpleado,Date Fecha, String Periodo, String Año)throws Exception{
        List<Evaluacion> lista=null;
        String jpql;
       try{
           jpql="from Evaluacion as EO where EO.codigoEmpleado.codigoEmpleado=EO.codigoEmpleado.codigoEmpleado and EO.codigoEmpleado.codigoEmpleado=?1 and EO.FechaEv between ?2 and ?3 and EO.Periodo = ?4 and EO.Año=?5";
                   
       Query query = em.createQuery(jpql);
       query.setParameter(1, codigoEmpleado);
       query.setParameter(2, Fecha,TemporalType.DATE);
           Calendar cal = Calendar.getInstance();
           cal.setTime(Fecha);
           cal.add(Calendar.DATE, 1);
       query.setParameter(3, cal,TemporalType.DATE);
       query.setParameter(4, Periodo);
       query.setParameter(5, Año);
           lista=query.getResultList();
           
           if(lista.isEmpty()){
                lista=(List<Evaluacion>) lista.get(0);
            }
       }catch(Exception e){
       throw e;
       }
       return lista;
    }

    @Override
    public List<Evaluacion> busquedaMensual(int codigoEmpleado, String Periodo, String Año) throws Exception {
        List<Evaluacion> lista=null;
        String jpql;
       try{
           jpql="from Evaluacion as EO,Empleado as EM where EO.codigoEmpleado.codigoEmpleado=EM.codigoEmpleado and EO.codigoEmpleado.codigoEmpleado=?1 and EO.Periodo = ?2 and EO.Año=?3";
                   
       Query query = em.createQuery(jpql);
       query.setParameter(1, codigoEmpleado);
       query.setParameter(2, Periodo);
       query.setParameter(3, Año);
           lista=query.getResultList();
       }catch(Exception e){
       throw e;
       }
       return lista;
    }

    
    
}
