/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.VisitaEntity;
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
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author josedanielcardenasrincon
 */
@RunWith(Arquillian.class)
public class VisitaPersistenceTest {
    
    @Inject
    private VisitaPersistence visitaPersistence;
    
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

    @After
    private void clearData() {
        em.createQuery("delete from VisitaEntity").executeUpdate();
    }

    private List<VisitaEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            VisitaEntity entity = factory.manufacturePojo(VisitaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    public VisitaPersistenceTest(){
        
    }
    
    @Deployment
    public static JavaArchive createDeployment(){
                return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VisitaEntity.class.getPackage())
                .addPackage(PerfilPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Test
    public void agregarTest(){

        VisitaEntity newEntity = factory.manufacturePojo(VisitaEntity.class);

        visitaPersistence.create(newEntity);

        Assert.assertNotNull(newEntity);

        VisitaEntity entity = em.find(VisitaEntity.class, newEntity.getId());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
    }
    
    @Test
    public void buscarVisitasTest(){
        

    }
    
    @Test
    public void buscarVisitaIdTest(){
        VisitaEntity entity = data.get(0);
        VisitaEntity newEntity = visitaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    @Test
    public void eliminarVisitaIdTest(){
        VisitaEntity entity = data.get(0);
        visitaPersistence.delete(entity.getId());
        VisitaEntity deleted = em.find(VisitaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void actualizarVisitaTest(){
        VisitaEntity entity = data.get(0);
        VisitaEntity newEntity = factory.manufacturePojo(VisitaEntity.class);
        newEntity.setId(entity.getId());

        visitaPersistence.update(newEntity);

        VisitaEntity resp = em.find(VisitaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
    
}
