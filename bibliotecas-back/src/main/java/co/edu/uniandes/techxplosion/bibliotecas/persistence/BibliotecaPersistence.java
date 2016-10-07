/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BibliotecaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author js.sosa10
 */
@Stateless
public class BibliotecaPersistence {
    private static final Logger LOGGER = Logger.getLogger(LibroPersistence.class.getName());
    @PersistenceContext(unitName="TechxplsionPU")
    protected EntityManager em;
    public BibliotecaEntity fing(Long id){
        LOGGER.log(Level.INFO,"Consulatndo Biblioteca con id={0}",id);
        return em.find(BibliotecaEntity.class,id);
    }
    public List<BibliotecaEntity> findAll(){
      LOGGER.info("Consulatndo todas las bibliotecas");
      Query q = em.createQuery("select u from BibliotecaEntity u");
      return q.getResultList();
    }
    public BibliotecaEntity create(BibliotecaEntity entity){
        LOGGER.info("Creando una biblioteca nueva");
        em.persist(entity);
        LOGGER.info("Biblioteca creada");
        return entity;
    }
    public BibliotecaEntity update(BibliotecaEntity entity){
        LOGGER.log(Level.INFO,"Actualizando Biblioteca con id={0}",entity.getId());
        return em.merge(entity);
    }
    public void delete(Long id){
        LOGGER.log(Level.INFO,"Borrando biblioteca con id={0}",id);
        BibliotecaEntity entity = em.find(BibliotecaEntity.class,id);
        em.remove(entity);
    }
}
