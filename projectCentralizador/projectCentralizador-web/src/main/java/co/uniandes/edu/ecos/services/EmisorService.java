package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.negocio.IEmisorServiceLocal;
import co.uniandes.edu.service.Response.RespuestaEmisor;
import javax.ejb.EJB;
import javax.jws.WebService;        
import javax.jws.WebMethod;

/**
 * Servicio web para interactuar con los emisores.
 * @author Camilo Marroquin
 */
@WebService(serviceName = "EmisorService")
public class EmisorService {

    /**
     * Instancia de EmisorServiceBean
     */
    @EJB
    private IEmisorServiceLocal emisorServiceBean;

    /**
     * Método que obtiene la colección de emisores.
     * 
     * @return RespuestaEmisor
     */
    @WebMethod(operationName = "obtenerEmisores")
    public RespuestaEmisor obtenerEmisores() {
       return emisorServiceBean.obtenerEmisores();
    }
}
