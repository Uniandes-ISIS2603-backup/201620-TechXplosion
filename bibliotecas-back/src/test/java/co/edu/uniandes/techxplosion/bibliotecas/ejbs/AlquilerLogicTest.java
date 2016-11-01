/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IAlquilerLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.AlquilerPersistence;
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
 * @author sa.pardo10
 */
@RunWith(Arquillian.class)
public class AlquilerLogicTest 
{
  
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IAlquilerLogic alquilerLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<AlquilerEntity> data = new ArrayList<AlquilerEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AlquilerEntity.class.getPackage())
                .addPackage(AlquilerPersistence.class.getPackage())
                .addPackage(IAlquilerLogic.class.getPackage())
                .addPackage(AlquilerLogic.class.getPackage())
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
            AlquilerEntity entity = factory.manufacturePojo(AlquilerEntity.class);
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
        List<AlquilerEntity> list = alquilerLogic.getAlquileres();
         Assert.assertEquals(data.size(), list.size());   
         for(AlquilerEntity entity : list)
         {
             boolean found = false;
             for(AlquilerEntity storedEntity : data)
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
     * Test of getAlquiler method, of class AlquilerLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAlquiler() throws Exception {
    }

    /**
     * Test of getAlquilerPorUsuario method, of class AlquilerLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAlquilerPorUsuario() throws Exception {
    }

    /**
     * Test of createAlquiler method, of class AlquilerLogic.
     */
    @Test
    public void testCreateAlquiler() throws Exception {
    }

    /**
     * Test of updateAlquiler method, of class AlquilerLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateAlquiler() throws Exception {
    }

    /**
     * Test of deleteAlquiler method, of class AlquilerLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteAlquiler() throws Exception 
    {
    }
    
}
