package co.edu.uniandes.mis.vacaciones.logic.ejbs;

/**
 *
 * @author jg.murillo10
 */
import co.edu.uniandes.mis.vacaciones.logic.api.IItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.api.IPerfilLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.persistence.ItinerarioPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
//TODO completar metodos

@Stateless
public class ItinerarioLogic implements IItinerarioLogic {

    private static final Logger logger = Logger.getLogger(ItinerarioLogic.class.getName());
    @Inject
    private ItinerarioPersistence persistence;

    @Inject
    private IPerfilLogic perfilLogic;

    public List<ItinerarioEntity> getItinerarios(Long perfilId) {
        PerfilEntity en = perfilLogic.getPerfil(perfilId);
        return en.getItinerarios();
    }

    public ItinerarioEntity createItinerario(Long id, ItinerarioEntity entity) throws BusinessLogicException {
        PerfilEntity perfil = perfilLogic.getPerfil(id);
        entity.setPerfil(perfil);
        entity = persistence.create(entity);
        return entity;
    }

    @Override
    public ItinerarioEntity getItinerario(Long idUsuario, Long idItinerario) {
        try{
            return persistence.find(idUsuario, idItinerario);
        }
        catch(NoResultException e){
            throw new IllegalArgumentException("El itinerario no existe");
        }
    }

    @Override
    public ItinerarioEntity updateItinerario(Long perilId, ItinerarioEntity entity) throws BusinessLogicException {
        PerfilEntity perf = perfilLogic.getPerfil(perilId);
        entity.setPerfil(perf);
        return persistence.update(entity);

    }

    @Override
    public void deleteItinerario(Long idPerfil, Long idItinerario) {
        ItinerarioEntity old = getItinerario(idItinerario, idItinerario);
        persistence.delete(old.getId());
    }

}
