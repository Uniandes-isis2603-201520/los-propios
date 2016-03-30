package co.edu.uniandes.mis.vacaciones.logic.ejbs;

/**
 *
 * @author jg.murillo10
 */

import co.edu.uniandes.mis.vacaciones.logic.api.IItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class ItinerarioLogic implements IItinerarioLogic {

@Override
 public List<ItinerarioEntity> getItinerarios(){
     return null;
 }

}
