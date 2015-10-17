/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.TramiteDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio Forero
 */
public class RespuestaTramite extends RespuestaService {

    private List<TramiteDto> tramites;

    public RespuestaTramite() {
        tramites = new ArrayList<>();
    }

    public RespuestaTramite(List<TramiteDto> tramites) {
        this.tramites = tramites;
    }

    public List<TramiteDto> getTramiteDtos() {
        return tramites;
    }

    public void setTramiteDtos(List<TramiteDto> tramites) {
        this.tramites = tramites;
    }

}
