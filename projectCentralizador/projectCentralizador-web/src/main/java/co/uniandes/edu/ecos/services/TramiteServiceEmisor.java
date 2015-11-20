package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.negocio.ITramiteServiceLocal;
import co.uniandes.edu.service.Response.RespuestaService;
import co.uniandes.edu.service.Response.RespuestaTramite;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Sergio Forero
 */
@WebService(serviceName = "TramiteServiceEmisor")
public class TramiteServiceEmisor {
    
    @EJB
    private ITramiteServiceLocal tramiteServiceBean;

    /**
     * Obtiene todos los tramites iniciados
     *
     * @param codigoEntidadEmisora
     * @return RespuestaTramite
     */
    @WebMethod(operationName = "obtenerTramitesPendientesEntidadEmisor")
    public RespuestaTramite obtenerTramitesPendientesEntidadEmisor(Integer codigoEntidadEmisora) {
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite = tramiteServiceBean.consultarTramiteEntidadEstado(codigoEntidadEmisora, 1);
        return respuestaTramite;
    }
    
    /**
     * Metodo que cambia el estado del tramite a Terminado
     * @param idTramite
     * @param idEntidadEmisora
     * @return 
     */
    @WebMethod(operationName = "cambiarEstadoTramiteProcesoEmisor")
    public RespuestaService cambiarEstadoTramiteProcesoEmisor(Integer idTramite, Integer idEntidadEmisora) {
        RespuestaService respuestaService = new RespuestaService();
        respuestaService = tramiteServiceBean.CambiarEstadoTramite(idTramite, idEntidadEmisora, 3);
        return respuestaService;
    }      
}
