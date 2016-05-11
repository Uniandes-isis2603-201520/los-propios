
package co.edu.uniandes.mis.vacaciones.logic.entities;


import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;


/**
 *
 * @author mc.hernandez1
 */
@Entity

public class ParadaEntity extends BaseEntity implements Serializable {

    private String ciudad;
    private String actividad;
    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @ManyToMany
    @PodamExclude
    private List<VisitaEntity> visitas = new ArrayList();


    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudadParada to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the actividadParada
     */
    public String getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividadParada to set
     */
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    /**
     * @return the fechaInicioParada
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicioParada to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFinParada
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFinParada to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    public List<VisitaEntity> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<VisitaEntity> visitas) {
        this.visitas = visitas;
    }

}

