/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jg.murillo10
 */


@Entity
public class ItinerarioEntity extends BaseEntity implements Serializable {

    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @OneToMany
    @PodamExclude
    private List<ParadaEntity> paradas = new ArrayList<>();

//    /**
//     * Metodo para obtener el id del itinerario
//     * @return id del itinerario
//     */
//
//    public long getIdItinerario(){
//        return idItinerario;
//    }
//    /**
//     * Metodo para modificar el id del itinerario
//     * @param idItinerario  - nuevo id del itinerario
//     */
//    public void setIdItinerario(long idItinerario){
//        this.idItinerario=idItinerario;
//    }
    /**
     * Metodo para obtener el nombre de un itinerario
     * @return el nombre del itinerario

    public String getNombre(){
        return nombre;
    }
    /**
     * Metodo para modificar el nombre de un itinerario
     * @param nombre - nuevo nombre del itinerario

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
    /**
     * Metodo para obtener la fecha final del itinerario
     * @return  - fecha final del itinerario
     */
    public Date getFechaFinal(){
        return fechaFinal;
    }
    /**
     * Metodo para modificar la fecha final del itinerario
     * @param fechaFinal  - nueva fecha final del itinerario
     */
    public void setFechaFinal(Date fechaFinal){
        this.fechaFinal=fechaFinal;
    }

    /**
     * Metodo para obtener las paradas del itinerario
     * @return - paradas del itinerario
     */
    public List<ParadaEntity> getParadas() {
        return paradas;
    }

    /**
     * Metodo para modificar las paradas del itinerario
     * @param paradas - nuevas paradas del itinerario
     */
    public void setParadas(List<ParadaEntity> paradas) {
        this.paradas = paradas;
    }


}
