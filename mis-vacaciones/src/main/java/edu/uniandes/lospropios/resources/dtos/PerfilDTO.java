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
    private String nombre;
    private String informacionPersonal;
    private String infoAlbumnes;

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
     * @param nombre
     * @param informacionPersonal
     * @param infoAlbumnes
     */
    public PerfilDTO(Long id, String perfil, String nombre, String informacionPersonal, String infoAlbumnes) {
        super();
        this.id = id;
        this.perfil = perfil;
        this.nombre = nombre;
        this.informacionPersonal = informacionPersonal;
        this.infoAlbumnes = infoAlbumnes;

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
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return informacionPersonal
     */
    public String getInformacionPersonal() {
        return informacionPersonal;
    }

    /**
     * @param informacionPersonal the name to set
     */
    public void setInformacionPersonal(String informacionPersonal) {
        this.informacionPersonal = informacionPersonal;
    }

     /**
     * @return infoAlbumnes
     */
    public String getInfoAlbumnes() {
        return infoAlbumnes;
    }

    /**
     * @param infoAlbumnes the name to set
     */
    public void setInfoAlbumnes(String infoAlbumnes) {
        this.infoAlbumnes = infoAlbumnes;
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
