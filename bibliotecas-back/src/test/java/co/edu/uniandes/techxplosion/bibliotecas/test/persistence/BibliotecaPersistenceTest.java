/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BibliotecaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.BibliotecaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
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
public class BibliotecaPersistenceTest {
      @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BibliotecaEntity.class.getPackage())
                .addPackage(BibliotecaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public BibliotecaPersistenceTest() {
    }
        @Inject
    private BibliotecaPersistence bibliotecaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private List<BibliotecaEntity> data = new ArrayList<>();
    
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
         em.createQuery("delete from BibliotecaEntity").executeUpdate();
    }

    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 6; i++) 
        {
            BibliotecaEntity entity = factory.manufacturePojo(BibliotecaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class bibliotecaPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFind() throws Exception {
        BibliotecaEntity entity = data.get(0);
        BibliotecaEntity newEntity = bibliotecaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
       
    }

    /**
     * Test of findByName method, of class bibliotecaPersistence.
     */
    @Test
    public void testFindByName() throws Exception {
        BibliotecaEntity entity = data.get(0);
        BibliotecaEntity newEntity = bibliotecaPersistence.findByName(entity.getName());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        
    }

    /**
     * Test of findAll method, of class bibliotecaPersistence.
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<BibliotecaEntity> list = bibliotecaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (BibliotecaEntity ent : list) 
        {
            boolean found = false;
            for (BibliotecaEntity entity : data) 
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
     * Test of create method, of class bibliotecaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        BibliotecaEntity newEntity = factory.manufacturePojo(BibliotecaEntity.class);
        BibliotecaEntity resultado =  bibliotecaPersistence.create(newEntity);
        Assert.assertNotNull(resultado);
        BibliotecaEntity entity = em.find(BibliotecaEntity.class, resultado.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        
    }

    /**
;     * Test of update method, of class bibliotecaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        BibliotecaEntity primero = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        BibliotecaEntity newEntity = factory.manufacturePojo(BibliotecaEntity.class);

        newEntity.setId(primero.getId());

        bibliotecaPersistence.update(newEntity);

        BibliotecaEntity entity = em.find(BibliotecaEntity.class, primero.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
      
    
    }

    /**
     * Test of delete method, of class bibliotecaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        BibliotecaEntity entity = data.get(0);
        bibliotecaPersistence.delete(entity.getId());
        
        BibliotecaEntity resp= em.find(BibliotecaEntity.class, entity.getId());
        Assert.assertNull(resp);
    }
    
}
