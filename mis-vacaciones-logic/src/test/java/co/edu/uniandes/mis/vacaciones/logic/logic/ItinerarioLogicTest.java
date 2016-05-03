/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.logic;

import co.edu.uniandes.mis.vacaciones.logic.api.IItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.ejbs.ItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.persistence.ItinerarioPersistence;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jg.murillo10
 */
@RunWith(Arquillian.class)
public class ItinerarioLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IItinerarioLogic itinerarioLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ItinerarioEntity> data = new ArrayList<ItinerarioEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ItinerarioEntity.class.getPackage())
                .addPackage(ItinerarioLogic.class.getPackage())
                .addPackage(IItinerarioLogic.class.getPackage())
                .addPackage(ItinerarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

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
        em.createQuery("delete from ItinerarioEntity").executeUpdate();
//        em.createQuery("delete from BookEntity").executeUpdate();
//        em.createQuery("delete from AuthorEntity").executeUpdate();
//        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    private void insertData() {

        for (int i = 0; i < 3; i++) {
            ItinerarioEntity entity = factory.manufacturePojo(ItinerarioEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createItinerarioTest() {
        try {
            ItinerarioEntity entity = factory.manufacturePojo(ItinerarioEntity.class);
//            entity.setPublishDate(getMaxDate());
            ItinerarioEntity created = itinerarioLogic.createItinerario(entity);

            ItinerarioEntity result = em.find(ItinerarioEntity.class, created.getId());

            Assert.assertNotNull(result);
            Assert.assertEquals(entity.getId(), result.getId());
            Assert.assertEquals(entity.getName(), result.getName());

        } catch (BusinessLogicException ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }

    @Test
    public void getItinerariosTest() {
        List<ItinerarioEntity> resultList = itinerarioLogic.getItinerarios();
        List<ItinerarioEntity> expectedList = em.createQuery("SELECT u from ItinerarioEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (ItinerarioEntity expected : expectedList) {
            boolean found = false;
            for (ItinerarioEntity result : resultList) {
                if (result.getId().equals(expected.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getItinerarioTest() {
        ItinerarioEntity result = itinerarioLogic.getItinerarioUsuario(data.get(0).getId());
        ItinerarioEntity expected = em.find(ItinerarioEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
    }

    @Test
    public void deleteItinerarioTest() {
        ItinerarioEntity entity = data.get(1);
        itinerarioLogic.deleteItinerario(entity.getId());
        ItinerarioEntity deleted = em.find(ItinerarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateItinerarioTest() {
        try {
            ItinerarioEntity entity = data.get(0);
            ItinerarioEntity pojoEntity = factory.manufacturePojo(ItinerarioEntity.class);
//            pojoEntity.setPublishDate(getMaxDate());

            pojoEntity.setId(entity.getId());

            itinerarioLogic.updateItinerario(pojoEntity);

            ItinerarioEntity resp = em.find(ItinerarioEntity.class, entity.getId());

            Assert.assertEquals(pojoEntity.getId(), resp.getId());
            Assert.assertEquals(pojoEntity.getName(), resp.getName());
        } catch (BusinessLogicException ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }

}
