/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.converters;

import co.edu.uniandes.mis.vacaciones.logic.entities.EventoEntity;
import edu.uniandes.lospropios.resources.dtos.EventoDTO;

/**
 *
 * @author js.gomez14
 */
public class EventoConverter
{

     /**
     * Realiza la conversión de EventoEntity a EventoDTO. Se invoca cuando otra
     * entidad tiene una referencia a EventoEntity. Entrega únicamente los
     * atributos proprios de la entidad.
     *
     * @param entity instancia de EventoEntity a convertir
     * @return instancia de EventoDTO con los datos recibidos por parámetro
     * @generated
     */
    public static EventoDTO refEntity2DTO(EventoEntity entity){
        if(entity!=null){
            EventoDTO dto = new EventoDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getName());
            dto.setFecha(entity.getFecha());
            dto.setClasificacion(entity.getClasificacion());
            dto.setDescripcion(entity.getDescripcion());
            dto.setImg(entity.getImg());
            dto.setLugar(entity.getLugar());
            dto.setPrecio(entity.getPrecio());

//            dto.setVIsita(entity.getVisita);
//TODO modificar para convertir el resto de atributos y convertir la visita del evento
            return dto;
        }
        return null;
    }

    /**
     * Realiza la conversión de ItinerarioDTO a ItinerarioEntity Se invoca cuando otro DTO
     * tiene una referencia a ItinerarioDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de ItinerarioDTO a convertir
     * @return instancia de ItinerarioEntity con los datos recibidos por parámetro
     * @generated
     */
    /**
    public static EventoEntity refDTO2Entity(EventoDTO dto){
        if(dto!=null){
            EventoEntity entity = new EventoEntity();
            entity.setId(dto.getId());
            entity.setClasificacion(dto.getClasificacion());
            entity.setDescripcion(dto.getDescripcion());
            entity.setFecha(dto.getFecha());
            entity.setImg(dto.getImg());
            entity.setPrecio(dto.getPrecio());
            entity.setLugar(dto.getLugar());
            entity.setName(dto.getNombre());
            //TODO Relacion con visita
            return entity;
        }
        return null;
    }
    **/

    


}
