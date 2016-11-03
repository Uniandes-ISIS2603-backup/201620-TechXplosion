/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.ILibroLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.LibroPersistence;
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

@RunWith(Arquillian.class)
public class LibroLogicTest 
{
  
    private final PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private ILibroLogic libroLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<LibroEntity> data = new ArrayList<LibroEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(LibroEntity.class.getPackage())
                .addPackage(LibroPersistence.class.getPackage())
                .addPackage(ILibroLogic.class.getPackage())
                .addPackage(AlquilerLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void clearData()
    {
        em.createQuery("delete from LibroEntity").executeUpdate();
    }
    
    private void insertData()
    {
        for(int i=0;i<5;i++)
        {
            LibroEntity entity = factory.manufacturePojo(LibroEntity.class);
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

    
    @Test
    public void testGetLibros() throws Exception 
    {
        List<LibroEntity> list = libroLogic.getLibros();
         Assert.assertEquals(data.size(), list.size());   
         for(LibroEntity entity : list)
         {
             boolean found = false;
             for(LibroEntity storedEntity : data)
             {
                 if(entity.getId().equals(storedEntity.getId()))
                 {
                     found=true;
                 }
             }
             Assert.assertTrue(found);
         }
    }

    
    @Test
    public void testGetLibro() throws Exception 
    {
        LibroEntity entity = data.get(0);
        
        LibroEntity resultEntity = libroLogic.getLibro(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }

    @Test
    public void testGetLibroPorNombre() throws Exception 
    {        
        LibroEntity entity = data.get(0);
        
        LibroEntity resultEntity = libroLogic.getLibroPorNombre(entity.getName());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }

    @Test
    public void testCreateLibro() throws Exception 
    {
        LibroEntity entity = factory.manufacturePojo(LibroEntity.class);
        LibroEntity buscado = libroLogic.createLibro(entity);
        Assert.assertNotNull(buscado);
        
        buscado = em.find(LibroEntity.class, entity.getId());
        Assert.assertEquals(entity, buscado);
    }

    @Test
    public void testUpdateLibro() throws Exception 
    {
        LibroEntity entity = data.get(0);
        LibroEntity nuevo = factory.manufacturePojo(LibroEntity.class);
        nuevo.setId(entity.getId());
        
        libroLogic.updateLibro(nuevo);
        
        LibroEntity buscado = em.find(LibroEntity.class, entity.getId());
        
        Assert.assertEquals(nuevo.getId(), buscado.getId());
    }

   
    @Test
    public void testDeleteAlquiler() throws Exception 
    {
        LibroEntity entity = data.get(0);
        libroLogic.deleteLibro(entity.getId());
        LibroEntity deleted = em.find(LibroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
