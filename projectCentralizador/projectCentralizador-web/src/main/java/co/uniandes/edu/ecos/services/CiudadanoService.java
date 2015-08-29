package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.dto.CiudadanoDto;
import co.uniandes.edu.ecos.negocio.ICiudadanoServiceLocal;
import co.uniandes.edu.service.Response.RespuestaCiudadano;
import co.uniandes.edu.service.Response.RespuestaService;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Servicio web para realizar operaciones relacionadas con el ciudadadano.
 *
 * @author John Dany
 */
@WebService(serviceName = "CiudadanoService")
public class CiudadanoService {

    /**
     * Negocio de Ciudadano
     */
    @EJB
    private ICiudadanoServiceLocal ciudadanoServiceBean;

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return String
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Método para obtener un ciudadano a través del código identificador.
     *
     * @param codigoIdentificador único del ciudadano.
     * @return RespuestaCiudadano
     */
    @WebMethod(operationName = "obtenerCiudadanoPorCodigoIdentificador")
    public RespuestaCiudadano obtenerCiudadanoPorCodigoIdentificador(@WebParam(name = "codigoIdentificador") int codigoIdentificador) {
        return ciudadanoServiceBean.obtenerCiudadanoPorIdentificador(codigoIdentificador);
    }

    /**
     * Método para obtener un ciudadano a través de su identificación y su tipo
     * de identificación.
     *
     * @param identificacion del ciudanano
     * @param tipoIdentifiacion de identificación del ciudadano
     * @return RespuestaCiudadano
     */
    @WebMethod(operationName = "obtenerUsuarioPorIdentificacionYTipoDeIdentificacion")
    public RespuestaCiudadano obtenerUsuarioPorIdentificacionYTipoDeIdentificacion(@WebParam(name = "identificacion") String identificacion, @WebParam(name = "tipoIdentifiacion") int tipoIdentifiacion) {
        return ciudadanoServiceBean.obtenerCiudadanoPorIdentifacionYTipoDeIdentificacion(identificacion, tipoIdentifiacion);
    }

    /**
     * Método para crear un ciudadano en la carpeta ciudadana.
     *
     * @param ciudadano a insertar.
     * @return RespuestaService como resultado en la operación.
     */
    @WebMethod(operationName = "crearCiudadano")
    public RespuestaService crearCiudadano(@WebParam(name = "ciudadano") CiudadanoDto ciudadano) {
        return ciudadanoServiceBean.crearCiudadano(ciudadano);
    }

    /**
     * Método para actualizar un ciudadano en la carpeta ciudadana.
     *
     * @param ciudadano a actualizar.
     * @return RespuestaService como resultado en la operación.
     */
    @WebMethod(operationName = "actualizarCiudadano")
    public RespuestaService actualizarCiudadano(@WebParam(name = "ciudadano") CiudadanoDto ciudadano) {
        return ciudadanoServiceBean.actaulizarCiudadano(ciudadano);
    }
}
