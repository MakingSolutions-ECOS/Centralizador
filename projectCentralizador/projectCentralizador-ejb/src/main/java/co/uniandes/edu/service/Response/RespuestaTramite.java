/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.persistencia.Tramite;
import java.util.List;

/**
 *
 * @author Sergio Forero
 */
public class RespuestaTramite extends RespuestaService {

    private List<Tramite> tramites;

    public RespuestaTramite() {
    }

    public RespuestaTramite(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

}
