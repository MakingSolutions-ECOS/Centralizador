/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

/**
 *
 * @author John Dany
 */
public class NotificacionDto {
    
    /**
     * Ruta del adjunto de la notificación.
     */
    private String urlAdjunto;
    
    /**
     * Código único de identificación de la notificación
     */
    private Integer codigoNotificacion;
    
    /**
     * Remitente que genera la notificación.
     */
    private String remitente;
    
    /**
     * Mensaje o contenido de la notificación.
     */
    private String mensaje;
    
    /**
     * Ciudadano a quien va dirigida la notificación.
     */
    private CiudadanoDto codigoCiudadano;
    
    /**
     * Estado de en el que se encuentra la notificación (visto, eliminado, sin leer)
     */
    private NotificacionEstadoDto codigoNotificacionEstado;

    public String getUrlAdjunto() {
        return urlAdjunto;
    }

    public void setUrlAdjunto(String urlAdjunto) {
        this.urlAdjunto = urlAdjunto;
    }

    public Integer getCodigoNotificacion() {
        return codigoNotificacion;
    }

    public void setCodigoNotificacion(Integer codigoNotificacion) {
        this.codigoNotificacion = codigoNotificacion;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public CiudadanoDto getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(CiudadanoDto codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public NotificacionEstadoDto getCodigoNotificacionEstado() {
        return codigoNotificacionEstado;
    }

    public void setCodigoNotificacionEstado(NotificacionEstadoDto codigoNotificacionEstado) {
        this.codigoNotificacionEstado = codigoNotificacionEstado;
    }

}
