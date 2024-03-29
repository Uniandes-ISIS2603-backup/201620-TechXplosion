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
import javax.persistence.TypedQuery;

/**
 *
 * @author js.sosa10
 */
@Stateless
public class BibliotecaPersistence {
    private static final Logger LOGGER = Logger.getLogger(BibliotecaPersistence.class.getName());
    @PersistenceContext(unitName="TechxplosionPU")
    protected EntityManager em;
    public BibliotecaEntity find(Long id){
        LOGGER.log(Level.INFO,"Consulatndo Biblioteca con id={0}",id);
        return em.find(BibliotecaEntity.class,id);
    }
       
    public BibliotecaEntity findByName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando Biblioteca con nombre = {0}", name);
        TypedQuery<BibliotecaEntity> p = em.createQuery("select u from BibliotecaEntity u where u.name = :name", BibliotecaEntity.class);
        p = p.setParameter("name", name);
         List<BibliotecaEntity> bibliotecasSimilarName = p.getResultList();
        if (bibliotecasSimilarName.isEmpty() ) {
            return null; 
        } else {
            return bibliotecasSimilarName.get(0);
        }
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
