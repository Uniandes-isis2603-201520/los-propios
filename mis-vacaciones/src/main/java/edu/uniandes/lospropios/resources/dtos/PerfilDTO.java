/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Objeto de transferencia de datos del perfil.
 *
 * @author mc.hernandez1
 */
@XmlRootElement
public class PerfilDTO {

    private Long id;
    private String nombre;
    private Integer cedula;
    private Integer edad;
    private Date fechaNacimiento;
    private String profesion;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * Convierte el objeto a una cadena
     *
     * @return
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", ciudad : \"" + getNombre() + "\" }";
    }
}
