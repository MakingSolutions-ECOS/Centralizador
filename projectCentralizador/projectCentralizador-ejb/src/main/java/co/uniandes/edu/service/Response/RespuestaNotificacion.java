package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.NotificacionDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johans Gonzalez
 */
public class RespuestaNotificacion extends RespuestaService {

    /**
     * Coleccion de notificaciones.
     */
    private List<NotificacionDto> notificacionDto;

    /**
     * Inicializa una nueva instancia.
     */
    public RespuestaNotificacion() {
        this.notificacionDto = new ArrayList<>();
    }

    /**
     * Inicializacion de una nueva instancia con parémetros
     *
     * @param notificacionDto
     */
    public RespuestaNotificacion(List<NotificacionDto> notificacionDto) {
        this.notificacionDto = notificacionDto;
    }

    /**
     * Obtiene la colección de notificaciones.
     *
     * @return coleccion de objetos NotificacionDto.
     */
    public List<NotificacionDto> getNotificacionDto() {
        return this.notificacionDto;
    }

    /**
     * Establece las notificaciones.
     *
     * @param notificacionDto a establecer.
     */
    public void setNotificacionDto(List<NotificacionDto> notificacionDto) {
        this.notificacionDto = notificacionDto;
    }
}
