/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.ejbs;

import co.edu.uniandes.mis.vacaciones.api.IParadaLogic;

import co.edu.uniandes.mis.vacaciones.entities.ItinerarioEntity;

import co.edu.uniandes.mis.vacaciones.entities.ParadaEntity;

import co.edu.uniandes.mis.vacaciones.exceptions.BusinessLogicException;

import co.edu.uniandes.mis.vacaciones.persistence.ItinerarioPersistence;

import co.edu.uniandes.mis.vacacaiones.persistence.ParadaPersistence;

import java.util.Date;

import java.util.List;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.ejb.Stateless;

import javax.inject.Inject;

/**
 *
 * @author mc.hernandez1
 */

@Stateless

public class ParadaLogic implements IParadaLogic

{

private static final Logger logger = Logger.getLogger (ParadaLogic.class.getName());

@Inject
private ParadaPersistence persistence;

@Inject
private ItinerarioPersistence itinerarioPersistence;

@Override
public List<ParadaEntity> getParadas()
{
    logger.info("Inicia el proceso de consultar todas las paradas");
    List<ParadaEntity> paradas = persistence.findAll();
    logger.info("Termina proceso de consultar todos los libros");
    return paradas;
}

@Override
public ParadaEntity getParada(Long id) throws BusinessLogicException
{
    logger.log(Level.INFO, "Inicia proceso de consultar parada con id = {0}", id);
    ParadaEntity parada = persistence.find(id);

    if(parada == null)
    {
        logger.log(Level.SEVERE, "La parada con el id {0} no existe", id);
        throw new BusinessLogicException ("La parada solicitada no existe");

    }

    logger.log(Level.INFO, "Termina proceso de consultar parada con id = {0}", id);
    return parada;
}

@Override
public ParadaEntity createParada(ParadaEntity entity) throws BusinessLogicException
{
    logger.info("Inicia proceso de creación de parada");
    if(!validateISBN(entity.getIsbn()))
    {
        throw new BusinessLogicException("El ISBN es inválido");
    }
    persistence.create(entity);
    logger.info("Termina proceso de creación de parada");
    return entity;
}

@Override
public ParadaEntity updateParada (ParadaEntity entity)throws BusinessLogicException
{
    logger.log(Level.INFO,"Inicia proceso de actualizar parada con id = {0}",entity.getId());
    if(!validateISBN(entity.getIsbn()))
    {
        throw new BusinessLogicException("El ISBN es inválido");
    }
    ParadaEntity newEntity = persistence.update(entity);
    logger.log(Level.INFO, "Termina proceso de actualizar parada con id={0}", entity.getId());
    return newEntity;
}

@Override
public void deleteParada(Long id)
{
    logger.log(Level.INFO,"Inicia proceso de borrar parada con id = {0}", id);
    persistence.delete(id);
    logger.log(Level.INFO,"Temrmina proceso de borrar parada con id ={0}", id);

}



}