
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

    private Long idItinerario;
    private String nombreItinerario;
    private String fechaInicio;
    private String fechaFin;


    /**
     * Método necesario para NetBeans
     */
    public ItinerarioDTO(){
        //No se puede ejecutar el DTO sin este método.
    }


    public ItinerarioDTO(Long idItinerario, String nombreItinerario, String fechaInicio, String fechaFin) {
        super();
        this.idItinerario = idItinerario;
        this.nombreItinerario=nombreItinerario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }

    public Long getId() {
        return idItinerario;
    }

    public void setId(Long idItinerario) {
        this.idItinerario = idItinerario;
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
