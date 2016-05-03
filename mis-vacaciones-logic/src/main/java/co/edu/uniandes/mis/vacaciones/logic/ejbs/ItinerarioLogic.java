package co.edu.uniandes.mis.vacaciones.logic.ejbs;

/**
 *
 * @author jg.murillo10
 */
import co.edu.uniandes.mis.vacaciones.logic.api.IItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.persistence.ItinerarioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
//TODO completar metodos

@Stateless
public class ItinerarioLogic implements IItinerarioLogic {

    private static final Logger logger = Logger.getLogger(ItinerarioLogic.class.getName());
    @Inject
    private ItinerarioPersistence persistence;

    @Override
    public List<ItinerarioEntity> getItinerarios() {
        logger.info("Inicia proceso de consultar todos los itinerarios");
        List<ItinerarioEntity> itinerarios = persistence.findAll();
        logger.info("Termina proceso de consultar todos los itinerarios");
        return itinerarios;
    }

    @Override
    public ItinerarioEntity createItinerario(ItinerarioEntity entity) throws BusinessLogicException {
        logger.info("Inicia proceso de creación de itinerario");
        persistence.create(entity);
        logger.info("Termina proceso de creación de itinerario");
        return entity;
    }

    @Override
    public ItinerarioEntity getItinerarioUsuario(long idItinerario) {

        logger.log(Level.INFO, "Inicia proceso de consultar un itinerario con id={0}", idItinerario);
        ItinerarioEntity itinerario = persistence.find(idItinerario);
        if (itinerario == null) {
            logger.log(Level.SEVERE, "El itinerario con el id {0} no existe", idItinerario);
            throw new IllegalArgumentException("El itinerario solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar itinerario con id={0}", idItinerario);
        return itinerario;
    }

    @Override
    public ItinerarioEntity updateItinerario(ItinerarioEntity entity) throws BusinessLogicException {
        ItinerarioEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar perfil con id={0}", entity.getId());
        return newEntity;

    }

    @Override
    public void deleteItinerario(long idItinerario) {
        logger.log(Level.INFO, "Inicia proceso de borrar perfil con id={0}", idItinerario);
        persistence.delete(idItinerario);
        logger.log(Level.INFO, "Termina proceso de borrar perfil con id={0}", idItinerario);

    }

}
