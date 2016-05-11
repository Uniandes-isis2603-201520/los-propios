/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author js.gomez14
 */
@XmlRootElement
public class EventoDTO {

    /**
     * Representa si la actividad es un evento.
     */
    public static final String EVENTO = "Evento";

    /**
     * Representa si la actividad es un sitio de interes.
     */
    public static final String SITIO_INTERES = "SitioInteres";

    /**
     * Representa el id de la actividad.
    *
     */
    private Long id;

    /**
     * Representa el nombre de la actividad.
     */
    private String name;

    /**
     * Representa la descripción de la actividad.
     */
    private String descripcion;

    /**
     * Representa la descripción de la actividad.
     */
    private String tipo;

    /**
     * Representa el lugar de la actividad.
     */
    private String lugar;

    /**
     * Representa la fecha de la actividad, si clasificación == "SITIO_INTERES"
     * entonces la fecha es null.
     */
    private Date fecha;

    /**
     * Representa el costo de la actividad.
     */
    private Double precio;

    /**
     * Representa la imagen que representa la actividad.
     */
    private String img;

    /**
     * Representa si la actividad es un evento o un Sitio de interes.
     */
    private String clasificacion;

    /*
    *Representa la visita relacionada con el evento
    */
    private VisitaDTO visita;

    /**
     * @return actividad
     */
    private VisitaDTO getVisita()
    {
        return visita;
    }

    /**
     * @param visita the 'visita' to set
     */
    public void setVisita(VisitaDTO visita)
    {
        this.visita = visita;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return la descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param desc la descripción
     */
    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    /**
     * @return el lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar el lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return el tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo el tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    /**
     * @return la fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha la fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return el precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio el precio
     */
    public void setPrecio(Double precio)
    {
        this.precio = precio;
    }

    /**
     * @return la url de la imagen
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img la url de la imagen
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return la clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clas la clasificación
     */
    public void setClasificacion(String clas) {
        this.clasificacion = clas;
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName()+ "\" }";
    }
}
