/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.persistence;


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
        fatherEntity = factory.manufacturePojo(CompanyEntity.class);
        fatherEntity.setId(1L);
        em.persist(fatherEntity);
        for (int i = 0; i < 3; i++) {
            DepartmentEntity entity = factory.manufacturePojo(DepartmentEntity.class);
            entity.setCompany(fatherEntity);
            data.add(entity);
            em.persist(entity);
        }

    }
    
    
    
    
}
