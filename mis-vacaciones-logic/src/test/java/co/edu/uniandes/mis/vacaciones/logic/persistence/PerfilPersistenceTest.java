/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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


    private final PodamFactory factory = new PodamFactoryImpl();

    public PerfilPersistenceTest() {
    }

    @Test
    public void createPerfilTest() {
        PerfilEntity newEntity = factory.manufacturePojo(PerfilEntity.class);

        PerfilEntity result = perfilPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PerfilEntity entity = em.find(PerfilEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of find method, of class PerfilPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PerfilPersistence instance = (PerfilPersistence) container.getContext().lookup("java:global/classes/PerfilPersistence");
        PerfilEntity expResult = null;
        PerfilEntity result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class PerfilPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PerfilPersistence instance = (PerfilPersistence) container.getContext().lookup("java:global/classes/PerfilPersistence");
        List<PerfilEntity> expResult = null;
        List<PerfilEntity> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PerfilPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        PerfilEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PerfilPersistence instance = (PerfilPersistence) container.getContext().lookup("java:global/classes/PerfilPersistence");
        PerfilEntity expResult = null;
        PerfilEntity result = instance.create(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PerfilPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PerfilEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PerfilPersistence instance = (PerfilPersistence) container.getContext().lookup("java:global/classes/PerfilPersistence");
        PerfilEntity expResult = null;
        PerfilEntity result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PerfilPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PerfilPersistence instance = (PerfilPersistence) container.getContext().lookup("java:global/classes/PerfilPersistence");
        instance.delete(id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
