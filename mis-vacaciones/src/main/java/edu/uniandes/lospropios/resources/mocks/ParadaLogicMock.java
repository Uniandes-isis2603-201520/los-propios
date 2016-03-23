/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import edu.uniandes.lospropios.resources.dtos.ParadaDTO;
import edu.uniandes.lospropios.resources.exceptions.ParadaLogicException;
import java.util.ArrayList;
import java.util.List;
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
public class ParadaLogicMock {
// objeto para presentar logs de las operaciones

    private final static Logger LOGGER = Logger.getLogger(ParadaLogicMock.class.getName());
    private final static String ERROR = "No existe una parada con ese id";

    // listado de itinerarios
    private static ArrayList<ParadaDTO> paradas;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ParadaLogicMock() {

        if (paradas == null) {
            paradas = new ArrayList<>();
            paradas.add(new ParadaDTO(1L, "paradaUno", "Cali", "Festival de la salsa", "01/02/2015", "02/02/2015"));
            paradas.add(new ParadaDTO(2L, "paradaDos", "Pasto", "Festival de blancos y negros", "02/02/2015", "05/02/2015"));
            paradas.add(new ParadaDTO(3L, "paradaTres", "Ibague", "Festival musical", "04/02/2015", "07/02/2015"));
        }

        // indica que se muestren todos los mensajes
        LOGGER.setLevel(Level.INFO);

        // muestra información
        LOGGER.info("Inicializa la lista de paradas");
        LOGGER.info("Paradas: " + paradas);
    }

    /**
     * Obtiene el listado de paradas.
     *
     * @return lista de paradas
     * @throws ParadaLogicException cuando no existe la lista en memoria
     */
    public List<ParadaDTO> getParadas() throws ParadaLogicException {
        if (paradas == null) {
            LOGGER.severe("Error interno: lista de paradas no existe.");
            throw new ParadaLogicException("Error interno: lista de paradas no existe.");
        }

        LOGGER.info("retornando todas las paradas");
        return paradas;
    }

    /**
     * Obtiene una parada
     *
     * @param id identificador de la parada
     * @return parada encontrada
     * @throws ParadaLogicException cuando la parada no existe
     */
    public ParadaDTO getParada(Long id) throws ParadaLogicException {
        LOGGER.info("recibiendo solicitud de parada con id " + id);

        // busca el paradero con el id suministrado
        for (ParadaDTO parada : paradas) {
            if (Objects.equals(parada.getId(), id)) {
                LOGGER.info("retornando parada " + parada);
                return parada;
            }
        }

        // si no encuentra el itinerario
        LOGGER.severe(ERROR);
        throw new ParadaLogicException(ERROR);
    }

    /**
     * Agrega una parada a la lista.
     *
     * @param newParada parada a adicionar
     * @throws ParadaLogicException cuando ya existe una parada con el id
     * suministrado
     * @return parada agregada
     */
    public ParadaDTO createParada(ParadaDTO newParada) throws ParadaLogicException {
        LOGGER.info("recibiendo solicitud de agregar parada " + newParada);

        // el nuevo parada tiene id ?
        if (newParada.getId() != null) {
            // busca la parada con el id suministrado
            for (ParadaDTO parada : paradas) {
                // si existe una parada con ese id
                if (Objects.equals(parada.getId(), newParada.getId())) {
                    LOGGER.severe("Ya existe una parada con ese id");
                    throw new ParadaLogicException("Ya existe una parada con ese id");
                }
            }

            // la nueva parada no tiene id ?
        } else {

            // genera un id para la parada
            LOGGER.info("Generando id para la nueva parada");
            long newId = 1;
            for (ParadaDTO parada : paradas) {
                if (newId <= parada.getId()) {
                    newId = parada.getId() + 1;
                }
            }
            newParada.setId(newId);
        }

        // agrega la parada
        LOGGER.info("agregando parada " + newParada);
        paradas.add(newParada);
        return newParada;
    }

    /**
     * Actualiza los datos de una parada
     *
     * @param id identificador de la parada a modificar
     * @param parada parada a modificar
     * @return datos de la parada modificada
     * @throws ParadaLogicException cuando no existe una parada con el id
     * suministrado
     */
    public ParadaDTO updateParada(Long id, ParadaDTO updatedParada) throws ParadaLogicException {
        LOGGER.info("recibiendo solictud de modificar parada " + updatedParada);

        // busca la parada con el id suministrado
        for (ParadaDTO parada : paradas) {
            if (Objects.equals(parada.getId(), id)) {

                // modifica la parada
                parada.setId(updatedParada.getId());
                parada.setFechaInicio(updatedParada.getFechaInicio());

                // retorna la parada modificada
                LOGGER.info("Modificando parada " + parada);
                return parada;
            }
        }

        // no encontró la parada con ese id ?
        LOGGER.severe(ERROR);
        throw new ParadaLogicException(ERROR);
    }

    /**
     * Elimina los datos de una parada
     *
     * @param id identificador de la parada a eliminar
     * @throws ParadaLogicException cuando no existe una parada con el id
     * suministrado
     */
    public void deleteParada(Long id) throws ParadaLogicException {
        LOGGER.info("recibiendo solicitud de eliminar paradai con id " + id);

        // busca el itinerario con el id suministrado
        for (ParadaDTO parada : paradas) {
            if (Objects.equals(parada.getId(), id)) {

                // elimina la parada
                LOGGER.info("eliminando parada " + parada);
                paradas.remove(parada);
                return;
            }
        }

        // no encontró la parada con ese id ?
        LOGGER.severe(ERROR);
        throw new ParadaLogicException(ERROR);
    }
}
