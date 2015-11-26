/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.TramiteDefinicionDto;
import java.util.List;

/**
 *
 * @author Sergio Forero
 */
public class RespuestaTramiteDefinicion extends RespuestaService {

    private List<TramiteDefinicionDto> tramiteDefinicionDtos;

    public RespuestaTramiteDefinicion() {
    }

    public RespuestaTramiteDefinicion(List<TramiteDefinicionDto> tramiteDefinicionDtos) {
        this.tramiteDefinicionDtos = tramiteDefinicionDtos;
    }

    public List<TramiteDefinicionDto> getTramiteDefinicionDtos() {
        return tramiteDefinicionDtos;
    }

    public void setTramiteDefinicionDtos(List<TramiteDefinicionDto> tramiteDefinicionDtos) {
        this.tramiteDefinicionDtos = tramiteDefinicionDtos;
    }

}
