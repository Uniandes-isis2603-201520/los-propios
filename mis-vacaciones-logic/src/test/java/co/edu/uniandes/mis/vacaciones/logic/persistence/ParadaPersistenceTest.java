/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.ParadaEntity;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hj.calderon10
 */
public class ParadaPersistenceTest {

    public ParadaPersistenceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class ParadaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        long id = 0L;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ParadaPersistence instance = (ParadaPersistence)container.getContext().lookup("java:global/classes/ParadaPersistence");
        ParadaEntity expResult = null;
        ParadaEntity result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ParadaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ParadaPersistence instance = (ParadaPersistence)container.getContext().lookup("java:global/classes/ParadaPersistence");
        List<ParadaEntity> expResult = null;
        List<ParadaEntity> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ParadaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ParadaEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ParadaPersistence instance = (ParadaPersistence)container.getContext().lookup("java:global/classes/ParadaPersistence");
        ParadaEntity expResult = null;
        ParadaEntity result = instance.create(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ParadaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        ParadaEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ParadaPersistence instance = (ParadaPersistence)container.getContext().lookup("java:global/classes/ParadaPersistence");
        ParadaEntity expResult = null;
        ParadaEntity result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ParadaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ParadaPersistence instance = (ParadaPersistence)container.getContext().lookup("java:global/classes/ParadaPersistence");
        instance.delete(id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
