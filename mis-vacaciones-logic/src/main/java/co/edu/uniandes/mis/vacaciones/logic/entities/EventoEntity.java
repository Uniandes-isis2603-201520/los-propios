/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.entities;

//import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js.gomez14
 */
@Entity
public class EventoEntity extends BaseEntity implements Serializable
{

    @Id
    private Long id;

    private String img;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String lugar;

    private String clasificacion;

    private double precio;

    private String descripcion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
