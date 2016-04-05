/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.api;

import java.util.List;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.entities.ParadaEntity;
import co.edu.uniandes.mis.vacaciones.logic.entities.VisitaEntity;

/**
 *
 * @author mc.hernandez1
 */
public interface IParadaLogic
{
public List<ParadaEntity> getParadas();

    public ParadaEntity getParada(Long id) throws BusinessLogicException;

    public ParadaEntity createParada(ParadaEntity entity) throws BusinessLogicException;

    public ParadaEntity updateParada(ParadaEntity entity) throws BusinessLogicException;

    public void deleteParada(Long id);

    public List<VisitaEntity> getVisitas(Long visitaId);

    public VisitaEntity getVisita(Long paradaId, Long visitaId);

    public VisitaEntity addVisita(Long visitaId, Long paradaId) throws BusinessLogicException;

    public void removeVisita(Long visitaId, Long autorId);

    public List<VisitaEntity> replaceVisitas(List<VisitaEntity> visitas, Long paradaId) throws BusinessLogicException;
}
