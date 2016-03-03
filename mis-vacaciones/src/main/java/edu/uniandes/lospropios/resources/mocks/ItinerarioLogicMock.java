/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import edu.uniandes.lospropios.resources.dtos.ItinerarioDTO;
import edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException;
/**
 *
 * @author mc.hernandez1
 */
/**
 * Mock del recurso Ciudades (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class ItinerarioLogicMock {
// objeto para presentar logs de las operaciones

    private final static Logger logger = Logger.getLogger(ItinerarioLogicMock.class.getName());

    // listado de itinerarios
    private static ArrayList<ItinerarioDTO> itinerarios;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ItinerarioLogicMock() {

        if (itinerarios == null) {
            itinerarios = new ArrayList<>();
            itinerarios.add(new ItinerarioDTO(1L,"02/05/2015","04/05/2015"));
            itinerarios.add(new ItinerarioDTO(2L, "01/02/2015","02/05/2015"));
            itinerarios.add(new ItinerarioDTO(3L, "05/03/2016","07/03/2016"));
        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información
        logger.info("Inicializa la lista de itinerarios");
        logger.info("itinerarios" + itinerarios);
    }

    /**
     * Obtiene el listado de itinerarios.
     *
     * @return lista de itinerarios
     * @throws ItinerarioLogicException cuando no existe la lista en memoria
     */
    public List<ItinerarioDTO> getItinerarios() throws ItinerarioLogicException {
        if (itinerarios == null) {
            logger.severe("Error interno: lista de itinerarios no existe.");
            throw new ItinerarioLogicException("Error interno: lista de itinerarios no existe.");
        }

        logger.info("retornando todas las itinerarios");
        return itinerarios;
    }

    /**
     * Obtiene un itinerario
     *
     * @param id identificador de el itinerario
     * @return itinerario encontrada
     * @throws ItinerarioLogicException cuando el itinerario no existe
     */
    public ItinerarioDTO getItinerario(Long id) throws ItinerarioLogicException {
        logger.info("recibiendo solicitud de itinerario con id " + id);

        // busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {
                logger.info("retornando itinerario " + itinerario);
                return itinerario;
            }
        }

        // si no encuentra el itinerario
        logger.severe("No existe itinerario con ese id");
        throw new ItinerarioLogicException("No existe un itinerario con ese id");
    }

    /**
     * Agrega un itinerario a la lista.
     *
     * @param newItinerario itinerario a adicionar
     * @throws ItinerarioLogicException cuando ya existe un itinerario con el id
     * suministrado
     * @return itinerario agregada
     */
    public ItinerarioDTO createItinerario(ItinerarioDTO newItinerario) throws ItinerarioLogicException {
        logger.info("recibiendo solicitud de agregar itinerario " + newItinerario);

        // el nuevo itinerario tiene id ?
        if (newItinerario.getId() != null) {
            // busca el itinerario con el id suministrado
            for (ItinerarioDTO itinerario : itinerarios) {
                // si existe un itinerario con ese id
                if (Objects.equals(itinerario.getId(), newItinerario.getId())) {
                    logger.severe("Ya existe un itinerario con ese id");
                    throw new ItinerarioLogicException("Ya existe un itinerario con ese id");
                }
            }

            // el nuevo itinerario no tiene id ?
        } else {

            // genera un id para el itinerario
            logger.info("Generando id paa el nuevo itinerario");
            long newId = 1;
            for (ItinerarioDTO itinerario : itinerarios) {
                if (newId <= itinerario.getId()) {
                    newId = itinerario.getId() + 1;
                }
            }
            newItinerario.setId(newId);
        }

        // agrega el itinerario
        logger.info("agregando itinerario " + newItinerario);
        itinerarios.add(newItinerario);
        return newItinerario;
    }

    /**
     * Actualiza los datos de un itinerario
     *
     * @param id identificador de el itinerario a modificar
     * @param itinerario itinerario a modificar
     * @return datos de el itinerario modificada
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     */
    public ItinerarioDTO updateItinerario(Long id, ItinerarioDTO updatedCity) throws ItinerarioLogicException {
        logger.info("recibiendo solictud de modificar itinerario " + updatedCity);

        // busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {

                // modifica el itinerario
                itinerario.setId(updatedCity.getId());
                itinerario.setFechaInicio(updatedCity.getFechaInicio());

                // retorna el itinerario modificada
                logger.info("Modificando itinerario " + itinerario);
                return itinerario;
            }
        }

        // no encontró el itinerario con ese id ?
        logger.severe("No existe un itinerario con ese id");
        throw new ItinerarioLogicException("No existe un itinerario con ese id");
    }

    /**
     * Elimina los datos de un itinerario
     *
     * @param id identificador de el itinerario a eliminar
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     */
    public void deleteItinerario(Long id) throws ItinerarioLogicException {
        logger.info("recibiendo solictud de eliminar itinerario con id " + id);

        // busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {

                // elimina el itinerario
                logger.info("eliminando itinerario " + itinerario);
                itinerarios.remove(itinerario);
                return;
            }
        }

        // no encontró el itinerario con ese id ?
        logger.severe("No existe un itinerario con ese id");
        throw new ItinerarioLogicException("No existe un itinerario con ese id");
    }
}
