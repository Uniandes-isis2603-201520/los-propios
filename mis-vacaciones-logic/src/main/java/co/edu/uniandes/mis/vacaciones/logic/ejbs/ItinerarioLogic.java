package co.edu.uniandes.mis.vacaciones.logic.ejbs;

/**
 *
 * @author jg.murillo10
 */

import co.edu.uniandes.mis.vacaciones.logic.api.IItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.persistence.ItinerarioPersistence;
import java.util.List;
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
 public List<ItinerarioEntity> getItinerarios(){
        logger.info("Inicia proceso de consultar todos los itinerarios");
        List<ItinerarioEntity> itinerarios = persistence.findAll();
        logger.info("Termina proceso de consultar todos los itinerarios");
        return itinerarios;
 }

    @Override
    public ItinerarioEntity createItinerario(ItinerarioEntity itinerario) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public ItinerarioEntity getItinerarioUsuario(long idPerfil, long idItinerario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItinerarioEntity updateItinerario(long idItinerario, ItinerarioEntity itinerario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItinerario(long idItinerario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }






}
