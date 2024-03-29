/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BlogEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author js.sosa10
 */
@Stateless
public class BlogPersistence {
    private static final Logger LOGGER = Logger.getLogger(BlogPersistence.class.getName());
    @PersistenceContext(unitName="TechxplosionPU")
    protected EntityManager em;
    public BlogEntity find(Long id){
        LOGGER.log(Level.INFO,"Consultando Blog con id={0}",id);
        return em.find(BlogEntity.class, id);
    }
       
    public BlogEntity findByName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando Blog con nombre = {0}", name);
        TypedQuery<BlogEntity> p = em.createQuery("select u from BlogEntity u where u.name = :name", BlogEntity.class);
        p = p.setParameter("name", name);
        return p.getSingleResult();
    }
    public List<BlogEntity> findAll(){
        LOGGER.info("consulatndo todos los blogs");
        Query q = em.createQuery("select u from BlogEntity u");
        return q.getResultList();
    }
    public BlogEntity create(BlogEntity entity){
        LOGGER.info("Creando un blog nuevo");
        em.persist(entity);
        LOGGER.info("Blog creado");
        return entity;
    }
    public BlogEntity update(BlogEntity entity){
        LOGGER.log(Level.INFO,"Actualizando Blog con el id={0}",entity.getId());
        return em.merge(entity);
    }
    public void delete(Long id){
        LOGGER.log(Level.INFO,"Borrando blog con id={0}",id);
        BlogEntity entity =em.find(BlogEntity.class,id);
        em.remove(entity);
    }
    
}
