/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

import java.util.Date;

/**
 *
 * @author js.gomez14
 */
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
    private String nombre;

    /**
     * Representa la descripción de la actividad.
     */
    private String descripcion;

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
    private double precio;

    /**
     * Representa la imagen que representa la actividad.
     */
    private String img;

    /**
     * Representa si la actividad es un evento o un Sitio de interes.
     */
    private String clasificacion;

    /**
     * Método necesario para NetBeans
     */
    public EventoDTO(){
        //No se puede ejecutar el DTO sin este método.
    }
    /**
     * Constructor con parámetros.
     *
     * @param id identificador de la actividad.
     * @param name nombre de la actividad.
     * @param desc descripcion de la actividad.
     * @param lugar lugar de la actividad.
     */
    public EventoDTO(Long id, String name, String desc, String lugar) {
        super();
        this.id = id;
        this.nombre = name;
        this.descripcion = desc;
        this.lugar = lugar;
    }

    /**
     *
     * @param fecha fecha de la actividad (Null si clasificacion ==
     * SITIO_INTERES).
     * @param precio precio de la actividad.
     * @param img url de la imagen que representa la actividad.
     * @param clas clasificacion de la actividad.
     */
    public void agregarPreferenciasEvento(Date fecha, double precio, String img, String clas) {

        this.clasificacion = clas;
        if (clas.equalsIgnoreCase(SITIO_INTERES)) {
            this.fecha = null;
        } else if (clas.equalsIgnoreCase(EVENTO)) {
            this.fecha = fecha;
        }
        this.precio = precio;
        this.img = img;
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
    public String getNombre() {
        return nombre;
    }

    /**
     * @param name the name to set
     */
    public void setNombre(String name) {
        this.nombre = name;
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
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio el precio
     */
    public void setPrecio(double precio) {
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
        return "{ id : " + getId() + ", name : \"" + getNombre() + "\" }";
    }

}
