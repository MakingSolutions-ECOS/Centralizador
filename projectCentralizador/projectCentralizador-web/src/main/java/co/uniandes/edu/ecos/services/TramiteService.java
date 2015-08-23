package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.negocio.ITramiteServiceLocal;
import co.uniandes.edu.service.Response.RespuestaTramite;
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
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "obtenerTramites")
    public RespuestaTramite obtenerTramites() {
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite = tramiteServiceBean.obtenerTramites();
        return respuestaTramite;
    }
}
