/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author hj.calderon10
 */
@RunWith(Arquillian.class)
public class PerfilPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PerfilEntity.class.getPackage())
                .addPackage(PerfilPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private PerfilPersistence perfilPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private final PodamFactory factory = new PodamFactoryImpl();

    @Before
    public void configTest() {
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
        em.createQuery("delete from PerfilEntity").executeUpdate();
    }

    private List<PerfilEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PerfilEntity entity = factory.manufacturePojo(PerfilEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createPerfilTest() {
        PerfilEntity newEntity = factory.manufacturePojo(PerfilEntity.class);

        PerfilEntity result = perfilPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PerfilEntity entity = em.find(PerfilEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    @Test
    public void getPerfilesTest() {
        List<PerfilEntity> list = perfilPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PerfilEntity ent : list) {
            boolean found = false;
            for (PerfilEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getPerfilTest() {
        PerfilEntity entity = data.get(0);
        PerfilEntity newEntity = perfilPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    @Test
    public void deletePerfilTest() {
        PerfilEntity entity = data.get(0);
        perfilPersistence.delete(entity.getId());
        PerfilEntity deleted = em.find(PerfilEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updatePerfilTest(){
        PerfilEntity entity = data.get(0);
        PerfilEntity newEntity = factory.manufacturePojo(PerfilEntity.class);
        newEntity.setId(entity.getId());

        perfilPersistence.update(newEntity);

        PerfilEntity resp = em.find(PerfilEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

}
