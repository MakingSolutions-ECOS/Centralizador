package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.NotificacionDto;
import co.uniandes.edu.ecos.dto.NotificacionEstadoDto;
import java.util.ArrayList;
import java.util.List;

/**
 * Respuesta relacionada con la consulta de estados de notificación.
 *
 * @author John Dany
 */
public class RespuestaNotificacionEstado extends RespuestaService {

    /**
     * Colección de estados de notificación.
     */
    private List<NotificacionEstadoDto> notificacionEstadoDtos;

    /**
     * Inicializa una nueva instancia.
     */
    public RespuestaNotificacionEstado() {
        this.notificacionEstadoDtos = new ArrayList<>();
    }

    /**
     * Inicializacion de una nueva instancia con parémetros
     *
     * @param notificacionEstadoDto
     */
    public RespuestaNotificacionEstado(List<NotificacionEstadoDto> notificacionEstadoDto) {
        this.notificacionEstadoDtos = notificacionEstadoDto;
    }

    /**
     * Obtiene los estados de notificación.
     *
     * @return Colección de objetos de tipo NotificacionEstadoDto.
     */
    public List<NotificacionEstadoDto> getNotificacionEstadoDtos() {
        return notificacionEstadoDtos;
    }

    /**
     * Establece una colección de estados de notificación.
     *
     * @param notificacionEstadoDtos a establecer.
     */
    public void setNotificacionEstadoDtos(List<NotificacionEstadoDto> notificacionEstadoDtos) {
        this.notificacionEstadoDtos = notificacionEstadoDtos;
    }
}
