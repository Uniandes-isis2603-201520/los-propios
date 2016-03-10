/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import edu.uniandes.lospropios.resources.dtos.VisitaDTO;
import edu.uniandes.lospropios.resources.exceptions.VisitaLogicException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author josedanielcardenasrincon
 */
@Named
@ApplicationScoped
public class VisitaLogicMock {
    
    private final static Logger logger = Logger.getLogger(VisitaLogicMock.class.getName());

    // listado de visitas
    private static ArrayList<VisitaDTO> visitas;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public VisitaLogicMock() {

        if (visitas == null) {
            visitas = new ArrayList<>();
            visitas.add(new VisitaDTO(2L,2,3.5,new Date()));
            visitas.add(new VisitaDTO(3L,3,5,new Date()));
            visitas.add(new VisitaDTO(1L,1,4,new Date()));
        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información
        logger.info("Inicializa la lista de visitas");
        logger.info("visitas" + visitas);
    }

    /**
     * Obtiene el listado de visitas.
     *
     * @return lista de visitas
     * @throws EventoLogicException cuando no existe la lista en memoria
     */
    public List<VisitaDTO> getVisitas() throws VisitaLogicException {
        if (visitas == null) {
            logger.severe("Error interno: lista de visitas no existe.");
            throw new VisitaLogicException("Error interno: lista de visitas no existe.");
        }

        logger.info("retornando todas las visitas");
        return visitas;
    }

    /**
     * Obtiene un visita
     *
     * @param id identificador de el visita
     * @return visita encontrada
     * @throws EventoLogicException cuando el visita no existe
     */
    public VisitaDTO getVisita(Long id) throws VisitaLogicException {
        logger.info("recibiendo solicitud de visita con id " + id);

        // busca el visita con el id suministrado
        for (VisitaDTO visita : visitas) {
            if (Objects.equals(visita.getId(), id)) {
                logger.info("retornando visita " + visita);
                return visita;
            }
        }

        // si no encuentra el visita
        logger.severe("No existe visita con ese id");
        throw new VisitaLogicException("No existe un visita con ese id");
    }

    /**
     * Agrega un visita a la lista.
     *
     * @param newVisita visita a adicionar
     * @throws EventoLogicException cuando ya existe un visita con el id
     * suministrado
     * @return visita agregada
     */
    public VisitaDTO createVisita(VisitaDTO newVisita) throws VisitaLogicException {
        logger.info("recibiendo solicitud de agregar visita " + newVisita);

        // el nuevo visita tiene id ?
        if (newVisita.getId() != null) {
            // busca el visita con el id suministrado
            for (VisitaDTO visita : visitas) {
                // si existe un visita con ese id
                if (Objects.equals(visita.getId(), newVisita.getId())) {
                    logger.severe("Ya existe un visita con ese id");
                    throw new VisitaLogicException("Ya existe un visita con ese id");
                }
            }

            // el nuevo visita no tiene id ?
        } else {

            // genera un id para el visita
            logger.info("Generando id paa el nuevo visita");
            long newId = 1;
            for (VisitaDTO visita : visitas) {
                if (newId <= visita.getId()) {
                    newId = visita.getId() + 1;
                }
            }
            newVisita.setId(newId);
        }

        // agrega el visita
        logger.info("agregando visita " + newVisita);
        visitas.add(newVisita);
        return newVisita;
    }

    /**
     * Actualiza los datos de un visita
     *
     * @param id identificador de el visita a modificar
     * @param updatedCity
     * @return datos de el visita modificada
     * @throws EventoLogicException cuando no existe un visita con el id
     * suministrado
     */
    public VisitaDTO updateVisita(Long id, VisitaDTO updatedVisita) throws VisitaLogicException {
        logger.info("recibiendo solictud de modificar visita " + updatedVisita);

        // busca el visita con el id suministrado
        for (VisitaDTO visita : visitas) {
            if (Objects.equals(visita.getId(), id)) {

                // modifica el visita
                visita.setId(updatedVisita.getId());
                visita.setFecha(updatedVisita.getFecha());
                visita.setCalificacion(updatedVisita.getCalificacion());
                visita.setOrdenVisita(updatedVisita.getOrdenVisita());

                // retorna el visita modificada
                logger.info("Modificando visita " + visita);
                return visita;
            }
        }

        // no encontró el visita con ese id ?
        logger.severe("No existe un visita con ese id");
        throw new VisitaLogicException("No existe un visita con ese id");
    }

    /**
     * Elimina los datos de un visita
     *
     * @param id identificador de el visita a eliminar
     * @throws EventoLogicException cuando no existe un visita con el id
     * suministrado
     */
    public void deleteVisita(Long id) throws VisitaLogicException {
        logger.info("recibiendo solictud de eliminar visita con id " + id);

        // busca el visita con el id suministrado
        for (VisitaDTO visita : visitas) {
            if (Objects.equals(visita.getId(), id)) {

                // elimina el visita
                logger.info("eliminando visita " + visita);
                visitas.remove(visita);
                return;
            }
        }

        // no encontró el visita con ese id ?
        logger.severe("No existe un visita con ese id");
        throw new VisitaLogicException("No existe un visita con ese id");
    }
}
