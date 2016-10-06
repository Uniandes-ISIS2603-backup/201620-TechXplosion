/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author js.sosa10
 */
@Stateless
public class VideoPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(VideoPersistence.class.getName());

    @PersistenceContext(unitName = "techxplosion")
    protected EntityManager em;
    
    public VideoEntity find(Long id) 
    {
        LOGGER.log(Level.INFO, "Consultando company con id={0}", id);
        return em.find(VideoEntity.class, id);
    }

    public VideoEntity findByName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando company con name = {0}", name);
        TypedQuery<VideoEntity> q
                = em.createQuery("select u from CompanyEntity u where u.name = :name", VideoEntity.class);
        q = q.setParameter("name", name); 
        return q.getSingleResult();
    }

    public List<VideoEntity> findAll() {
        LOGGER.info("Consultando todos los companys");
        javax.persistence.Query q = em.createQuery("select u from CompanyEntity u");
        return q.getResultList();
    }

    public VideoEntity create(VideoEntity entity) {
        LOGGER.info("Creando un company nuevo");
        em.persist(entity);
        LOGGER.info("Company creado");
        return entity;
    }

    public VideoEntity update(VideoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando company con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando company con id={0}", id);
        VideoEntity entity = em.find(VideoEntity.class, id);
        em.remove(entity);
    }
}
