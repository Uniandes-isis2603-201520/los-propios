/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jg.murillo10
 */


@Entity
public class ItinerarioEntity extends BaseEntity implements Serializable {

    private long idItinerario;
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    /**
     * Metodo para obtener el id del itinerario
     * @return id del itinerario
     */

    public long getIdItinerario(){
        return idItinerario;
    }
    /**
     * Metodo para modificar el id del itinerario
     * @param idItinerario  - nuevo id del itinerario
     */
    public void setIdItinerario(long idItinerario){
        this.idItinerario=idItinerario;
    }
    /**
     * Metodo para obtener el nombre de un itinerario
     * @return el nombre del itinerario
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Metodo para modificar el nombre de un itinerario
     * @param nombre - nuevo nombre del itinerario
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    /**
     * Metodo para obtener la fecha inicial del itinerario
     * @return  fecha inicial del itinerario
     */
    public Date getFechaInicial(){
        return fechaInicial;
    }
    /**
     * Metodo para modificar
     * @param fechaInicial
     */
    public void setFechaInicial(Date fechaInicial){
        this.fechaFinal=fechaInicial;
    }

    public Date getFechaFinal(){
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal){
        this.fechaFinal=fechaFinal;
    }


}
