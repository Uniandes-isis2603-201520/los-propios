/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author s.trujillo10
 */
public class CiudadDTO {

    private Long id;
    private String name;
    private String country;
    private double calificacion;
    private int numerClasificaciones;
    private ArrayList<EventoDTO> eventos;

    public CiudadDTO() {

    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador de la ciudad
     * @param name nombre de la ciudad
     * @param country nombre del pais
     */
    public CiudadDTO(Long id, String name, String country) {
        super();
        this.id = id;
        this.name = name;
        this.country = country;
        calificacion = -1;
        numerClasificaciones = -1;
        eventos = new ArrayList<>();
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
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public double getCalificacion() {
        return ((int)calificacion == -1) ? 0 : calificacion;
    }

    public void setCalificacion(double cal) {
        numerClasificaciones++;
        if ((int)calificacion == -1) {
            calificacion = cal;
        } else {
            calificacion = (((numerClasificaciones - 1) * calificacion) + cal) / numerClasificaciones;
        }
    }

    public boolean addEvent(EventoDTO x) {
        boolean rta = false;
        if (!existeEvento(x)) {
            eventos.add(x);
            rta = true;
        }
        return rta;

    }

    public boolean existeEvento(EventoDTO x) {
        boolean rta = false;
        for (int i = 0; i < eventos.size() && !rta; i++) {
            EventoDTO actual = eventos.get(i);
            if (Objects.equals(x.getId(), actual.getId())) {
                rta = true;
            }
        }
        return rta;
    }

    /**
     * Convierte el objeto a una cadena
     *
     * @return
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\" }";
    }

}
