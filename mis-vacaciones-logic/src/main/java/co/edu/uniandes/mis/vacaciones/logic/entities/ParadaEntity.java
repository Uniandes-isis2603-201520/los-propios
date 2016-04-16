
package co.edu.uniandes.mis.vacaciones.logic.entities;

//import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import javax.persistence.CascadeType;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

//import javax.persistence.TemporalType;

/**
 *
 * @author mc.hernandez1
 */
@Entity

public class ParadaEntity extends BaseEntity implements Serializable {

//    @Id
//    private Long id;
//    private String nombreParada;
    private String ciudadParada;
    private String actividadParada;
    @Temporal(TemporalType.DATE)
    private Date fechaInicioParada;
    @Temporal(TemporalType.DATE)
    private Date fechaFinParada;

    @ManyToMany
    private List<VisitaEntity> visitas = new ArrayList();

//@ManyToMany
//private ItinerarioEntity itinerario;

//@OneToMany(mappedBy = "parada", cascade= CascadeType.ALL, orphanRemoval = true)
//private List<ReviewEntity> reviews = new ArrayList();
    /**
     * @return the id
     */
//    public Long getId() {
//        return id;
//    }
//
//    /**
//     * @param id the id to set
//     */
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    /**
//     * @return the nombreParada
//     */
//    public String getNombreParada() {
//        return nombreParada;
//    }
//
//    /**
//     * @param nombreParada the nombreParada to set
//     */
//    public void setNombreParada(String nombreParada) {
//        this.nombreParada = nombreParada;
//    }

    /**
     * @return the ciudadParada
     */
    public String getCiudadParada() {
        return ciudadParada;
    }

    /**
     * @param ciudadParada the ciudadParada to set
     */
    public void setCiudadParada(String ciudadParada) {
        this.ciudadParada = ciudadParada;
    }

    /**
     * @return the actividadParada
     */
    public String getAcividadParada() {
        return actividadParada;
    }

    /**
     * @param actividadParada the actividadParada to set
     */
    public void setActividadParada(String actividadParada) {
        this.actividadParada = actividadParada;
    }

    /**
     * @return the fechaInicioParada
     */
    public Date getFechaInicioParada() {
        return fechaInicioParada;
    }

    /**
     * @param fechaInicioParada the fechaInicioParada to set
     */
    public void setFechaInicioParada(Date fechaInicioParada) {
        this.fechaInicioParada = fechaInicioParada;
    }

    /**
     * @return the fechaFinParada
     */
    public Date getFechaFinParada() {
        return fechaFinParada;
    }

    /**
     * @param fechaFinParada the fechaFinParada to set
     */
    public void setFechaFinParada(Date fechaFinParada) {
        this.fechaFinParada = fechaFinParada;
    }


    public List<VisitaEntity> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<VisitaEntity> visitas) {
        this.visitas = visitas;
    }

}

