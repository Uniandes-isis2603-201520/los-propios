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
import javax.persistence.Entity;
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
public class PerfilEntity extends BaseEntity implements Serializable {

    private Integer edad;

    private Integer cedula;

    @PodamStrategyValue(DateStrategy.class)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String profesion;
    private String email;

    private String imagen;

    private String resumen;

    @OneToMany
    @PodamExclude
    private List<ItinerarioEntity> itinerarios = new ArrayList<>();

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setEmail(String c){
        email = c;
    }

    public String getEmail(){
        return email;
    }

    public void setItinerarios(List<ItinerarioEntity> itinerarios) {
        this.itinerarios = itinerarios;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getCedula() {
        return cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setImagen(String img){
        imagen = img;
    }

    public String getImagen(){
        return imagen;
    }

    public void setResumen(String r){
        resumen = r;
    }

    public String getResumen(){
        return resumen;
    }


    public List<ItinerarioEntity> getItinerarios() {
        return itinerarios;
    }
}
