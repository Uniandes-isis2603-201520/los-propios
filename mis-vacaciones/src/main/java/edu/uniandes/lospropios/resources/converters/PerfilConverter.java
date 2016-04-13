/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.converters;

import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import edu.uniandes.lospropios.resources.dtos.PerfilDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hj.calderon10
 */
public abstract class PerfilConverter {

    private PerfilConverter() {

    }

    public static PerfilDTO Entity2DTO(PerfilEntity entity) {
        if (entity != null) {
            PerfilDTO dto = new PerfilDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            return dto;
        } else {
            return null;
        }
    }

    private static PerfilDTO basicEntity2DTO(PerfilEntity entity) {
        if (entity != null) {
            PerfilDTO dto = new PerfilDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    private static PerfilEntity basicDTO2Entity(PerfilDTO dto) {
        if (dto != null) {
            PerfilEntity entity = new PerfilEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getNombre());
            return entity;
        } else {
            return null;
        }
    }

    public static PerfilDTO fullEntity2DTO(PerfilEntity entity) {
        if (entity != null) {
            PerfilDTO dto = basicEntity2DTO(entity);
            //aqui va todo lo que son mis listas.
            //dto.setReviews(ReviewConverter.listEntity2DTO(entity.getReviews()));
            return dto;
        } else {
            return null;
        }
    }

    public static PerfilEntity fullDTO2Entity(PerfilDTO dto) {
        if (dto != null) {
            PerfilEntity entity = basicDTO2Entity(dto);
            //aqui va todo lo que son mis listas.
            //entity.setReviews(ReviewConverter.childListDTO2Entity(dto.getReviews(), entity));
            return entity;
        } else {
            return null;
        }
    }

    public static List<PerfilDTO> listEntity2DTO(List<PerfilEntity> perfiles) {

        List<PerfilDTO> dtos = new ArrayList<PerfilDTO>();
        if (perfiles != null) {
            for (PerfilEntity entity : perfiles) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

}
