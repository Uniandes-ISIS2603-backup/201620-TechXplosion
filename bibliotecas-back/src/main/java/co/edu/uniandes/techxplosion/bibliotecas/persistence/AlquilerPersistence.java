/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author js.sosa10
 */
@Stateless
public class AlquilerPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(AlquilerPersistence.class.getName());

    @PersistenceContext(unitName = "techxplosionPU")
    protected EntityManager em;
    
    public AlquilerEntity find(Long id) 
    {
        LOGGER.log(Level.INFO, "Consultando company con id={0}", id);
        return em.find(AlquilerEntity.class, id);
    }

    public AlquilerEntity findByName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando company con name = {0}", name);
        TypedQuery<AlquilerEntity> q = em.createQuery("select u from CompanyEntity u where u.name = :name", AlquilerEntity.class);
        q = q.setParameter("name", name); 
        return q.getSingleResult();
    }

    public List<AlquilerEntity> findAll() {
        LOGGER.info("Consultando todos los companys");
        javax.persistence.Query q = em.createQuery("select u from CompanyEntity u");
        return q.getResultList();
    }

    public AlquilerEntity create(AlquilerEntity entity) {
        LOGGER.info("Creando un company nuevo");
        em.persist(entity);
        LOGGER.info("Company creado");
        return entity;
    }

    public AlquilerEntity update(AlquilerEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando company con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando company con id={0}", id);
        AlquilerEntity entity = em.find(AlquilerEntity.class, id);
        em.remove(entity);
    }
    
}
