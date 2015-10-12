package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.NotificacionDto;
import co.uniandes.edu.service.Response.RespuestaNotificacion;
import co.uniandes.edu.service.Response.RespuestaNotificacionEstado;
import co.uniandes.edu.service.Response.RespuestaService;
import javax.ejb.Local;
import javax.persistence.PersistenceException;

/**
 *
 * @author Johans Gonzalez
 */
@Local
public interface INotificacionServiceLocal {

    RespuestaService asignarNotificacionCiudadano(NotificacionDto notificacionDto) throws PersistenceException;

    RespuestaNotificacion obtenerNotificacionCiudadano(Integer codigoCiudadano);

    RespuestaNotificacion obtenerNotificacionCiudadanoEstado(Integer codigoCiudadano, Integer codigoEstado);

    /**
     * Método que permitte obtner todos los estados de notificación.
     *
     * @return colección de los estados.
     */
    RespuestaNotificacionEstado obtenerNoficacionEstados();

}
