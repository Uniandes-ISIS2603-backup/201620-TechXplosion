/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.UsuarioEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.UsuarioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
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
 * @author jm.rodriguez11
 */
@RunWith(Arquillian.class)
public class UsuarioPersistenceTest 
{
 @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    public UsuarioPersistenceTest() {
    }
    
    @Inject
    private UsuarioPersistence UsuarioPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();
    
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
         em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 6; i++) 
        {
            UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class AlquilerPersistence.
     */
    @Test
    public void testFind() throws Exception {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity newEntity = UsuarioPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findByName method, of class AlquilerPersistence.
     */
    @Test
    public void testFindByName() throws Exception {
       UsuarioEntity entity = data.get(0);
        UsuarioEntity newEntity = UsuarioPersistence.findByName(entity.getName());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
        
    }

    /**
     * Test of findAll method, of class AlquilerPersistence.
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<UsuarioEntity> list = UsuarioPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (UsuarioEntity ent : list) 
        {
            boolean found = false;
            for (UsuarioEntity entity : data) 
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
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity newEntity = factory.manufacturePojo(UsuarioEntity.class);
        UsuarioEntity resultado =  UsuarioPersistence.create(newEntity);
        Assert.assertNotNull(resultado);
        UsuarioEntity entity = em.find(UsuarioEntity.class, resultado.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
;     * Test of update method, of class AlquilerPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        UsuarioEntity primero = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity newEntity = factory.manufacturePojo(UsuarioEntity.class);

        newEntity.setId(primero.getId());

        UsuarioPersistence.update(newEntity);

        UsuarioEntity entity = em.find(UsuarioEntity.class, primero.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getName(), newEntity.getName());
    
    }

    /**
     * Test of delete method, of class AlquilerPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        UsuarioEntity entity = data.get(0);
        UsuarioPersistence.delete(entity.getId());
        
        UsuarioEntity resp= em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(resp);
    }
}
