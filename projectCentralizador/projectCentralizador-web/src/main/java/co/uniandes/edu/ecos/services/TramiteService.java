package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.dto.TramiteDto;
import co.uniandes.edu.ecos.negocio.ITramiteServiceLocal;
import co.uniandes.edu.ecos.persistencia.CategoriasTramite;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.service.Response.RespuestaService;
import co.uniandes.edu.service.Response.RespuestaTramite;
import co.uniandes.edu.service.Response.RespuestaTramiteDefinicion;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;

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
    public RespuestaService iniciarTramite(TramiteDto tramiteDto) {
        RespuestaService respuestaService = new RespuestaService();
        try {            
            respuestaService = tramiteServiceBean.iniciarTramite(tramiteDto);
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
}
