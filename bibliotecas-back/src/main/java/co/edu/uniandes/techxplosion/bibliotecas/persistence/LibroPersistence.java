/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author js.sosa10
 */
@Stateless
public class LibroPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(LibroPersistence.class.getName());

    @PersistenceContext(unitName = "TechxplosionPU")
    protected EntityManager em;

    public LibroEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando company con id={0}", id);
        return em.find(LibroEntity.class, id);
    }
    
}
