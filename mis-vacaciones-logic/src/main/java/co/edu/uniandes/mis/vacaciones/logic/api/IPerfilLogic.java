/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.api;

import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import java.util.List;

/**
 *
 * @author hj.calderon10
 */
public interface IPerfilLogic {

    public List<PerfilEntity> getPerfiles();

    public PerfilEntity getPerfil(Long id);

    public PerfilEntity createPerfil(PerfilEntity entity) throws BusinessLogicException;

    public PerfilEntity updatePerfil(PerfilEntity entity) throws BusinessLogicException;

    public void deletePerfil(Long id);

    public List<ItinerarioEntity> getItinerarios(Long perfilId);

    public ItinerarioEntity getItinerario(Long perfilId, Long itinerarioId);

    public ItinerarioEntity addItinerario(Long perfilId, Long itinerarioId) throws BusinessLogicException;

    public void removeItinerario(Long perfilId, Long itinerarioId);
}
