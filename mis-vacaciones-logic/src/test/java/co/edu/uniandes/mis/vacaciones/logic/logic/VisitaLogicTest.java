/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.logic;

import co.edu.uniandes.mis.vacaciones.logic.ejbs.VisitaLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.VisitaEntity;
import co.edu.uniandes.mis.vacaciones.logic.persistence.VisitaPersistence;
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
 * @author josedanielcardenasrincon
 */
@RunWith(Arquillian.class)
public class VisitaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private VisitaLogic visitaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<VisitaEntity> data = new ArrayList<VisitaEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VisitaEntity.class.getPackage())
                .addPackage(VisitaLogic.class.getPackage())
                .addPackage(VisitaLogic.class.getPackage())
                .addPackage(VisitaPersistence.class.getPackage())
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
            VisitaEntity entity = factory.manufacturePojo(VisitaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
     
    @Test
    public void agregarTest(){

        VisitaEntity newEntity = factory.manufacturePojo(VisitaEntity.class);

        visitaLogic.createVisita(newEntity);

        Assert.assertNotNull(newEntity);

        VisitaEntity entity = em.find(VisitaEntity.class, newEntity.getId());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
    }

    @Test
    public void buscarVisitasTest(){

        List<VisitaEntity> list = visitaLogic.getVisitas();
        Assert.assertEquals(data.size(), list.size());
        for (VisitaEntity ent : list) {
            boolean found = false;
            for (VisitaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

    }

    @Test
    public void buscarVisitaIdTest(){
        VisitaEntity entity = data.get(0);
        VisitaEntity newEntity = visitaLogic.getVisita(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
    }

    @Test
    public void eliminarVisitaIdTest(){
        VisitaEntity entity = data.get(0);
        visitaLogic.deleteVisita(entity.getId());
        VisitaEntity deleted = em.find(VisitaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void actualizarVisitaTest(){
        VisitaEntity entity = data.get(0);
        VisitaEntity newEntity = factory.manufacturePojo(VisitaEntity.class);
        newEntity.setId(entity.getId());

        visitaLogic.updateVisita(Long.MIN_VALUE, newEntity);

        VisitaEntity resp = em.find(VisitaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());
    }
    
}
