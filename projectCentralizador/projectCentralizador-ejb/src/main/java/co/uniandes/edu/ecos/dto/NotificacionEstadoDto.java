package co.uniandes.edu.ecos.dto;

import java.util.List;

/**
 *
 * @author John Dany
 */
public class NotificacionEstadoDto {

    /**
     * Código idnentificador del estado de notificación.
     */
    private Integer codigoEstado;
    
      /**
     * Nombre que describe el estado de notificación.
     */
    private String nombreEstado;

    /**
     * Colección de notificaciones asociadas.
     */
    private List<NotificacionDto> notificacionList;

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public List<NotificacionDto> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<NotificacionDto> notificacionList) {
        this.notificacionList = notificacionList;
    }  
}
