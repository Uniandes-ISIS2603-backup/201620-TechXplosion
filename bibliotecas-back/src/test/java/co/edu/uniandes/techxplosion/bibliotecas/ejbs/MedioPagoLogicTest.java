/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IMedioPagoLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.MedioPagoPersistence;
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
public class MedioPagoLogicTest 
{
  
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IMedioPagoLogic medioPagoLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<MedioPagoEntity> data = new ArrayList<MedioPagoEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedioPagoEntity.class.getPackage())
                .addPackage(MedioPagoPersistence.class.getPackage())
                .addPackage(IMedioPagoLogic.class.getPackage())
                .addPackage(MedioPagoLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void clearData()
    {
        em.createQuery("delete from MedioPagoEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i=0;i<5;i++)
        {
            MedioPagoEntity entity = factory.manufacturePojo(MedioPagoEntity.class);
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
     * Test of getMedioPagoes method, of class MedioPagoLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMedioPagos() throws Exception 
    {
        List<MedioPagoEntity> list = medioPagoLogic.getMedioPagos();
         Assert.assertEquals(data.size(), list.size());   
         for(MedioPagoEntity entity : list)
         {
             boolean found = false;
             for(MedioPagoEntity storedEntity : data)
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
     * Test of getMedioPago method, of class MedioPagoLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMedioPago() throws Exception 
    {
        MedioPagoEntity entity = data.get(0);
        
        MedioPagoEntity resultEntity = medioPagoLogic.getMedioPago(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }

    
    /**
     * Test of createMedioPago method, of class MedioPagoLogic.
     */
    @Test
    public void testCreateMedioPago() throws Exception 
    {
        MedioPagoEntity entity = factory.manufacturePojo(MedioPagoEntity.class);
        MedioPagoEntity buscado = medioPagoLogic.createMedioPago(entity);
        Assert.assertNotNull(buscado);
        
        buscado = em.find(MedioPagoEntity.class, entity.getId());
        Assert.assertEquals(entity, buscado);
    }

    /**
     * Test of updateMedioPago method, of class MedioPagoLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateMedioPago() throws Exception 
    {
        MedioPagoEntity entity = data.get(0);
        MedioPagoEntity nuevo = factory.manufacturePojo(MedioPagoEntity.class);
        nuevo.setId(entity.getId());
        
        medioPagoLogic.updateMedioPago(nuevo);
        
        MedioPagoEntity buscado = em.find(MedioPagoEntity.class, entity.getId());
        
        Assert.assertEquals(nuevo.getId(), buscado.getId());
    }

    /**
     * Test of deleteMedioPago method, of class MedioPagoLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteMedioPago() throws Exception 
    {
        MedioPagoEntity entity = data.get(0);
        medioPagoLogic.deleteMedioPago(entity.getId());
        MedioPagoEntity deleted = em.find(MedioPagoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
