/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IUsuarioLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.UsuarioEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.ReservaPersistence;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.UsuarioPersistence;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jm.rodriguez11
 */
@RunWith(Arquillian.class)
public class UsuarioLogicTest {
    
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private IUsuarioLogic usuarioLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<ReservaEntity> data = new ArrayList<ReservaEntity>();
    private List<AlquilerEntity> dataAlq = new ArrayList<AlquilerEntity>(); 
     private List<UsuarioEntity> dataUs = new ArrayList<UsuarioEntity>();
     
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addPackage(IUsuarioLogic.class.getPackage())
                .addPackage(UsuarioLogic.class.getPackage())
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
            UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);
            em.persist(entity);
            dataUs.add(entity);
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
    public void testGetUsuarios() throws Exception 
    {
        List<UsuarioEntity> list;
        list = usuarioLogic.getUsuarios();
         Assert.assertEquals(dataUs.size(), list.size());   
         for(UsuarioEntity entity : list)
         {
             boolean found = false;
             for(UsuarioEntity storedEntity : dataUs)
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
     * Test of createReserva method, of class ReservaLogic.
     */
    @Test
    public void testCreateUsuario() throws Exception 
    {
        UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);
        UsuarioEntity buscado = usuarioLogic.createUsuario(entity);
        Assert.assertNotNull(buscado);
        
        buscado = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertEquals(entity, buscado);
    }

    /**
     * Test of updateReserva method, of class ReservaLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateUsuario() throws Exception 
    {
        UsuarioEntity entity = dataUs.get(0);
        UsuarioEntity nuevo = factory.manufacturePojo(UsuarioEntity.class);
        nuevo.setId(entity.getId());
        
        usuarioLogic.updateUsuario(nuevo);
        
        UsuarioEntity buscado = em.find(UsuarioEntity.class, entity.getId());
        
        Assert.assertEquals(nuevo.getId(), buscado.getId());
    }

    /**
     * Test of deleteReserva method, of class ReservaLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteUsuario() throws Exception 
    {
        UsuarioEntity entity = dataUs.get(0);
        usuarioLogic.deleteUsuario(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
