/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.ParadaEntity;
import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
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
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author mc.hernandez1
 */
@RunWith(Arquillian.class)
public class ParadaPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ParadaEntity.class.getPackage())
                .addPackage(ParadaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }


    @Inject
    private ParadaPersistence paradaPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private final PodamFactory factory = new PodamFactoryImpl();

    @Before
    public void configTest()
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

     private void clearData() {
        em.createQuery("delete from ParadaEntity").executeUpdate();
    }

      private List<ParadaEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ParadaEntity entity = factory.manufacturePojo(ParadaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

//    public ParadaPersistenceTest()
//    {
//    }
//

    @Test
    public void createParadaTest(){
        ParadaEntity newEntity = factory.manufacturePojo(ParadaEntity.class);

        ParadaEntity result = paradaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ParadaEntity entity = em.find(ParadaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }


    /**
     * Test of find method, of class PerfilPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindParada() throws Exception {
         ParadaEntity entity = data.get(0);
        ParadaEntity newEntity = paradaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class ParadaPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAllParadas() throws Exception {
         List<ParadaEntity> list = paradaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ParadaEntity ent : list) {
            boolean found = false;
            for (ParadaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of create method, of class ParadaPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateParada() throws Exception {
        ParadaEntity newEntity = factory.manufacturePojo(ParadaEntity.class);

        ParadaEntity result = paradaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ParadaEntity entity = em.find(ParadaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of update method, of class ParadaPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateParada() throws Exception {
       ParadaEntity entity = data.get(0);
        ParadaEntity newEntity = factory.manufacturePojo(ParadaEntity.class);
        newEntity.setId(entity.getId());

        paradaPersistence.update(newEntity);

        ParadaEntity resp = em.find(ParadaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of delete method, of class ParadaPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteParada() throws Exception {
       ParadaEntity entity = data.get(0);
        paradaPersistence.delete(entity.getId());
        PerfilEntity deleted = em.find(PerfilEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
