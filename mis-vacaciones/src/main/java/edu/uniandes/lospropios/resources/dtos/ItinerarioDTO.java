
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;


/**
 *
 * @author  jg.murillo10
 */
public class ItinerarioDTO {

    private Long id;
    private String nombreItinerario;

    private String fechaInicio;
    private String fechaFin;


    /**
     * Método necesario para NetBeans
     */
    public ItinerarioDTO(){
        //No se puede ejecutar el DTO sin este método.
    }


    public ItinerarioDTO(Long id, String nombreItinerario, String fechaInicio, String fechaFin) {
        super();
        this.id = id;
        this.nombreItinerario=nombreItinerario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreItinerario(){
        return nombreItinerario;
    }
    public void setNombreItinerario(String n){
        this.nombreItinerario=n;
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
