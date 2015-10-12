/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.NotificacionDto;
import co.uniandes.edu.ecos.dto.NotificacionEstadoDto;
import co.uniandes.edu.ecos.persistencia.Notificacion;
import co.uniandes.edu.ecos.persistencia.NotificacionEstado;
import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.service.Response.RespuestaNotificacion;
import co.uniandes.edu.service.Response.RespuestaNotificacionEstado;
import co.uniandes.edu.service.Response.RespuestaService;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Johans Gonzalez
 */
@PermitAll
@Stateless

public class NotificacionServiceBean implements INotificacionServiceLocal {

    @PersistenceContext(unitName = "CentralizadorUP")
    EntityManager em;

    @Override
    public RespuestaService asignarNotificacionCiudadano(NotificacionDto notificacionDto) throws PersistenceException {
        RespuestaService respuestaService = new RespuestaService();
        try {
            NotificacionEstadoDto notificacionEstadoDto = new NotificacionEstadoDto();
            notificacionEstadoDto.setCodigoEstado(1);
            notificacionDto.setCodigoNotificacionEstado(notificacionEstadoDto);
            Notificacion notificacion = Mapper.copyCompleto(notificacionDto, Notificacion.class, false);
            em.persist(notificacion);
            respuestaService.setRespuestaService("Se ha generado la notifiación.");
            respuestaService.setSePresentoError(false);
            return respuestaService;
        } catch (IllegalArgumentException argumentException) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("Se recibió un argumento inválido");
            respuestaService.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : " " + " Causa: " + argumentException.getCause().getMessage());
            return null;
        } catch (Exception exception) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("La creación envió excepción general");
            respuestaService.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : " " + " " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
            return null;
        }

    }

    @Override
    public RespuestaNotificacion obtenerNotificacionCiudadano(Integer codigoCiudadano) {

        RespuestaNotificacion respuestaNotificacion = new RespuestaNotificacion();

        try {
            List<Notificacion> notifiaciones = em.createNamedQuery("Notificacion.findByCiudadano", Notificacion.class)
                    .setParameter("codigoCiudadano", codigoCiudadano)
                    .getResultList();
            for (Notificacion notifiacion : notifiaciones) {
                NotificacionDto notificacionDto = Mapper.copyCompleto(notifiacion, NotificacionDto.class, true);
                respuestaNotificacion.getNotificacionDto().add(notificacionDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaNotificacion.setSePresentoError(true);
            respuestaNotificacion.setErrorMensaje("La consulta de Notificación recibió un argumento inválido");
            respuestaNotificacion.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : " " + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaNotificacion.setSePresentoError(true);
            respuestaNotificacion.setErrorMensaje("La consulta de Notificación envió excepción general");
            respuestaNotificacion.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : " " + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaNotificacion;

    }

    @Override
    public RespuestaNotificacion obtenerNotificacionCiudadanoEstado(Integer codigoCiudadano, Integer codigoEstado) {

        RespuestaNotificacion respuestaNotificacion = new RespuestaNotificacion();

        try {
            List<Notificacion> notifiaciones = em.createNamedQuery("Notificacion.findByCiudadanoEstado", Notificacion.class)
                    .setParameter("codigoCiudadano", codigoCiudadano)
                    .setParameter("codigoEstado", codigoEstado)
                    .getResultList();
            for (Notificacion notifiacion : notifiaciones) {
                NotificacionDto notificacionDto = Mapper.copyCompleto(notifiacion, NotificacionDto.class, true);
                respuestaNotificacion.getNotificacionDto().add(notificacionDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaNotificacion.setSePresentoError(true);
            respuestaNotificacion.setErrorMensaje("La consulta de Notificación recibió un argumento inválido");
            respuestaNotificacion.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : " " + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaNotificacion.setSePresentoError(true);
            respuestaNotificacion.setErrorMensaje("La consulta de Notificación envió excepción general");
            respuestaNotificacion.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : " " + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaNotificacion;

    }

    /**
     * Método que retorna una colección de estados de notificaciones.
     *
     * @return Estados de notificación.
     */
    @Override
    public RespuestaNotificacionEstado obtenerNoficacionEstados() {

        RespuestaNotificacionEstado respuestaNotificacion = new RespuestaNotificacionEstado();

        try {
            List<NotificacionEstado> notifiaciones = em.createNamedQuery("NotificacionEstado.findAll", NotificacionEstado.class).getResultList();
            for (NotificacionEstado notifiacion : notifiaciones) {
                NotificacionEstadoDto notificacionDto = Mapper.copyCompleto(notifiacion, NotificacionEstadoDto.class, false);
                respuestaNotificacion.getNotificacionEstadoDtos().add(notificacionDto);
            }
            
        } catch (NoResultException noResultException) {
            respuestaNotificacion.setSePresentoError(false);
            respuestaNotificacion.setRespuestaService("Ciudadano no encontrado.");
            respuestaNotificacion.setErrorOriginal(noResultException.getMessage() != null ? noResultException.getMessage() : "");
        } catch (IllegalArgumentException argumentException) {
            respuestaNotificacion.setSePresentoError(true);
            respuestaNotificacion.setErrorMensaje("La consulta de los estados de notificación recibió un argumento inválido");
            respuestaNotificacion.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : "" + " " + argumentException.getCause() != null ? "Causa: " + argumentException.getCause().getMessage() : "");
        } catch (Exception exception) {
            respuestaNotificacion.setSePresentoError(true);
            respuestaNotificacion.setErrorMensaje("La consulta de los estados de notificación envió excepción una general");
            respuestaNotificacion.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaNotificacion;
    }
}
