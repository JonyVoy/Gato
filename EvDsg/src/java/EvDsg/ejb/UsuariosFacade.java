
package EvDsg.ejb;

import EvDsg.model.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "EvDsgPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Usuarios iniciarSesion(Usuarios us){
        Usuarios usuario = null;
        String consulta;
        try{
            consulta="FROM Usuarios u WHERE u.usuario = ?1 and u.clave =?2";
            Query query= em.createQuery(consulta);
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getClave());
            query.getResultList();
            List<Usuarios> lista = query.getResultList();
            
            if(!lista.isEmpty()){
                usuario=lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }

    @Override
    public List<Usuarios> inactivos(){
        List<Usuarios> inactivo;
        String inactivos;
        try{
        inactivos="FROM Usuarios u WHERE u.estado = 0";
        Query query = em.createQuery(inactivos);
        
        inactivo= query.getResultList();
        }catch(Exception e){
            throw e;
        }
    return inactivo;
    }
}
