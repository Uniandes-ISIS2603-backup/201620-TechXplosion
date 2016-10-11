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

/**
 *
 * @author nd.munoz10
 */
@Stateless
public class VideoPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(BibliotecaPersistence.class.getName());
    @PersistenceContext(unitName="TechxplosionPU")
    protected EntityManager em;
    public VideoEntity find(Long id)
    {
        LOGGER.log(Level.INFO,"Consultando Video con id={0}",id);
        return em.find(VideoEntity.class,id);
    }
    public List<VideoEntity> findAll()
    {
      LOGGER.info("Consulatndo todas los videos");
      Query q = em.createQuery("select u from VideoEntity u");
      return q.getResultList();
    }
    public VideoEntity create(VideoEntity entity)
    {
        LOGGER.info("Creando un video nueva");
        em.persist(entity);
        LOGGER.info("Video creado");
        return entity;
    }
    public VideoEntity update(VideoEntity entity)
    {
        LOGGER.log(Level.INFO,"Actualizando Video con id={0}",entity.getId());
        return em.merge(entity);
    }
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO,"Borrando video con id={0}",id);
        VideoEntity entity = em.find(VideoEntity.class,id);
        em.remove(entity);
    }
}
