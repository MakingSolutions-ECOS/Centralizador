  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.dto.NotificacionDto;
import co.uniandes.edu.ecos.negocio.INotificacionServiceLocal;
import co.uniandes.edu.service.Response.RespuestaNotificacion;
import co.uniandes.edu.service.Response.RespuestaNotificacionEstado;
import co.uniandes.edu.service.Response.RespuestaService;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.PersistenceException;

/**
 *
 * @author Johans Gonzalez
 */
@WebService(serviceName = "NotificacionService")
public class NotificacionService {

    @EJB
    private INotificacionServiceLocal notificacionServiceBean;

    @WebMethod(operationName = "asignarNotificacion")
    public RespuestaService asignarNotificacion(NotificacionDto notificacionDto) {
        RespuestaService respuestaService = new RespuestaService();
        try {
            respuestaService = notificacionServiceBean.asignarNotificacionCiudadano(notificacionDto);
        } catch (PersistenceException e) {
            respuestaService = new RespuestaService();
            respuestaService.setErrorMensaje(e.getMessage().toString());
        } catch (Exception e) {
            respuestaService = new RespuestaService();
            respuestaService.setErrorMensaje(e.getMessage().toString());
        }
        return respuestaService;
    }

    @WebMethod(operationName = "obtenerNotificacionCiudadano")
    public RespuestaNotificacion obtenerNotificacionCiudadano(@WebParam(name = "codigoCiudadano") Integer codigoCiudadano) {
        RespuestaNotificacion respuestaNotificacion = new RespuestaNotificacion();
        respuestaNotificacion = notificacionServiceBean.obtenerNotificacionCiudadano(codigoCiudadano);
        return respuestaNotificacion;
    }

    @WebMethod(operationName = "obtenerNotificacionCiudadanoEstado")
    public RespuestaNotificacion obtenerNotificacionCiudadanoEstado(@WebParam(name = "codigoCiudadano") Integer codigoCiudadano, @WebParam(name = "codigoEstado") Integer codigoEstado) {
        RespuestaNotificacion respuestaNotificacion = new RespuestaNotificacion();
        respuestaNotificacion = notificacionServiceBean.obtenerNotificacionCiudadanoEstado(codigoCiudadano, codigoEstado);
        return respuestaNotificacion;
    }

    /**
     * Servicio web que retorna los estados de una notificación.
     *
     * @return objeto de tipo RespuestaNotificacionEstado, el cual tiene una
     * colección de objetos NotificacionEstadoDto.
     */
    @WebMethod(operationName = "obtenerNotificacionEstados")
    public RespuestaNotificacionEstado obtenerNotificacionEstados() {
        RespuestaNotificacionEstado respuestaNotificacionEstado = null;
        respuestaNotificacionEstado = notificacionServiceBean.obtenerNoficacionEstados();
        return respuestaNotificacionEstado;
    }
    
    @WebMethod(operationName = "cambiarEstadoNotificacion")
    public RespuestaService cambiarEstadoNotificacion(Integer codigoNotificacion) {
        RespuestaService respuestaService = new RespuestaService();
        try {
            respuestaService = notificacionServiceBean.cambiarEstadoNotificacion(codigoNotificacion);
        } catch (PersistenceException e) {
            respuestaService = new RespuestaService();
            respuestaService.setErrorMensaje(e.getMessage());
        } catch (Exception e) {
            respuestaService = new RespuestaService();
            respuestaService.setErrorMensaje(e.getMessage());
        }
        return respuestaService;
    }    
}
