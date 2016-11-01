/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.VideoPersistence;
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
 * @author nd.munoz10
 */
@RunWith(Arquillian.class)
public class VideoPersistenceTest 
{
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VideoEntity.class.getPackage())
                .addPackage(VideoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public VideoPersistenceTest() 
    {
        
    }
    
    @Inject
    private VideoPersistence videoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private List<VideoEntity> data = new ArrayList<VideoEntity>();
    
    @Before
    public void setUpClass()
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
         em.createQuery("delete from VideoEntity").executeUpdate();
    }
    
     private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 6; i++) 
        {
            VideoEntity entity = factory.manufacturePojo(VideoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @AfterClass
    public static void tearDownClass()
    {
        
    }
    
    @After
    public void tearDown() 
    {
    }

    /**
     * Test of find method, of class VideoPersistence.
     */
    @Test
    public void testFind() throws Exception 
    {
        VideoEntity entity = data.get(0);
        VideoEntity newEntity = videoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    }

    /**
     * Test of findByName method, of class VideoPersistence.
     */
    @Test
    public void testFindByName() throws Exception
    {
        VideoEntity entity = data.get(0);
        VideoEntity newEntity = videoPersistence.findByName(entity.getName());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    }

    /**
     * Test of findAll method, of class VideoPersistence.
     */
    @Test
    public void testFindAll() throws Exception
    {
        List<VideoEntity> list = videoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (VideoEntity ent : list) 
        {
            boolean found = false;
            for (VideoEntity entity : data) 
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
     * Test of create method, of class VideoPersistence.
     */
    @Test
    public void testCreate() throws Exception 
    {
        PodamFactory factory = new PodamFactoryImpl();
        VideoEntity newEntity = factory.manufacturePojo(VideoEntity.class);
        VideoEntity resultado =  videoPersistence.create(newEntity);
        Assert.assertNotNull(resultado);
        VideoEntity entity = em.find(VideoEntity.class, resultado.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    }

    /**
     * Test of update method, of class VideoPersistence.
     */
    @Test
    public void testUpdate() throws Exception 
    {
        VideoEntity primero = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VideoEntity newEntity = factory.manufacturePojo(VideoEntity.class);

        newEntity.setId(primero.getId());

        videoPersistence.update(newEntity);

        VideoEntity entity = em.find(VideoEntity.class, primero.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    }

    /**
     * Test of delete method, of class VideoPersistence.
     */
    @Test
    public void testDelete() throws Exception 
    {
        VideoEntity entity = data.get(0);
        videoPersistence.delete(entity.getId());
        
        VideoEntity resp= em.find(VideoEntity.class, entity.getId());
        Assert.assertNull(resp);
    }
    
}
