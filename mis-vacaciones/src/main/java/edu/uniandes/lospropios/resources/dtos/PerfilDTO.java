/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

/**
 * Objeto de transferencia de datos del perfil.
 * @author mc.hernandez1
 */

public class PerfilDTO {

    private Long id;
    private String ciudad;

    /**
     * Constructor por defecto
     */
    public PerfilDTO() {
	}

    /**
     * Constructor con parámetros.
     *   $scope.albumnes = [];
            $scope.id = "";
            $scope.ciudad = "";
            $scope.descripcion = "";
     * @param id identificador del album
     * @param ciudad ciudad donde se realizo el album
     */
    public PerfilDTO(Long id, String ciudad) {
		super();
		this.id = id;
		this.ciudad = ciudad;

	}

	/**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the name to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", ciudad : \"" + getCiudad() + "\" }" ;
    }
}
