/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.EmisorDto;
import co.uniandes.edu.ecos.dto.TramiteDto;
import co.uniandes.edu.ecos.persistencia.CategoriasTramite;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.ecos.persistencia.TramiteDefinicion;
import co.uniandes.edu.ecos.persistencia.TramiteEstado;
import co.uniandes.edu.service.Response.RespuestaService;
import co.uniandes.edu.service.Response.RespuestaTramite;
import co.uniandes.edu.service.Response.RespuestaTramiteDefinicion;
import javax.ejb.Local;
import javax.persistence.PersistenceException;

/**
 *
 * @author Usuario
 */
@Local
public interface ITramiteServiceLocal {

    public RespuestaTramite obtenerTramites();

    public RespuestaTramite obtenerTramitesPorCiudadano(Integer identificador);
    
    public RespuestaTramite obtenerTramitesPorEstado(TramiteEstado tramiteEstado);
    
    public RespuestaTramite obtenerTramitePorEntidad(Emisor emisor);
    
    public RespuestaTramiteDefinicion obtenerTramitesDefinicion();

    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorEntidad(Emisor e);

    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorCategoria(CategoriasTramite codigoCategoria);

    public RespuestaService iniciarTramite(TramiteDto tramiteDto) throws PersistenceException;
    
    public RespuestaTramite consultarTramiteEntidadEstado(Integer codigoEntidadEmisora, Integer codigoTramiteEstado);

    public RespuestaService CambiarEstadoTramite(Integer idTramite, Integer idEntidadEmisora, Integer idEstadoTramite);
}
