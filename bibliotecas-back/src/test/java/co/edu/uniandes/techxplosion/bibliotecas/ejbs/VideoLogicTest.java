/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IVideoLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.VideoPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
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
 * @author nd.munoz10
 */
@RunWith(Arquillian.class)
public class VideoLogicTest 
{
  
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IVideoLogic videoLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<VideoEntity> data = new ArrayList<VideoEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VideoEntity.class.getPackage())
                .addPackage(VideoPersistence.class.getPackage())
                .addPackage(IVideoLogic.class.getPackage())
                .addPackage(VideoLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void clearData()
    {
        em.createQuery("delete from AlquilerEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i=0;i<5;i++)
        {
            VideoEntity entity = factory.manufacturePojo(VideoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Before
    public void setUp() 
    {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Test of getAlquileres method, of class AlquilerLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAlquileres() throws Exception 
    {
        List<VideoEntity> list = videoLogic.getVideos();
         Assert.assertEquals(data.size(), list.size());   
         for(VideoEntity entity : list)
         {
             boolean found = false;
             for(VideoEntity storedEntity : data)
             {
                 if(entity.getId().equals(storedEntity.getId()))
                 {
                     found=true;
                 }
             }
             Assert.assertTrue(found);
         }
    }

    /**
     * Test of getVideo method, of class VideoLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAlquiler() throws Exception 
    {
        VideoEntity entity = data.get(0);
        
        VideoEntity resultEntity = videoLogic.getVideo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }

    /**
     * Test of getVideoPorUsuario method, of class VideoLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetVideoPorUsuario() throws Exception {
    }

    /**
     * Test of createAlquiler method, of class VideoLogic.
     */
    @Test
    public void testCreateAlquiler() throws Exception 
    {
        VideoEntity entity = factory.manufacturePojo(VideoEntity.class);
        VideoEntity buscado = videoLogic.createVideo(entity);
        Assert.assertNotNull(buscado);
        
        buscado = em.find(VideoEntity.class, entity.getId());
        Assert.assertEquals(entity, buscado);
    }

    /**
     * Test of updateAlquiler method, of class AlquilerLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateAlquiler() throws Exception 
    {
        VideoEntity entity = data.get(0);
        VideoEntity nuevo = factory.manufacturePojo(VideoEntity.class);
        nuevo.setId(entity.getId());
        
        videoLogic.updateVideo(nuevo);
        
        VideoEntity buscado = em.find(VideoEntity.class, entity.getId());
        
        Assert.assertEquals(nuevo.getId(), buscado.getId());
    }

    /**
     * Test of deleteAlquiler method, of class AlquilerLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteAlquiler() throws Exception 
    {
        VideoEntity entity = data.get(0);
        videoLogic.deleteVideo(entity.getId());
        VideoEntity deleted = em.find(VideoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
