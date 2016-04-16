/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import java.util.*;
import java.util.logging.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import edu.uniandes.lospropios.resources.dtos.*;
import edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException;

/**
 *
 * @author jg.murillo10
 */
/**
 * Mock del recurso Itinerarios (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class ItinerarioLogicMock {
// objeto para presentar logs de las operaciones

    private final static Logger LOGGER = Logger.getLogger(ItinerarioLogicMock.class.getName());
    private final static String ERROR = "No existe un itinerario con ese id";

    // listado de itinerarios
    private static ArrayList<ItinerarioDTO> itinerarios;
    // listado de perfiles
    private static ArrayList<PerfilDTO> perfiles;
    // listado de paradas
    private static ArrayList<ParadaDTO> paradas;
    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ItinerarioLogicMock() {

        if (itinerarios == null) {
            //Inicializa la lista de itinerarios
            itinerarios = new ArrayList<>();
            //Inicializa la lista de paradas
            paradas = new ArrayList<>();
            //Crea paradas para asociales a los itinerarios
            ParadaDTO p1 = new ParadaDTO(4L, "nombre1", "ciudad1", "actividad1", new Date(), new Date());
            ParadaDTO p2 = new ParadaDTO(5L, "nombre2", "ciudad2", "actividad2", new Date(), new Date());
            ParadaDTO p3 = new ParadaDTO(6L, "nombre3", "ciudad3", "actividad3", new Date(), new Date());
            //Agrega itinerarios a la lista y les agrega una parada a cada uno
            itinerarios.add(new ItinerarioDTO(1L,"Itinerario 1", new Date(), new Date()));
            itinerarios.get(0).addParada(p1);
            itinerarios.add(new ItinerarioDTO(2L,"Itinerario 2", new Date(), new Date()));
            itinerarios.get(1).addParada(p2);
            itinerarios.add(new ItinerarioDTO(3L,"Itinerario 3", new Date(), new Date()));
            itinerarios.get(2).addParada(p3);
        }

        // indica que se muestren todos los mensajes
        LOGGER.setLevel(Level.INFO);

        // muestra información
        LOGGER.info("Inicializa la lista de itinerarios");
        LOGGER.info("itinerarios" + itinerarios);
    }

    /**
     * Obtiene el listado de itinerarios.
     *
     * @return lista de itinerarios
     * @throws ItinerarioLogicException cuando no existe la lista en memoria
     */
    public List<ItinerarioDTO> getItinerarios() throws ItinerarioLogicException {
        if (itinerarios == null) {
            LOGGER.severe("Error interno: lista de itinerarios no existe.");
            throw new ItinerarioLogicException("Error interno: lista de itinerarios no existe.");
        }

        LOGGER.info("retornando todas las itinerarios");
        return itinerarios;
    }

    /**
     * Obtiene un itinerario
     *
     * @param idItinerario identificador de el itinerario
     * @return itinerario encontrada
     * @throws ItinerarioLogicException cuando el itinerario no existe
     */
    public ItinerarioDTO getItinerario(Long idItinerario) throws ItinerarioLogicException {
        LOGGER.info("recibiendo solicitud de itinerario con id " + idItinerario);

        // busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getIdItinerario(), idItinerario)) {
                LOGGER.info("retornando itinerario " + itinerario);
                return itinerario;
            }
        }

        // si no encuentra el itinerario
        LOGGER.severe(ERROR);
        throw new ItinerarioLogicException(ERROR);
    }

     /**
     * Obtiene una parada
     * @param idItinerario identificador del itinerario
     * @param idPerfilUsuario identificador del perfil usuario
     * @return itinerario encontrado
     * @throws ItinerarioLogicException cuando el itinerario no existe
     */
    public ItinerarioDTO getItinerarioUsuario(Long idPerfilUsuario, Long idItinerario) throws ItinerarioLogicException {
        LOGGER.info("recibiendo solicitud de perifl usuario con Itinerario" + idPerfilUsuario);

        // busca el paradero que le pertenece al id del viajero
        for (PerfilDTO perfil: perfiles)
        {
            if (Objects.equals(perfil.getId(), idPerfilUsuario))
            {
                for(ItinerarioDTO itinerario: itinerarios)
                {
                    if(Objects.equals(itinerario.getIdItinerario(), idItinerario))
                    {
                             LOGGER.info("retornando parada " + itinerario);
                             return itinerario;

                    }
                }
            }
        }


        // si no encuentra el itinerario
        LOGGER.severe(ERROR);
        throw new ItinerarioLogicException(ERROR);
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
        LOGGER.info("recibiendo solicitud de agregar itinerario " + newItinerario);

        // el nuevo itinerario tiene id ?
        if (newItinerario.getIdItinerario()!= null) {
            // busca el itinerario con el id suministrado
            for (ItinerarioDTO itinerario : itinerarios) {
                // si existe un itinerario con ese id
                if (Objects.equals(itinerario.getIdItinerario(), newItinerario.getIdItinerario())) {
                    LOGGER.severe("Ya existe un itinerario con ese id");
                    throw new ItinerarioLogicException("Ya existe un itinerario con ese id");
                }
            }

            // el nuevo itinerario no tiene id ?
        } else {

            // genera un id para el itinerario
            LOGGER.info("Generando id paa el nuevo itinerario");
            long newId = 1;
            for (ItinerarioDTO itinerario : itinerarios) {
                if (newId <= itinerario.getIdItinerario()) {
                    newId = itinerario.getIdItinerario()+ 1;
                }
            }
            newItinerario.setIdItinerario(newId);
        }

        // agrega el itinerario
        LOGGER.info("agregando itinerario " + newItinerario);
        itinerarios.add(newItinerario);
        return newItinerario;
    }

    /**
     * Actualiza los datos de un itinerario
     *
     * @param id identificador de el itinerario a modificar
     * @param updatedItinerario
     * @return datos de el itinerario modificada
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     */
    public ItinerarioDTO updateItinerario(Long id, ItinerarioDTO updatedItinerario) throws ItinerarioLogicException {
        LOGGER.info("recibiendo solictud de modificar itinerario " + updatedItinerario);

        // busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getIdItinerario(), id)) {

                // modifica el itinerario
                itinerario.setIdItinerario(updatedItinerario.getIdItinerario());
                itinerario.setFechaInicio(updatedItinerario.getFechaInicio());

                // retorna el itinerario modificada
                LOGGER.info("Modificando itinerario " + itinerario);
                return itinerario;
            }
        }

        // no encontró el itinerario con ese id ?
        LOGGER.severe(ERROR);
        throw new ItinerarioLogicException(ERROR);
    }

    /**
     * Elimina los datos de un itinerario
     *
     * @param id identificador de el itinerario a eliminar
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     */
    public void deleteItinerario(Long id) throws ItinerarioLogicException {
        LOGGER.info("recibiendo solictud de eliminar itinerario con id " + id);

        // busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getIdItinerario(), id)) {

                // elimina el itinerario
                LOGGER.info("eliminando itinerario " + itinerario);
                itinerarios.remove(itinerario);
                return;
            }
        }

        // no encontró el itinerario con ese id ?
        LOGGER.severe(ERROR);
        throw new ItinerarioLogicException(ERROR);
    }
}
