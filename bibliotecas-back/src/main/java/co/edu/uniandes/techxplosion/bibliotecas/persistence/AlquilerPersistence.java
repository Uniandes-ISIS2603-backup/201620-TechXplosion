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

    @PersistenceContext(unitName = "TechxplosionPU")
    protected EntityManager em;
    
    public AlquilerEntity find(Long id) 
    {
        LOGGER.log(Level.INFO, "Consultando alquiler con id={0}", id);
        return em.find(AlquilerEntity.class, id);
    }

   
}
