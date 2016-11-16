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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author sa.pardo10
 */

@Stateless
public class AlquilerPersistence 
{
    
     private static final Logger LOGGER = Logger.getLogger(AlquilerPersistence.class.getName());

    @PersistenceContext(unitName = "TechxplosionPU")
    protected EntityManager em;

    public AlquilerEntity find(Long id) 
    {
        LOGGER.log(Level.INFO, "Consultando alquiler con id={0}", id);
        return em.find(AlquilerEntity.class, id);
    }
    
    public AlquilerEntity findByName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando alquiler con nombre = {0}", name);
        TypedQuery<AlquilerEntity> p = em.createQuery("select u from AlquilerEntity u where u.name = :name", AlquilerEntity.class);
        p = p.setParameter("name", name);
        return p.getSingleResult();
    }
    
    public List<AlquilerEntity> findAll() {
        LOGGER.info("Consultando todos los alquileres");
        Query p = em.createQuery("select u from AlquilerEntity u");
        return p.getResultList();
    }

    public AlquilerEntity create(AlquilerEntity entity) {
        LOGGER.info("Creando un alquiler nuevo");
        em.persist(entity);
        LOGGER.info("Alquiler creado");
        return entity;
    }

    public AlquilerEntity update(AlquilerEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando alquiler con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando alquiler con id={0}", id);
        AlquilerEntity entity = em.find(AlquilerEntity.class, id);
        em.remove(entity);
    }
}
