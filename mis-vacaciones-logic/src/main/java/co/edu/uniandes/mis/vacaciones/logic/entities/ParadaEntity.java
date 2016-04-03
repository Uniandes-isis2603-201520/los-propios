/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import
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
import co.edu.uniandes.mis.vacaciones.entities.VisitaEntity;
/**
 *
 * @author mc.hernandez1
 */
@Entity

public class ParadaEntity extends BaseEntity implements Serializable
{
private String isbn;
private String image;
@Temporal(TermporalType.DATE)
private Date publishdate;
private String descripcion;

@ManyToMany
private List<VisitaEntity> visitas = new ArrayList();

@ManyToMany
private ItinerarioEntity itinerario;

@OneToMany(mappedBy = "parada", cascade= CascadeType.ALL, orphanRemoval = true)
private List<ReviewEntity> reviews = new ArrayList();

/**
 * @return the isbn
 */
public String getIsbn()
{
    return isbn;
}

/**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the publishDate
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate the publishDate to set
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public List<VisitaEntity> getVisitas()
    {
        return visitas;
    }

    public void setVisitas(List<VisitaEntity> visitas)
    {
        this.visitas = visitas;
    }
    
}

