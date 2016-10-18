/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
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
public class MedioPagoPersistence {
    private static final Logger LOGGER = Logger.getLogger(MedioPagoPersistence.class.getName());
    @PersistenceContext (unitName="TechxplosionPU")
    protected EntityManager em;
    public MedioPagoEntity find(Long id){
        LOGGER.log(Level.INFO,"Consultando Medio de pago con id={0}",id);
        return em.find(MedioPagoEntity.class,id);
    }
       
    public MedioPagoEntity findByName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando MedioPago con nombre = {0}", name);
        TypedQuery<MedioPagoEntity> p = em.createQuery("select u from MedioPagoEntity u where u.name = :name", MedioPagoEntity.class);
        p = p.setParameter("name", name);
        return p.getSingleResult();
    }
    public List<MedioPagoEntity> findAll (){
        LOGGER.info("Consultando todos los medios de pago");
        Query q = em.createQuery("select u from MedioPagoEntity u");
        return q.getResultList();
    }
    public MedioPagoEntity create(MedioPagoEntity entity){
        LOGGER.info("Creando un medio de pago nuevo");
        em.persist(entity);
        LOGGER.info("Medio de pago creado");
        return entity;
    }
    public MedioPagoEntity update(MedioPagoEntity entity){
        LOGGER.log(Level.INFO,"Actualizando Medio de pago con id={0}",entity.getId());
        return em.merge(entity);
    }
    public void delete(Long id){
        LOGGER.log(Level.INFO,"Borrando Medio de pago con id={0}",id);
        MedioPagoEntity entity = em.find(MedioPagoEntity.class, id);
        em.remove(entity);
    }
    

}
