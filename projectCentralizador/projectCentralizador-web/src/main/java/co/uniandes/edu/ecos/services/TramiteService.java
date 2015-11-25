package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.dto.SolicitudTramiteDto;
import co.uniandes.edu.ecos.negocio.ITramiteServiceLocal;
import co.uniandes.edu.ecos.persistencia.CategoriasTramite;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.ecos.persistencia.TramiteEstado;
import co.uniandes.edu.service.Response.RespuestaService;
import co.uniandes.edu.service.Response.RespuestaTramite;
import co.uniandes.edu.service.Response.RespuestaTramiteDefinicion;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sergio Forero
 */
@WebService(serviceName = "TramiteService")
public class TramiteService {
    
    @EJB
    private ITramiteServiceLocal tramiteServiceBean;

    /**
     * Obtiene todos los tramites iniciados
     *
     * @return RespuestaTramite
     */
    @WebMethod(operationName = "obtenerTramites")
    public RespuestaTramite obtenerTramites() {
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite = tramiteServiceBean.obtenerTramites();
        return respuestaTramite;
    }

    /**
     * Iniciar nuevo tramite
     *
     * @param tramiteDto
     * @return RespuestaTramite
     */
    @WebMethod(operationName = "iniciarTramite")
    public RespuestaService iniciarTramite(SolicitudTramiteDto solicitudTramiteDto) {
        RespuestaService respuestaService = new RespuestaService();
        try {            
            respuestaService = tramiteServiceBean.iniciarTramite(solicitudTramiteDto);
        } catch (Exception e) {
            respuestaService = new RespuestaService();
            respuestaService.setErrorMensaje(e.getMessage());
        }
        return respuestaService;
    }

    /**
     * Obtiene todos los tramites definidos
     *
     * @return RespuestaTramiteDefinicion
     */
    @WebMethod(operationName = "obtenerTramitesDefinicion")
    public RespuestaTramiteDefinicion obtenerTramitesDefinicion() {
        RespuestaTramiteDefinicion respuestaTramite = new RespuestaTramiteDefinicion();
        respuestaTramite = tramiteServiceBean.obtenerTramitesDefinicion();
        return respuestaTramite;
    }

    /**
     * Obtiene todos los tramites definidos por entidad
     *
     * @return RespuestaTramiteDefinicion
     */
    @WebMethod(operationName = "obtenerTramitesDefinicionPorEntidad")
    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorEntidad(Integer codigoEntidadEmisora) {
        RespuestaTramiteDefinicion respuestaTramite = new RespuestaTramiteDefinicion();
        Emisor e = new Emisor(codigoEntidadEmisora);
        respuestaTramite = tramiteServiceBean.obtenerTramitesDefinicionPorEntidad(e);
        return respuestaTramite;
    }

    /**
     * Obtiene todos los tramites definidos por categoria
     *
     * @return RespuestaTramiteDefinicion
     */
    @WebMethod(operationName = "obtenerTramitesDefinicionPorCategoria")
    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorCategoria(Integer codigoCategoria) {
        RespuestaTramiteDefinicion respuestaTramite = new RespuestaTramiteDefinicion();
        CategoriasTramite ct = new CategoriasTramite(codigoCategoria);
        respuestaTramite = tramiteServiceBean.obtenerTramitesDefinicionPorCategoria(ct);
        return respuestaTramite;
    }
    
    /**
     * Obtiene los tramites actuales de un ciudadano dado su código.
     * @param codigoCiudadano
     * @return respuestaTramite
     */
    @WebMethod(operationName = "obtenerTramitesPorCiudadano")
    public RespuestaTramite obtenerTramitesPorCiudadano(@WebParam(name = "codigoCiudadano") Integer codigoCiudadano){
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite = tramiteServiceBean.obtenerTramitesPorCiudadano(codigoCiudadano);
        return respuestaTramite;
    }
    
    /**
     * Obtiene los tramites actuales dado su estado actual.
     * @param codigoTramiteEstado
     * @return respuestaTramite
     */
    @WebMethod(operationName = "obtenerTramitesPorEstado")
    public RespuestaTramite obtenerTramitesPorEstado(@WebParam(name = "codigoTramiteEstado") Integer codigoTramiteEstado){
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        TramiteEstado tramiteEstado = new TramiteEstado();
        tramiteEstado.setCodigoTramiteEstado(codigoTramiteEstado);
        respuestaTramite = tramiteServiceBean.obtenerTramitesPorEstado(tramiteEstado);
        return respuestaTramite;
    }    
    
    /**
     * Obtiene los tramites actuales dado una entidad especifica.
     * @param codigoEntidadEmisora
     * @return respuestaTramite
     */
    @WebMethod(operationName = "obtenerTramitePorEntidad")
    public RespuestaTramite obtenerTramitePorEntidad(@WebParam(name = "codigoEntidadEmisora") Integer codigoEntidadEmisora){
        RespuestaTramite respuestaTramite = null;
        Emisor emisor = new Emisor(codigoEntidadEmisora);        
        respuestaTramite = tramiteServiceBean.obtenerTramitePorEntidad(emisor);
        return respuestaTramite;
    }    
    
    /**
     * Metodo que cambia el estado del tramite a notificado
     * @param idTramite
     * @param idEntidadEmisora
     * @param idEstado
     * @return 
     */
    @WebMethod(operationName = "cambiarEstadoTramiteProceso")
    public RespuestaService cambiarEstadoTramiteProceso(Integer idTramite, Integer idEntidadEmisora,Integer idEstado) {
        RespuestaService respuestaService = new RespuestaService();
        respuestaService = tramiteServiceBean.CambiarEstadoTramite(idTramite, idEntidadEmisora, idEstado);
        return respuestaService;
    }      
}
