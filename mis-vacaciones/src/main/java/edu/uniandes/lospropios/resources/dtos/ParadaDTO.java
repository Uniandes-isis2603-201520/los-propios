/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;


/**
 *
 * @author mc.hernandez1
 */
public class ParadaDTO {

    private Long id;
    private String nombre;
    private String ciudad;
    private String actividad;
    private String fechaInicio;
    private String fechaFin;



    /**
     * Método necesario para NetBeans
     */
    public ParadaDTO(){
        //No se puede ejecutar el DTO sin este método.
    }

    public ParadaDTO(Long id, String nombre, String ciudad, String actividad, String fechaInicio, String fechaFin) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.actividad = actividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
