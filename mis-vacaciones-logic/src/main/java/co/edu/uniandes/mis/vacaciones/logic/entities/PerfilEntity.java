/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author hj.calderon10
 */
@Entity
public class PerfilEntity extends BaseEntity implements Serializable{

    private String nombre;

    private int edad;

    


    private String algo;

    @OneToMany
    @PodamExclude
    private List<ItinerarioEntity> itinerarios = new ArrayList<>();

    public List<ItinerarioEntity> getItinerarios()
    {
        return itinerarios;
    }




}
