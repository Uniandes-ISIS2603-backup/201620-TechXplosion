/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IReservaLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.ReservaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author js.numpaque10
 */
public class ReservaLogicTest {
    
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IReservaLogic reservaLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<ReservaEntity> data = new ArrayList<ReservaEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReservaEntity.class.getPackage())
                .addPackage(ReservaPersistence.class.getPackage())
                .addPackage(IReservaLogic.class.getPackage())
                .addPackage(ReservaLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void clearData()
    {
        em.createQuery("delete from ReservaEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i=0;i<5;i++)
        {
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
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
     * Test of getReservas method, of class ReservaLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetReservas() throws Exception 
    {
        List<ReservaEntity> list = reservaLogic.getReservas();
         Assert.assertEquals(data.size(), list.size());   
         for(ReservaEntity entity : list)
         {
             boolean found = false;
             for(ReservaEntity storedEntity : data)
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
     * Test of getReserva method, of class ReservaLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetReserva() throws Exception 
    {
        ReservaEntity entity = data.get(0);
        
        ReservaEntity resultEntity = reservaLogic.getReserva(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }

 
    /**
     * Test of createReserva method, of class ReservaLogic.
     */
    @Test
    public void testCreateReserva() throws Exception 
    {
        ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
        ReservaEntity buscado = reservaLogic.createReserva(entity);
        Assert.assertNotNull(buscado);
        
        buscado = em.find(ReservaEntity.class, entity.getId());
        Assert.assertEquals(entity, buscado);
    }

    /**
     * Test of updateReserva method, of class ReservaLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateAlquiler() throws Exception 
    {
        ReservaEntity entity = data.get(0);
        ReservaEntity nuevo = factory.manufacturePojo(ReservaEntity.class);
        nuevo.setId(entity.getId());
        
        reservaLogic.updateReserva(nuevo);
        
        ReservaEntity buscado = em.find(ReservaEntity.class, entity.getId());
        
        Assert.assertEquals(nuevo.getId(), buscado.getId());
    }

    /**
     * Test of deleteReserva method, of class ReservaLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteReserva() throws Exception 
    {
        ReservaEntity entity = data.get(0);
        reservaLogic.deleteReserva(entity.getId());
        ReservaEntity deleted = em.find(ReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
