/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.logic;

import co.edu.uniandes.mis.vacaciones.logic.api.IPerfilLogic;
import co.edu.uniandes.mis.vacaciones.logic.ejbs.PerfilLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.persistence.PerfilPersistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class PerfilLogicTest {
 private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IPerfilLogic perfilLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PerfilEntity> data = new ArrayList<PerfilEntity>();

    private List<ItinerarioEntity> itinerariosData = new ArrayList<ItinerarioEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PerfilEntity.class.getPackage())
                .addPackage(PerfilLogic.class.getPackage())
                .addPackage(IPerfilLogic.class.getPackage())
                .addPackage(PerfilPersistence.class.getPackage())
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
        em.createQuery("delete from ReviewEntity").executeUpdate();
        em.createQuery("delete from BookEntity").executeUpdate();
        em.createQuery("delete from AuthorEntity").executeUpdate();
        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ItinerarioEntity itinerarios = factory.manufacturePojo(ItinerarioEntity.class);
            System.out.println(itinerarios.getFechaInicial());
            em.persist(itinerarios);
            itinerariosData.add(itinerarios);
        }


        for (int i = 0; i < 3; i++) {
            PerfilEntity entity = factory.manufacturePojo(PerfilEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createPerfilTest() {
        try {
            PerfilEntity entity = factory.manufacturePojo(PerfilEntity.class);
            PerfilEntity created = perfilLogic.createPerfil(entity);

            PerfilEntity result = em.find(PerfilEntity.class, created.getId());

            Assert.assertNotNull(result);
            Assert.assertEquals(entity.getId(), result.getId());
            Assert.assertEquals(entity.getName(), result.getName());
        } catch (BusinessLogicException ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }

    @Test
    public void getPerfilesTest() {
        List<PerfilEntity> resultList = perfilLogic.getPerfiles();
        List<PerfilEntity> expectedList = em.createQuery("SELECT u from PerfilEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (PerfilEntity expected : expectedList) {
            boolean found = false;
            for (PerfilEntity result : resultList) {
                if (result.getId().equals(expected.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }


/**
 * @Test
    public void getBookTest() {
        PerfilEntity result = perfilLogic.getPerfil(data.get(0).getId());
        PerfilEntity expected = em.find(PerfilEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
    }

    @Test
    public void deleteBookTest() {
        PerfilEntity entity = data.get(1);
        perfilLogic.deletePerfil(entity.getId());
        PerfilEntity deleted = em.find(PerfilEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateBookTest() {
        try {
            PerfilEntity entity = data.get(0);
            PerfilEntity pojoEntity = factory.manufacturePojo(PerfilEntity.class);

            pojoEntity.setId(entity.getId());

            perfilLogic.updatePerfil(pojoEntity);

            PerfilEntity resp = em.find(PerfilEntity.class, entity.getId());

            Assert.assertEquals(pojoEntity.getId(), resp.getId());
            Assert.assertEquals(pojoEntity.getName(), resp.getName());
        } catch (BusinessLogicException ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }
    @Test
    public void getItinerarioTest() {
        PerfilEntity entity = data.get(0);
        ItinerarioEntity itinerarioEntity = itinerariosData.get(0);
        ItinerarioEntity response = perfilLogic.getItinerario(entity.getId(), itinerarioEntity.getId());

        ItinerarioEntity expected = getBookAuthor(entity.getId(), itinerarioEntity.getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(response);
    }

    @Test
    public void listAuthorsTest() {
        List<AuthorEntity> list = bookLogic.getAuthors(data.get(0).getId());
        BookEntity expected = em.find(BookEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getAuthors().size(), list.size());
    }

    @Test
    public void addAuthorsTest() {
        try {
            BookEntity entity = data.get(0);
            AuthorEntity authorEntity = authorsData.get(1);
            AuthorEntity response = bookLogic.addAuthor(authorEntity.getId(), entity.getId());

            AuthorEntity expected = getBookAuthor(entity.getId(), authorEntity.getId());

            Assert.assertNotNull(expected);
            Assert.assertNotNull(response);
            Assert.assertEquals(expected.getId(), response.getId());
        } catch (BusinessLogicException ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }

    @Test
    public void replaceAuthorsTest() {
        try {
            BookEntity entity = data.get(0);
            List<AuthorEntity> list = authorsData.subList(1, 3);
            bookLogic.replaceAuthors(list, entity.getId());

            BookEntity expected = em.find(BookEntity.class, entity.getId());

            Assert.assertNotNull(expected);
            Assert.assertFalse(expected.getAuthors().contains(authorsData.get(0)));
            Assert.assertTrue(expected.getAuthors().contains(authorsData.get(1)));
            Assert.assertTrue(expected.getAuthors().contains(authorsData.get(2)));
        } catch (BusinessLogicException ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }

    @Test(expected = NoResultException.class)
    public void removeAuthorsTest() {
        bookLogic.removeAuthor(authorsData.get(0).getId(), data.get(0).getId());
        getBookAuthor(data.get(0).getId(), authorsData.get(0).getId());
    }

    private Date getMaxDate() {
        Random r = new Random();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 9999);
        c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
        c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, c.getActualMinimum(Calendar.MILLISECOND));
        return c.getTime();
    }

    private AuthorEntity getBookAuthor(Long bookId, Long authorId) {
        Query q = em.createQuery("Select DISTINCT a from BookEntity b join b.authors a where b.id = :bookId and a.id=:authorId");
        q.setParameter("bookId", bookId);
        q.setParameter("authorId", authorId);

        return (AuthorEntity) q.getSingleResult();
    }
    */
}
