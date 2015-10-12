/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.NotificacionDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johans Gonzalez
 */
public class RespuestaNotificacion extends RespuestaService{
    
    private List<NotificacionDto> notificacionDto;
    
    public RespuestaNotificacion(){        
        this.notificacionDto =  new ArrayList<>();
    }
    
    public RespuestaNotificacion(List<NotificacionDto> notificacionDto){        
        this.notificacionDto =  notificacionDto;
    }
    
    public List<NotificacionDto> getNotificacionDto() {
        return this.notificacionDto;
    }

    public void setNotificacionDto(List<NotificacionDto> notificacionDto) {
        this.notificacionDto = notificacionDto;
    }    
}
