/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.LibroPersistence;
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
 * @author jc.sanchez16
 */
@RunWith(Arquillian.class)
public class LibroPersistenceTest {
    
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(LibroEntity.class.getPackage())
                .addPackage(LibroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    public LibroPersistenceTest() {
    }
    
    @Inject
    private LibroPersistence libroPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private List<LibroEntity> data = new ArrayList<LibroEntity>();
    
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
         em.createQuery("delete from LibroEntity").executeUpdate();
    }

    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 6; i++) 
        {
            LibroEntity entity = factory.manufacturePojo(LibroEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class LibroPersistence.
     */
    @Test
    public void testFind() throws Exception {
        LibroEntity entity = data.get(0);
        LibroEntity newEntity = libroPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    }

    /**
     * Test of findByName method, of class LibroPersistence.
     */
    @Test
    public void testFindByName() throws Exception {
        LibroEntity entity = data.get(0);
        LibroEntity newEntity = libroPersistence.findByName(entity.getName());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    }

    /**
     * Test of findAll method, of class LibroPersistence.
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<LibroEntity> list = libroPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (LibroEntity ent : list) 
        {
            boolean found = false;
            for (LibroEntity entity : data) 
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
     * Test of create method, of class LibroPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        LibroEntity newEntity = factory.manufacturePojo(LibroEntity.class);
        LibroEntity resultado =  libroPersistence.create(newEntity);
        Assert.assertNotNull(resultado);
        LibroEntity entity = em.find(LibroEntity.class, resultado.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    }

    /**
;     * Test of update method, of class LibroPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        LibroEntity primero = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        LibroEntity newEntity = factory.manufacturePojo(LibroEntity.class);

        newEntity.setId(primero.getId());

        libroPersistence.update(newEntity);

        LibroEntity entity = em.find(LibroEntity.class, primero.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBiblioteca(), newEntity.getBiblioteca());
    
    }

    /**
     * Test of delete method, of class LibroPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        LibroEntity entity = data.get(0);
        libroPersistence.delete(entity.getId());
        
        LibroEntity resp= em.find(LibroEntity.class, entity.getId());
        Assert.assertNull(resp);
    }
    
}

   
