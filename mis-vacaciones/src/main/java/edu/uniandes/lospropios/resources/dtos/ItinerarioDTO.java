
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

import edu.uniandes.lospropios.resources.adapters.DateAdapter;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * @author  jg.murillo10
 */
@XmlRootElement
public class ItinerarioDTO {

    private Long id;
    private String nombreItinerario;
    private Date fechaInicio;
    private Date fechaFin;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreItinerario(){
        return nombreItinerario;
    }
    public void setNombreItinerario(String n){
        this.nombreItinerario=n;
    }
    @XmlElement(name = "fechaInicio")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @XmlElement(name = "fechaFin")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
