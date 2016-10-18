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
    
    public ReservaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando reserva con id={0}", id);
        return em.find(ReservaEntity.class, id);
    }
    
     public List<ReservaEntity> findAll() {
        LOGGER.info("Consultando todas las reservas");
        Query q = em.createQuery("select u from ReservatEntity u");
        return q.getResultList();
    }
     
    public List<ReservaEntity> findAllByVideo(Long videoId) {
        LOGGER.log(Level.INFO, "Consultando todas las reservas por video id={0}", videoId);
        TypedQuery q = em.createQuery("select d from ReservaEntity d  where d.video.id = :videoId", ReservaEntity.class);
        q = q.setParameter("videoId", videoId);
        return q.getResultList();
    }
    
    public List<ReservaEntity> findAllByLibro(Long libroId) {
        LOGGER.log(Level.INFO, "Consultando todas las reservas por libro id={0}", libroId);
        TypedQuery q = em.createQuery("select d from ReservaEntity d  where d.libro.id = :libroId", ReservaEntity.class);
        q = q.setParameter("libroId", libroId);
        return q.getResultList();
    }

    public List<ReservaEntity> findAllByUsuario(Long usuarioId) {
        LOGGER.log(Level.INFO, "Consultando todas las reservas por usuario id={0}", usuarioId);
        TypedQuery q = em.createQuery("select d from ReservaEntity d  where d.usuario.id = :usuarioId", ReservaEntity.class);
        q = q.setParameter("usuarioId", usuarioId);
        return q.getResultList();
    }
    

    public ReservaEntity create(ReservaEntity entity) {
        LOGGER.info("Creando una reserva nueva");
        em.persist(entity);
        LOGGER.info("Reserva creada");
        return entity;
    }

    public ReservaEntity update(ReservaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando reserva con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     *
     * @param id: corresponde a un id válido que existe el deptarment
     * crrespondiente en la base de datos.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando reserva con id={0}", id);
        ReservaEntity entity = em.find(ReservaEntity.class, id);
        assert entity != null;
        em.remove(entity);
    }
}
