/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.MedioPagoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author js.sosa10
 */
@RunWith(Arquillian.class)
public class MedioPagoPersistenceTest {
      @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedioPagoEntity.class.getPackage())
                .addPackage(MedioPagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public MedioPagoPersistenceTest() {
    }
        @Inject
    private MedioPagoPersistence MedioPagoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private List<MedioPagoEntity> data = new ArrayList<MedioPagoEntity>();
    
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
         em.createQuery("delete from MedioPagoEntity").executeUpdate();
    }

    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 6; i++) 
        {
            MedioPagoEntity entity = factory.manufacturePojo(MedioPagoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class MedioPagoPersistence.
     */
    @Test
    public void testFind() throws Exception {
        MedioPagoEntity entity = data.get(0);
        MedioPagoEntity newEntity = MedioPagoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
       
    }

    /**
     * Test of findByName method, of class MedioPagoPersistence.
     */
    @Test
    public void testFindByName() throws Exception {
        MedioPagoEntity entity = data.get(0);
        MedioPagoEntity newEntity = MedioPagoPersistence.findByName(entity.getName());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        
    }

    /**
     * Test of findAll method, of class MedioPagoPersistence.
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<MedioPagoEntity> list = MedioPagoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (MedioPagoEntity ent : list) 
        {
            boolean found = false;
            for (MedioPagoEntity entity : data) 
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
     * Test of create method, of class MedioPagoPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        MedioPagoEntity newEntity = factory.manufacturePojo(MedioPagoEntity.class);
        MedioPagoEntity resultado =  MedioPagoPersistence.create(newEntity);
        Assert.assertNotNull(resultado);
        MedioPagoEntity entity = em.find(MedioPagoEntity.class, resultado.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        
    }

    /**
;     * Test of update method, of class MedioPagoPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        MedioPagoEntity primero = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MedioPagoEntity newEntity = factory.manufacturePojo(MedioPagoEntity.class);

        newEntity.setId(primero.getId());

        MedioPagoPersistence.update(newEntity);

        MedioPagoEntity entity = em.find(MedioPagoEntity.class, primero.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
      
    
    }

    /**
     * Test of delete method, of class MedioPagoPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        MedioPagoEntity entity = data.get(0);
        MedioPagoPersistence.delete(entity.getId());
        
        MedioPagoEntity resp= em.find(MedioPagoEntity.class, entity.getId());
        Assert.assertNull(resp);
    }
    
}
