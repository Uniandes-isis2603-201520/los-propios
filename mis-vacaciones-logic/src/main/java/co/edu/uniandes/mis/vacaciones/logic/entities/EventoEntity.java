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
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js.gomez14
 */
@Entity
public class EventoEntity extends BaseEntity implements Serializable
{
    private String img;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String lugar;

    private String clasificacion;

    private double precio;

    private String descripcion;

    private String tipo;

    @OneToOne
    private VisitaEntity visita;


    public VisitaEntity getVisita()
    {
        return visita;
    }

    public void setVisita(VisitaEntity visita)
    {
        this.visita = visita;
    }


    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public String getLugar()
    {
        return lugar;
    }

    public void setLugar(String lugar)
    {
        this.lugar = lugar;
    }

    public String getClasificacion()
    {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion)
    {
        this.clasificacion = clasificacion;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

}
