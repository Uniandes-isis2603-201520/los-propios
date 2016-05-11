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
 * Objeto de transferencia de datos del perfil.
 *
 * @author mc.hernandez1
 */
@XmlRootElement
public class PerfilDTO {

    private Long id;
    private String name;
    private Integer cedula;
    private Integer edad;
    private Date fechaNacimiento;
    private String profesion;
    private String email;
    private String imagen;
    private String resumen;

    private final static String IMG = "https://cdn4.iconfinder.com/data/icons/free-social-media-icons/512/User.png";
    private final static String RESUME = "I'm a person";

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    public void setImagen(String img){
        imagen = img;
    }

    public String getImagen(){
        if(imagen==null)
            return IMG;
        return imagen;
    }

    public void setResumen(String r){
        resumen = r;
    }

    public String getResumen(){
        if(resumen==null || resumen.equals(""))
            return RESUME;
        return resumen;
    }


    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @XmlElement(name = "fechaNacimiento")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre
     */
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String c) {
        email = c;
    }

    /**
     * @param nombre
     */
    public void setName(String nombre) {
        this.name = nombre;
    }
}
