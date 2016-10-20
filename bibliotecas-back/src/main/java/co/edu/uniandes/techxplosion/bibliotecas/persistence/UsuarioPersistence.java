/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jm.rodriguez11
 */
public class UsuarioPersistence {
     private static final Logger LOGGER = Logger.getLogger(ReservaPersistence.class.getName());
    
    @PersistenceContext(unitName = "TechxplosionPU")
    protected EntityManager em;
    
    public UsuarioEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando usuario con id={0}", id);
        return em.find(UsuarioEntity.class, id);
    }
    
     public List<UsuarioEntity> findAll() {
        LOGGER.info("Consultando todos los usuarios");
        Query q = em.createQuery("select u from UsuarioEntity u");
        return q.getResultList();
    }
     
    public List<ReservaEntity> findAllByUsuario(Long usuarioId) {
        LOGGER.log(Level.INFO, "Consultando todas las reservas por usuario id={0}", usuarioId);
        TypedQuery q = em.createQuery("select d from ReservaEntity d  where d.usuario.id = :usuarioId", ReservaEntity.class);
        q = q.setParameter("usuarioId", usuarioId);
        return q.getResultList();
    }
    
    public List<AlquilerEntity> findAllByUser(Long usuarioId) {
        LOGGER.log(Level.INFO, "Consultando todos los alquileres por usuario id={0}", usuarioId);
        TypedQuery q = em.createQuery("select d from AlquilerEntity d  where d.usuario.id = :usuarioId", ReservaEntity.class);
        q = q.setParameter("usuarioId", usuarioId);
        return q.getResultList();
    }

  
    

    public UsuarioEntity create(UsuarioEntity entity) {
        LOGGER.info("Creando un usuario nuevo");
        em.persist(entity);
        LOGGER.info("Usuario creado");
        return entity;
    }

    public UsuarioEntity update(UsuarioEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando usuario con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     *
     * @param id: corresponde a un id válido que existe el deptarment
     * crrespondiente en la base de datos.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando usuario con id={0}", id);
        UsuarioEntity entity = em.find(UsuarioEntity.class, id);
        assert entity != null;
        em.remove(entity);
    }
}
