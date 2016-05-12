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
    private Date fechaInicio;
    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @OneToMany
    @PodamExclude
    private List<ParadaEntity> paradas = new ArrayList<>();



    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Metodo para modificar
     *
     * @param fechaInicial
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Metodo para obtener la fecha final del itinerario
     *
     * @return - fecha final del itinerario
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Metodo para modificar la fecha final del itinerario
     *
     * @param fechaFinal - nueva fecha final del itinerario
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Metodo para obtener las paradas del itinerario
     *
     * @return - paradas del itinerario
     */
    public List<ParadaEntity> getParadas() {
        return paradas;
    }

    /**
     * Metodo para modificar las paradas del itinerario
     *
     * @param paradas - nuevas paradas del itinerario
     */
    public void setParadas(List<ParadaEntity> paradas) {
        this.paradas = paradas;
    }

    public void addParada(ParadaEntity parada) {
        if (!esta(parada)) {
            paradas.add(parada);
        }

    }

    public void deleteParada(long idParada) {
        ParadaEntity aEliminar = buscar(idParada);
        if (aEliminar != null) {
            paradas.remove(aEliminar);
        }
    }

    private ParadaEntity buscar(long idParada) {
        for (ParadaEntity next : paradas) {
            if (next.getId() == idParada) {
                return next;
            }
        }
        return null;
    }

    private boolean esta(ParadaEntity parada) {
        for (ParadaEntity next : paradas) {
            if (next.getId() == parada.getId()) {
                return true;
            }
        }
        return false;
    }

}
