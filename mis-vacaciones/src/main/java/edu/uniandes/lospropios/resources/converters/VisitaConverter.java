/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.converters;

import co.edu.uniandes.mis.vacaciones.logic.entities.VisitaEntity;
import edu.uniandes.lospropios.resources.dtos.VisitaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public abstract class VisitaConverter {
    
    
    private VisitaConverter(){
        
    }
    
        public static VisitaDTO refEntity2DTO(VisitaEntity entity) {
        if (entity != null) {
            VisitaDTO dto = new VisitaDTO();
            dto.setId(entity.getId());
            dto.setCalificacion(entity.getCalificacion());
            dto.setFecha(entity.getFecha());
            dto.setOrdenVisita(entity.getOrdenVisita());
            dto.setEvento(EventoConverter.fullEntity2DTO(entity.getEvento()));

            return dto;
        } else {
            return null;
        }
    }
        
    public static VisitaEntity fullDTO2Entity(VisitaDTO dto) {
        if (dto != null) {
            VisitaEntity entity = new VisitaEntity();
            entity.setId(dto.getId());
            entity.setFecha(dto.getFecha());
            entity.setOrdenVisita(dto.getOrdenVisita());
            entity.setCalificacion(dto.getCalificacion());
            entity.setEvento(EventoConverter.refDTO2Entity(dto.getEvento()));
            return entity;
        } else {
            return null;
        }
    }
    
      /**
     * Convierte una colección de instancias de VisitaEntity a VisitaDTO. Para cada
     * instancia de VisitaEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo VisitaDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de VisitaDTO
     * @generated
     */
    public static List<VisitaDTO> listEntity2DTO(List<VisitaEntity> entities) {
        List<VisitaDTO> dtos = new ArrayList<VisitaDTO>();
        if (entities != null) {
            for (VisitaEntity entity : entities) {
                dtos.add(refEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de VisitaDTO a instancias de
     * VisitaEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de VisitaDTO a convertir
     * @return Collección de instancias de VisitaEntity
     * @generated
     */
    public static List<VisitaEntity> listDTO2Entity(List<VisitaDTO> dtos) {
        List<VisitaEntity> entities = new ArrayList<>();
        if (dtos != null) {
            for (VisitaDTO dto : dtos) {
                entities.add(fullDTO2Entity(dto));
            }
        }
        return entities;
    }
    
}
