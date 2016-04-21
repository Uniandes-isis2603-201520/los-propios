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
public class VisitaDTO {

    private Long id;
    private int ordenVisita;
    private double calificacion;
    private Date fecha;
    private EventoDTO evento;

    /**
     * Método necesario para NetBeans
     */
    public VisitaDTO(){
        //No se puede ejecutar el DTO sin este método.
    }


    public VisitaDTO(long id,int ordenVisita, double calificacion, Date fecha) {
        this.id=id;
        this.ordenVisita = ordenVisita;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrdenVisita() {
        return ordenVisita;
    }

    public void setOrdenVisita(int ordenVisita) {
        this.ordenVisita = ordenVisita;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EventoDTO getEvento() {
        return evento;
    }

    public void setEvento(EventoDTO evento) {
        this.evento = evento;
    }

    

}
