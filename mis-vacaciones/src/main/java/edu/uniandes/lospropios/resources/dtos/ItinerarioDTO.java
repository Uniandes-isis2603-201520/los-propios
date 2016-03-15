
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

import java.util.Date;

/**
 *
 * @author josedanielcardenasrincon
 */
public class ItinerarioDTO {

    private Long id;
    private String fechaInicio;
    private String fechaFin;

    public ItinerarioDTO() {
    }

    public ItinerarioDTO(Long id, String fechaInicio, String fechaFin) {
        super();
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
