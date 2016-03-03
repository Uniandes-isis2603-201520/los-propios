/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.dtos;

/**
 *
 * @author js.gomez14
 */
public class EventoDTO
{
    private Long id;
    private String name;

    public EventoDTO()
    {

    }

    /**
     * Constructor con parámetros.
     * @param id identificador de la ciudad
     * @param name nombre de la ciudad
     */
    public EventoDTO(Long id, String name)
    {
		super();
		this.id = id;
		this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString()
    {
    	return "{ id : " + getId() + ", name : \"" + getName() + "\" }" ;
    }

}
