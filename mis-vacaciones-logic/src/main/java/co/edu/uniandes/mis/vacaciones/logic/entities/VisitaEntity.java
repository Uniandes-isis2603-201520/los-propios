/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author josedanielcardenasrincon
 */
@Entity
public class VisitaEntity extends BaseEntity implements Serializable {
    private Integer ordenVisita;
    private Double calificacion;
    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    @PodamExclude
    private EventoEntity evento;

    /**
     * Método necesario para NetBeans
     */
    public VisitaEntity(){
        //No se puede ejecutar el DTO sin este método.
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
}
