/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import edu.uniandes.lospropios.resources.dtos.PerfilDTO;
import edu.uniandes.lospropios.resources.exceptions.PerfilLogicException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author mc.hernandez1
 */
@Named
@ApplicationScoped
public class PerfilLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(PerfilLogicMock.class.getName());

    // listado de ciudades
    private static ArrayList<PerfilDTO> perfiles;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public PerfilLogicMock() {

        if (perfiles == null) {
            perfiles = new ArrayList<>();
            perfiles.add(new PerfilDTO(1L, "Camila"));
            perfiles.add(new PerfilDTO(2L, "Hector"));
            perfiles.add(new PerfilDTO(3L, "Andres"));
        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información
        logger.info("Inicializa la lista de ciudades");
        logger.info("ciudades" + perfiles);
    }

    public String getPerfil() throws PerfilLogicException {
        if (perfiles == null) {
            logger.severe("Error interno: lista de ciudades no existe.");
            throw new PerfilLogicException("Error interno: lista de ciudades no existe.");
        }

        logger.info("retornando el primer perfil");
        return perfiles.get(0).getPerfil();
    }

    public PerfilDTO createPerfil(PerfilDTO perfil) throws PerfilLogicException {
        logger.info("recibiendo solicitud de agregar ciudad " + perfil);

        // la nueva ciudad tiene id ?
        if (perfil.getId() != null) {
            // busca la ciudad con el id suministrado
            for (PerfilDTO actual : perfiles) {
                // si existe una ciudad con ese id
                if (Objects.equals(actual.getId(), perfil.getId())) {
                    logger.severe("Ya existe una ciudad con ese id");
                    throw new PerfilLogicException("Ya existe una ciudad con ese id");
                }
            }

            // la nueva ciudad no tiene id ?
        } else {

            // genera un id para la ciudad
            logger.info("Generando id paa la nueva ciudad");
            long newId = 1;
            for (PerfilDTO actual : perfiles) {
                if (newId <= actual.getId()) {
                    newId = actual.getId() + 1;
                }
            }
            perfil.setId(newId);
        }

        // agrega la ciudad
        logger.info("agregando ciudad " + perfil);
        perfiles.add(perfil);
        return perfil;
    }

    public PerfilDTO updatePerfil(Long id, PerfilDTO perfil) throws PerfilLogicException {
        logger.info("recibiendo solictud de modificar ciudad " + perfil);

        // busca la ciudad con el id suministrado
        for (PerfilDTO actual : perfiles) {
            if (Objects.equals(actual.getId(), id)) {

                // modifica la ciudad
                actual.setId(perfil.getId());
                actual.setName(perfil.getPerfil());

                // retorna la ciudad modificada
                logger.info("Modificando ciudad " + actual);
                return actual;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new PerfilLogicException("No existe una ciudad con ese id");
    }

    public void deletePerfil(Long id) throws PerfilLogicException {
        logger.info("recibiendo solictud de eliminar ciudad con id " + id);

        // busca la ciudad con el id suministrado
        for (PerfilDTO actual : perfiles) {
            if (Objects.equals(actual.getId(), id)) {

                // elimina la ciudad
                logger.info("eliminando ciudad " + actual);
                perfiles.remove(actual);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new PerfilLogicException("No existe una ciudad con ese id");
    }

}
