/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.converters;

import co.edu.uniandes.mis.vacaciones.logic.entities.ParadaEntity;
import edu.uniandes.lospropios.resources.dtos.ParadaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mc.hernandez1
 */
public abstract class ParadaConverter {

    private ParadaConverter() {

    }

    public static ParadaDTO refEntity2DTO(ParadaEntity entity)
    {
        if (entity != null) {
            ParadaDTO dto = new ParadaDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setActividad(entity.getAcividadParada());
            dto.setCiudad(entity.getCiudadParada());
            dto.setFechaFin(entity.getFechaFinParada());
            dto.setFechaInicio(entity.getFechaInicioParada());
            return dto;
        } else {
            return null;
        }
    }

    public static ParadaEntity refDTO2Entity (ParadaDTO dto)
    {
        if(dto != null)
        {
            ParadaEntity entity = new ParadaEntity();
            entity.setId(dto.getId());

            return entity;
        }

        else
        {
            return null;
        }
    }

    private static ParadaDTO basicEntity2DTO(ParadaEntity entity)
    {
        if(entity != null)
        {
            ParadaDTO dto = new ParadaDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setActividad(entity.getAcividadParada());
            dto.setCiudad(entity.getCiudadParada());
            dto.setFechaFin(entity.getFechaFinParada());
            dto.setFechaInicio(entity.getFechaInicioParada());

            return dto;
        }

        else
        {
            return null;
        }
    }

    private static ParadaEntity basicDTO2Entity (ParadaDTO dto)
    {
        if(dto!=null)
        {
            ParadaEntity entity = new ParadaEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setCiudadParada(dto.getCiudad());
            entity.setActividadParada(dto.getActividad());
            entity.setFechaFinParada(dto.getFechaFin());
            entity.setFechaInicioParada(dto.getFechaInicio());
        return entity;
        }

        else
        {
            return null;
        }

    }

public static ParadaDTO fullEntity2DTO(ParadaEntity entity)
{
        if (entity != null)
        {
            ParadaDTO dto = basicEntity2DTO(entity);
            return dto;
        }
        else
        {
           return null;
        }
    }

    /**
     * Convierte una instancia de ParadaDTO a ParadaEntity.
     * Incluye todos los atributos de AuthorEntity.
     *
     * @param dto Instancia de ParadaDTO a convertir
     * @return Instancia de ParadaEntity con los datos recibidos por parámetro
     * @generated
     */
    public static ParadaEntity fullDTO2Entity(ParadaDTO dto)
    {
        if (dto != null)
        {
            ParadaEntity entity = basicDTO2Entity(dto);
            return entity;
        }
        else
        {
            return null;
        }
    }

    /**
     * Convierte una colección de instancias de AuthorEntity a AuthorDTO. Para cada
     * instancia de AuthorEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo AuthorDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de AuthorDTO
     * @generated
     */
    public static List<ParadaDTO> listEntity2DTO(List<ParadaEntity> entities) {
        List<ParadaDTO> dtos = new ArrayList<>();
        if (entities != null) {
            for (ParadaEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de AuthorDTO a instancias de
     * AuthorEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de AuthorDTO a convertir
     * @return Collección de instancias de AuthorEntity
     * @generated
     */
    public static List<ParadaEntity> listDTO2Entity(List<ParadaDTO> dtos) {
        List<ParadaEntity> entities = new ArrayList<>();
        if (dtos != null) {
            for (ParadaDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;


}
}