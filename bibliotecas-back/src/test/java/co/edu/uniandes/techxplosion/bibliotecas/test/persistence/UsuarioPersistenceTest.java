/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.test.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jm.rodriguez11
 */
public class UsuarioPersistenceTest {
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
    
    public UsuarioPersistenceTest() {
    }
    
    private UsuarioPersistence usuarioPersistence;
    
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
     * Test of find method, of class UsuarioPersistence.
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
     * Test of findAllByUsuario method, of class UsuarioPersistence.
     */
    @Test
    public void testfindAllByUsuario() throws Exception {
        
       UsuarioEntity entity = data.get(0);
       List<UsuarioEntity> list = usuarioPersistence.findAllByUsuario(entity.getId());
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
     * Test of findAllByUser method, of class UsuarioPersistence.
     */
    @Test
    public void testfindAllByUser() throws Exception {
        
       UsuarioEntity entity = data.get(0);
       List<UsuarioEntity> list = usuarioPersistence.findAllByUser(entity.getId());
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
     * Test of findAll method, of class bibliotecaPersistence.
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<UsuarioEntity> list = usuarioPersistence.findAll();
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
     * Test of create method, of class bibliotecaPersistence.
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
;     * Test of update method, of class bibliotecaPersistence.
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
     * Test of delete method, of class bibliotecaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        UsuarioEntity entity = data.get(0);
        bibliotecaPersistence.delete(entity.getId());
        
        UsuarioEntity resp= em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(resp);
    }
}
