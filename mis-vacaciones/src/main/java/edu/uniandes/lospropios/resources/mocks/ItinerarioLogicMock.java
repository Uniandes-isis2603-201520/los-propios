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

    // listado de ciudades
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

        logger.info("retornando todas las ciudades");
        return itinerarios;
    }

    /**
     * Obtiene un itinerario
     *
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    public ItinerarioDTO getCity(Long id) throws ItinerarioLogicException {
        logger.info("recibiendo solicitud de ciudad con id " + id);

        // busca la ciudad con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {
                logger.info("retornando ciudad " + itinerario);
                return itinerario;
            }
        }

        // si no encuentra la ciudad
        logger.severe("No existe ciudad con ese id");
        throw new ItinerarioLogicException("No existe un itinerario con ese id");
    }

    /**
     * Agrega una ciudad a la lista.
     *
     * @param newItinerario ciudad a adicionar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     * @return ciudad agregada
     */
    public ItinerarioDTO createItinerario(ItinerarioDTO newItinerario) throws ItinerarioLogicException {
        logger.info("recibiendo solicitud de agregar ciudad " + newItinerario);

        // la nueva ciudad tiene id ?
        if (newItinerario.getId() != null) {
            // busca la ciudad con el id suministrado
            for (ItinerarioDTO itinerario : itinerarios) {
                // si existe una ciudad con ese id
                if (Objects.equals(itinerario.getId(), newItinerario.getId())) {
                    logger.severe("Ya existe una ciudad con ese id");
                    throw new ItinerarioLogicException("Ya existe una ciudad con ese id");
                }
            }

            // la nueva ciudad no tiene id ?
        } else {

            // genera un id para la ciudad
            logger.info("Generando id paa la nueva ciudad");
            long newId = 1;
            for (ItinerarioDTO itinerario : itinerarios) {
                if (newId <= itinerario.getId()) {
                    newId = itinerario.getId() + 1;
                }
            }
            newItinerario.setId(newId);
        }

        // agrega la ciudad
        logger.info("agregando ciudad " + newItinerario);
        itinerarios.add(newItinerario);
        return newItinerario;
    }

    /**
     * Actualiza los datos de una ciudad
     *
     * @param id identificador de la ciudad a modificar
     * @param itinerario ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id
     * suministrado
     */
    public ItinerarioDTO updateCity(Long id, ItinerarioDTO updatedCity) throws ItinerarioLogicException {
        logger.info("recibiendo solictud de modificar ciudad " + updatedCity);

        // busca la ciudad con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {

                // modifica la ciudad
                itinerario.setId(updatedCity.getId());
                itinerario.setFechaInicio(updatedCity.getFechaInicio());

                // retorna la ciudad modificada
                logger.info("Modificando ciudad " + itinerario);
                return itinerario;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new ItinerarioLogicException("No existe una ciudad con ese id");
    }

    /**
     * Elimina los datos de una ciudad
     *
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id
     * suministrado
     */
    public void deleteCity(Long id) throws ItinerarioLogicException {
        logger.info("recibiendo solictud de eliminar ciudad con id " + id);

        // busca la ciudad con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {

                // elimina la ciudad
                logger.info("eliminando ciudad " + itinerario);
                itinerarios.remove(itinerario);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new ItinerarioLogicException("No existe una ciudad con ese id");
    }
}
