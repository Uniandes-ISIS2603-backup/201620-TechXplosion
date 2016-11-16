/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BlogEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.BlogPersistence;
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
import co.edu.uniandes.techxplosion.bibliotecas.api.IBlogLogic;
import com.sun.jdo.spi.persistence.utility.logging.LoggerJDK14;
import java.util.logging.Logger;

/**
 *
 * 
 */
@RunWith(Arquillian.class)
public class BlogLogicTest 
{
  
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IBlogLogic blogLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<BlogEntity> data = new ArrayList<BlogEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BlogEntity.class.getPackage())
                .addPackage(BlogPersistence.class.getPackage())
                .addPackage(IBlogLogic.class.getPackage())
                .addPackage(BlogLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void clearData()
    {
        em.createQuery("delete from BlogEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i=0;i<5;i++)
        {
            BlogEntity entity = factory.manufacturePojo(BlogEntity.class);
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
     * Test of getVideos method, of class VideoLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetVideos() throws Exception 
    {
        List<BlogEntity> list = blogLogic.getBlogs();
         Assert.assertEquals(data.size(), list.size());   
         for(BlogEntity entity : list)
         {
             boolean found = false;
             for(BlogEntity storedEntity : data)
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
     * Test of getBlog method, of class BlogLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetBlog() throws Exception 
    {
        BlogEntity entity = data.get(0);
        
        BlogEntity resultEntity = blogLogic.getBlog(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }


    /**
     * Test of createBlog method, of class BlogLogic.
     */
    @Test
    public void testCreateBlog() throws Exception 
    {
        BlogEntity entity = factory.manufacturePojo(BlogEntity.class);
        BlogEntity buscado = blogLogic.createBlog(entity);
        Assert.assertNotNull(buscado);
        
        buscado = em.find(BlogEntity.class, entity.getId());
        Assert.assertEquals(entity, buscado);
    }

    /**
     * Test of updateBlog method, of class BlogLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateBlog() throws Exception 
    {
        BlogEntity entity = data.get(0);
        BlogEntity nuevo = factory.manufacturePojo(BlogEntity.class);
        nuevo.setId(entity.getId());
        
        blogLogic.updateBlog(nuevo);
        
        BlogEntity buscado = em.find(BlogEntity.class, entity.getId());
        
        Assert.assertEquals(nuevo.getId(), buscado.getId());
    }

    /**
     * Test of deleteBlog method, of class BlogLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteBlog() throws Exception 
    {
        BlogEntity entity = data.get(0);
        blogLogic.deleteBlog(entity.getId());
        BlogEntity deleted = em.find(BlogEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
