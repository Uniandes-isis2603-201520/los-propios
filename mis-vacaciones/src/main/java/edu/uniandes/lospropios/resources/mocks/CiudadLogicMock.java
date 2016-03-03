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

import edu.uniandes.lospropios.resources.dtos.CiudadDTO;
import edu.uniandes.lospropios.resources.exceptions.CiudadLogicException;
/**
 *
 * @author s.trujillo10
 */
public class CiudadLogicMock {
// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(CiudadLogicMock.class.getName());

	// listado de ciudades
    private static ArrayList<CiudadDTO> cities;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public CiudadLogicMock() {

    	if (cities == null) {
            cities = new ArrayList<>();
            cities.add(new CiudadDTO(1L, "Bogota"));
            cities.add(new CiudadDTO(2L, "Cali"));
            cities.add(new CiudadDTO(3L, "Medellin"));
        }

    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("ciudades" + cities );
    }

	/**
	 * Obtiene el listado de personas.
	 * @return lista de ciudades
	 * @throws CityLogicException cuando no existe la lista en memoria
	 */
    public List<CiudadDTO> getCities() throws CiudadLogicException {
    	if (cities == null) {
    		logger.severe("Error interno: lista de ciudades no existe.");
    		throw new CiudadLogicException("Error interno: lista de ciudades no existe.");
    	}

    	logger.info("retornando todas las ciudades");
    	return cities;
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    public CiudadDTO getCity(Long id) throws CiudadLogicException {
    	logger.info("recibiendo solicitud de ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (CiudadDTO city : cities) {
            if (Objects.equals(city.getId(), id)){
            	logger.info("retornando ciudad " + city);
                return city;
            }
        }

        // si no encuentra la ciudad
        logger.severe("No existe ciudad con ese id");
        throw new CiudadLogicException("No existe ciudad con ese id");
    }

    /**
     * Agrega una ciudad a la lista.
     * @param newCity ciudad a adicionar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     * @return ciudad agregada
     */
    public CiudadDTO createCity(CiudadDTO newCity) throws CiudadLogicException {
    	logger.info("recibiendo solicitud de agregar ciudad " + newCity);

    	// la nueva ciudad tiene id ?
    	if ( newCity.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (CiudadDTO city : cities) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(city.getId(), newCity.getId())){
	            	logger.severe("Ya existe una ciudad con ese id");
	                throw new CiudadLogicException("Ya existe una ciudad con ese id");
	            }
	        }

	    // la nueva ciudad no tiene id ?
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		long newId = 1;
	        for (CiudadDTO city : cities) {
	            if (newId <= city.getId()){
	                newId =  city.getId() + 1;
	            }
	        }
	        newCity.setId(newId);
    	}

        // agrega la ciudad
    	logger.info("agregando ciudad " + newCity);
        cities.add(newCity);
        return newCity;
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public CiudadDTO updateCity(Long id, CiudadDTO updatedCity) throws CiudadLogicException {
    	logger.info("recibiendo solictud de modificar ciudad " + updatedCity);

    	// busca la ciudad con el id suministrado
        for (CiudadDTO city : cities) {
            if (Objects.equals(city.getId(), id)) {

            	// modifica la ciudad
            	city.setId(updatedCity.getId());
                city.setName(updatedCity.getName());

                // retorna la ciudad modificada
            	logger.info("Modificando ciudad " + city);
                return city;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new CiudadLogicException("No existe una ciudad con ese id");
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public void deleteCity(Long id) throws CiudadLogicException {
    	logger.info("recibiendo solictud de eliminar ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (CiudadDTO city : cities) {
            if (Objects.equals(city.getId(), id)) {

            	// elimina la ciudad
            	logger.info("eliminando ciudad " + city);
                cities.remove(city);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new CiudadLogicException("No existe una ciudad con ese id");
    }
}
