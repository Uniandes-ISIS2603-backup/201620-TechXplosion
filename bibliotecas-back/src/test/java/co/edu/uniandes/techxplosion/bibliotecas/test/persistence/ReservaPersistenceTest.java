/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;


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
 * @author js.numpaque10
 */

@RunWith(Arquillian.class)
public class ReservaPersistenceTest {
    
    /**
     * @return el jar que se desplegará para la prueba
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DepartmentEntity.class.getPackage())
                .addPackage(DepartmentPersistence.class.getPackage())
                .addPackage(CompanyEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Libro al que están asociadas las reservas.
     */
    LibroEntity fatherEntity1;
    
    /**
     * Video al que están asociadas las reservas.
     */
    VideoEntity fatherEntity2;
    
    /**
     * Usuario al que están asociadas las reservas.
     */
    VideoEntity fatherEntity3;
    
    /**
     * Lista de las reservas que serán utilizadas en las pruebas. 
     */
    private List<ReservaEntity> data = new ArrayList<>();
    
    @Inject
    private RepartmentPersistence reservaPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    /**
     * Configuración inicial de cada método de prueba.
     *
     */
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
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete  from DepartmentEntity").executeUpdate();
        em.createQuery("delete  from LibroEntity").executeUpdate();
        em.createQuery("delete  from VideoEntity").executeUpdate();
        em.createQuery("delete  from UsuarioEntity").executeUpdate();
    }
    
    /**
     * Para el correcto funcionamiento de las pruebas, inserta los datos
     * iniciales en la base de datos utilizando un manejador de persistencia.
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        fatherEntity1 = factory.manufacturePojo(LibroEntity.class);
        fatherEntity1.setId(1L);
        em.persist(fatherEntity1);
        fatherEntity2 = factory.manufacturePojo(LibroEntity.class);
        fatherEntity2.setId(1L);
        em.persist(fatherEntity2);
        fatherEntity3 = factory.manufacturePojo(LibroEntity.class);
        fatherEntity3.setId(1L);
        em.persist(fatherEntity3);
        for (int i = 0; i < 3; i++) {
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
            entity.setLibro(fatherEntity1);
            entity.setVideo(fatherEntity2);
            entity.setUsuario(fatherEntity3);
            data.add(entity);
            em.persist(entity);
        }  
    }
    
    /**
     * Prueba para crear un Department.
     */
    @Test
    public void createReservaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
        newEntity.setLibro(fatherEntity1);
        newEntity.setVideo(fatherEntity2);
        newEntity.setUsuario(fatherEntity3);
        ReservaEntity result = reservaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ReservaEntity entity = em.find(ReservaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de Reservas.
     */
    @Test
    public void getReservasByLibroTest() {
        List<ReservaEntity> list = reservaPersistence.findAllByLibro(fatherEntity1.getId());
        Assert.assertEquals(data.size(), list.size());
        for (ReservaEntity ent : list) {
            boolean found = false;
            for (ReservaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar la lista de Reservas.
     */
    @Test
    public void getReservasByVideoTest() {
        List<ReservaEntity> list = reservaPersistence.findAllByVideo(fatherEntity2.getId());
        Assert.assertEquals(data.size(), list.size());
        for (ReservaEntity ent : list) {
            boolean found = false;
            for (ReservaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar la lista de Reservas.
     */
    @Test
    public void getReservasByUsuarioTest() {
        List<ReservaEntity> list = reservaPersistence.findAllByUsuario(fatherEntity3.getId());
        Assert.assertEquals(data.size(), list.size());
        for (ReservaEntity ent : list) {
            boolean found = false;
            for (ReservaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un Department.
     */
    @Test
    public void getReservaTest() {
        ReservaEntity entity = data.get(0);
        ReservaEntity newEntity = reservaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Prueba para eliminar un Department.
     */
    @Test
    public void deleteDepartmentTest() {
        ReservaEntity entity = data.get(0);
        reservaPersistence.delete(entity.getId());
        ReservaEntity deleted = em.find(ReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un Department.
     */
    @Test
    public void updateReservaTest() {
        ReservaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);

        newEntity.setId(entity.getId());

        reservaPersistence.update(newEntity);

        ReservaEntity resp = em.find(ReservaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }    
}
