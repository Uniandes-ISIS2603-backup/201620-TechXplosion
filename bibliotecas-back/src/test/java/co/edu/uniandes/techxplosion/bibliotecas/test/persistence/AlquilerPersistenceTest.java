/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.AlquilerPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author sa.pardo10
 */
@RunWith(Arquillian.class)
public class AlquilerPersistenceTest {
    
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AlquilerEntity.class.getPackage())
                .addPackage(AlquilerPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    public AlquilerPersistenceTest() {
    }
    
    @Inject
    private AlquilerPersistence alquilerPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private final List<AlquilerEntity> data = new ArrayList<>();
    
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
            try 
            {
                utx.rollback();
            } 
            catch (IllegalStateException | SecurityException | SystemException e1) 
            {
                System.out.println("co.edu.uniandes.techxplosion.bibliotecas.test.persistence.AlquilerPersistenceTest.setUp() + error");
            }
         }
    }
    
    private void clearData() 
    {
         em.createQuery("delete from AlquilerEntity").executeUpdate();
    }

    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 6; i++) 
        {
            AlquilerEntity entity = factory.manufacturePojo(AlquilerEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class AlquilerPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFind() throws Exception {
        AlquilerEntity entity = data.get(0);
        AlquilerEntity newEntity = alquilerPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
    }

    /**
     * Test of findByName method, of class AlquilerPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindByName() throws Exception {
        AlquilerEntity entity = data.get(0);
        AlquilerEntity newEntity = alquilerPersistence.findByName(entity.getName());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
    }

    /**
     * Test of findAll method, of class AlquilerPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<AlquilerEntity> list = alquilerPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (AlquilerEntity ent : list) 
        {
            boolean found = false;
            for (AlquilerEntity entity : data) 
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
     * Test of create method, of class AlquilerPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        AlquilerEntity newEntity = factory.manufacturePojo(AlquilerEntity.class);
        AlquilerEntity resultado =  alquilerPersistence.create(newEntity);
        Assert.assertNotNull(resultado);
        AlquilerEntity entity = em.find(AlquilerEntity.class, resultado.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
    }

    /**
;     * Test of update method, of class AlquilerPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        AlquilerEntity primero = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AlquilerEntity newEntity = factory.manufacturePojo(AlquilerEntity.class);

        newEntity.setId(primero.getId());

        alquilerPersistence.update(newEntity);

        AlquilerEntity entity = em.find(AlquilerEntity.class, primero.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getLibro(), newEntity.getLibro());
        Assert.assertEquals(entity.getVideo(), newEntity.getVideo());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
    
    }

    /**
     * Test of delete method, of class AlquilerPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        AlquilerEntity entity = data.get(0);
        alquilerPersistence.delete(entity.getId());
        
        AlquilerEntity resp= em.find(AlquilerEntity.class, entity.getId());
        Assert.assertNull(resp);
    }
    
}

   
