/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;


import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.ReservaPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author js.numpaque10
 */

@RunWith(Arquillian.class)
public class ReservaPersistenceTest {
    
    @Inject
    private ReservaPersistence reservaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private List<ReservaEntity> data = new ArrayList<ReservaEntity>();
    
    @Before
    public void setUp() 
    {
        try 
        {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            try 
            {
                utx.rollback();
            } 
            catch (Exception e1) 
            {
                e1.printStackTrace();
            }
         }
    }
    
    private void clearData() 
    {
         em.createQuery("delete from ReservaEntity").executeUpdate();
    }

    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 6; i++) 
        {
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class ResePersistence.
     */
    @Test
    public void testFind() throws Exception {
        ReservaEntity entity = data.get(0);
        ReservaEntity newEntity = reservaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
        Assert.assertEquals(entity.getFechaSolicitud(), newEntity.getFechaSolicitud());
    }

    /**
     * Test of findByName method, of class ReservaPersistence.
     */
    @Test
    public void testFindByName() throws Exception {
        ReservaEntity entity = data.get(0);
        ReservaEntity newEntity = reservaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
        Assert.assertEquals(entity.getFechaSolicitud(), newEntity.getFechaSolicitud());
        Assert.assertTrue(true);
    }

    /**
     * Test of findAll method, of class AlquilerPersistence.
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<ReservaEntity> list = reservaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ReservaEntity ent : list) 
        {
            boolean found = false;
            for (ReservaEntity entity : data) 
            {
                if (ent.getId().equals(entity.getId())) 
                {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of create method, of class ReservaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
        ReservaEntity resultado =  reservaPersistence.create(newEntity);
        Assert.assertNotNull(resultado);
        ReservaEntity entity = em.find(ReservaEntity.class, resultado.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
        Assert.assertEquals(entity.getFechaSolicitud(), newEntity.getFechaSolicitud());
    }

    /**
;     * Test of update method, of class ReservaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ReservaEntity primero = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);

        newEntity.setId(primero.getId());

        reservaPersistence.update(newEntity);

        ReservaEntity entity = em.find(ReservaEntity.class, primero.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
        Assert.assertEquals(entity.getFechaSolicitud(), newEntity.getFechaSolicitud());
    
    }

    /**
     * Test of delete method, of class ReservaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ReservaEntity entity = data.get(0);
        reservaPersistence.delete(entity.getId());
        
        ReservaEntity resp= em.find(ReservaEntity.class, entity.getId());
        Assert.assertNull(resp);
    }   
}
