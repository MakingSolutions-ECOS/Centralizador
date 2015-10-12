/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.NotificacionDto;
import co.uniandes.edu.service.Response.RespuestaNotificacion;
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
    
}
