/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;

import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

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
    private LibroPersistence libroPersistance;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
     
     private List<LibroEntity> data = new ArrayList<LibroEntity>();
    
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
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
    
    private void clearData() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void insertData() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Test of find method, of class LibroPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LibroPersistence instance = (LibroPersistence)container.getContext().lookup("java:global/classes/LibroPersistence");
        LibroEntity expResult = null;
        LibroEntity result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class LibroPersistence.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LibroPersistence instance = (LibroPersistence)container.getContext().lookup("java:global/classes/LibroPersistence");
        LibroEntity expResult = null;
        LibroEntity result = instance.findByName(name);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class LibroPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LibroPersistence instance = (LibroPersistence)container.getContext().lookup("java:global/classes/LibroPersistence");
        List<LibroEntity> expResult = null;
        List<LibroEntity> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class LibroPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        LibroEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LibroPersistence instance = (LibroPersistence)container.getContext().lookup("java:global/classes/LibroPersistence");
        LibroEntity expResult = null;
        LibroEntity result = instance.create(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LibroPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        LibroEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LibroPersistence instance = (LibroPersistence)container.getContext().lookup("java:global/classes/LibroPersistence");
        LibroEntity expResult = null;
        LibroEntity result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LibroPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LibroPersistence instance = (LibroPersistence)container.getContext().lookup("java:global/classes/LibroPersistence");
        instance.delete(id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

   
