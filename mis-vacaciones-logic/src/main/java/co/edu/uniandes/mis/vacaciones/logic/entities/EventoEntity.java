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
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author js.gomez14
 */
@Entity
public class EventoEntity extends BaseEntity implements Serializable
{
    /**
     * Modela la URL de la imagen representativa del evento.
     */
    private String img;

    /**
     * Modela la fecha del evento.
     */
    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    /**
     * Modela el lugar del evento.
     */
    private String lugar;

    /**
     * Modela si el "Evento" es un LugarDeInteres o un Evento.
     */
    private String clasificacion;

    /**
     * Modela el precio del evento.
     */
    private double precio;

    /**
     * Modela la descripción del evento.
     */
    private String descripcion;

    /**
     * Modela el tipo del evento.
     */
    private String tipo;

    /**
     * Modela a que visita pertenece un evento.
     */
    @OneToOne
    @PodamExclude
    private VisitaEntity visita;


    /**
     * Retorna la Visita a la que pertenece el evento
     * @return visita a la que pertenece el evento.
     */
    public VisitaEntity getVisita()
    {
        return visita;
    }

    /**
     * Modifica la Visita a la que pertenece el Evento
     * @param visita la nueva visita a la que pertenece el Evento
     */
    public void setVisita(VisitaEntity visita)
    {
        this.visita = visita;
    }

    /**
     * Retorna la URL de la foto representativa del evento.
     * @return URL de la foto representativa del evento.
     */
    public String getImg()
    {
        return img;
    }

    /**
     * Modifica la URL de la foto que representa al Evento.
     * @param img la nueva URL de la foto que representa ak Evento.
     */
    public void setImg(String img)
    {
        this.img = img;
    }

    /**
     * Retorna la fecha del evento.
     * @return la fecha del evento.
     */
    public Date getFecha()
    {
        return fecha;
    }

    /**
     * Modifica la fecha del evento.
     * @param fecha nueva fecha del evento.
     */
    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    /**
     * Retorna el lugar del evento.
     * @return el lugar del evento.
     */
    public String getLugar()
    {
        return lugar;
    }

    /**
     * Modifica el lugar del evento.
     * @param lugar nuevo lugar del evento.
     */
    public void setLugar(String lugar)
    {
        this.lugar = lugar;
    }

    /**
     * Retorna la clasificación del evento.
     * @return la clasificación del evento.
     */
    public String getClasificacion()
    {
        return clasificacion;
    }

    /**
     * Modifica la clasificación del evento.
     * @param clasificacion nueva clasificación del evento.
     */
    public void setClasificacion(String clasificacion)
    {
        this.clasificacion = clasificacion;
    }

    /**
     * Retorna el precio del evento.
     * @return el precio del evento.
     */
    public double getPrecio()
    {
        return precio;
    }

    /**
     * Modifica el precio del evento
     * @param precio nuevo precio del evento.
     */
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    /**
     * Retorna el tipo del evento.
     * @return el tipo del evento.
     */
    public String getTipo()
    {
        return tipo;
    }

    /**
     * Modifica el tipo del evento.
     * @param tipo el nuevo tipo del evento.
     */
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    /**
     * Retorna la descripción del evento.
     * @return la descripción del evento.
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     *  Modifica la descripción del evento.
     * @param descripcion la nueva descripción del evento.
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

}
