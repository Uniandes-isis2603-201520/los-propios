/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author josedanielcardenasrincon
 */
@Entity
public class VisitaEntity implements Serializable {
    @Id
    private Long id;
    private int ordenVisita;
    private double calificacion;
    @Temporal(TemporalType.DATE)
    private Date fecha;

    /**
     * Método necesario para NetBeans
     */
    public VisitaEntity(){
        //No se puede ejecutar el DTO sin este método.
    }


    public VisitaEntity(long id,int ordenVisita, double calificacion, Date fecha) {
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
}
