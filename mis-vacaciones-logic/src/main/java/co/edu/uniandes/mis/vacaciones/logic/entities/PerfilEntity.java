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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author hj.calderon10
 */
@Entity
public class PerfilEntity extends BaseEntity implements Serializable{


    private String nombre;

    private String algo;
    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)

    @OneToMany
    private List<ItinerarioEntity> itinerarios = new ArrayList<>();

    public List<ItinerarioEntity> getItinerarios()
    {
        return itinerarios;
    }




}
