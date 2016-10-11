/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author js.numpaque10
 */
@Stateless
public class ReservaPersistence {
    
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
    
}
