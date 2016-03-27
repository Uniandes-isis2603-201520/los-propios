/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

/**
 * Objeto de transferencia de datos del perfil.
 *
 * @author mc.hernandez1
 */
public class PerfilDTO {

    private Long id;
    private String perfil;

    /**
     * Método necesario para NetBeans
     */
    public PerfilDTO(){
        //No se puede ejecutar el DTO sin este método.
    }


    /**
     * Constructor con parámetros. $scope.albumnes = []; $scope.id = "";
     * $scope.ciudad = ""; $scope.descripcion = "";
     *
     * @param id identificador del album
     * @param perfil perfil donde se realizo el album
     */
    public PerfilDTO(Long id, String perfil) {
        super();
        this.id = id;
        this.perfil = perfil;

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
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the name to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Convierte el objeto a una cadena
     * @return
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", ciudad : \"" + getPerfil() + "\" }";
    }

    public void setName(String perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
