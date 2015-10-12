package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.dto.CiudadanoDto;
import co.uniandes.edu.ecos.negocio.ICiudadanoServiceLocal;
import co.uniandes.edu.ecos.negocio.IOperadorServiceLocal;
import co.uniandes.edu.service.Response.RespuestaCiudadano;
import co.uniandes.edu.service.Response.RespuestaOperador;
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
     * Negocio de Operador
     */
    @EJB
    private IOperadorServiceLocal OperadorServiceBean;

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
     * @param identificacionOperador autorizado para realizar consultas de
     * ciudadano.
     * @param codigoIdentificador único del ciudadano.
     * @return RespuestaCiudadano
     */
    @WebMethod(operationName = "obtenerCiudadanoPorCodigoIdentificador")
    public RespuestaCiudadano obtenerCiudadanoPorCodigoIdentificador(@WebParam(name = "identificacionOperador") String identificacionOperador, @WebParam(name = "codigoIdentificador") int codigoIdentificador) {
        RespuestaOperador operador = this.OperadorServiceBean.operadorConSuscripcionPorIdentifiacion(identificacionOperador);
        if (operador != null && operador.getOperador() != null) {
            return ciudadanoServiceBean.obtenerCiudadanoPorIdentificador(codigoIdentificador);
        } else {
            RespuestaCiudadano respuestaCiudadano = new RespuestaCiudadano();
            respuestaCiudadano.setErrorMensaje(operador.getErrorMensaje() != null ? operador.getErrorMensaje() : "");
            respuestaCiudadano.setErrorOriginal(operador.getErrorOriginal() != null ? operador.getErrorOriginal() : "");
            respuestaCiudadano.setRespuestaService(operador.getRespuestaService() != null ? operador.getRespuestaService() : "");
            respuestaCiudadano.setSePresentoError(operador.getSePresentoError());
            return respuestaCiudadano;
        }
    }

    /**
     * Método para obtener un ciudadano a través de su identificación y su tipo
     * de identificación.
     *
     * @param identificacion del ciudanano
     * @param tipoIdentifiacion de identificación del ciudadano
     * @param identificacionOperador autorizado para realizar consultas de
     * ciudadano.
     * @return RespuestaCiudadano
     */
    @WebMethod(operationName = "obtenerUsuarioPorIdentificacionYTipoDeIdentificacion")
    public RespuestaCiudadano obtenerUsuarioPorIdentificacionYTipoDeIdentificacion(@WebParam(name = "identificacionOperador") String identificacionOperador, @WebParam(name = "identificacion") String identificacion, @WebParam(name = "tipoIdentifiacion") int tipoIdentifiacion) {
        RespuestaOperador operador = this.OperadorServiceBean.operadorConSuscripcionPorIdentifiacion(identificacionOperador);
        if (operador != null && operador.getOperador() != null) {
            return ciudadanoServiceBean.obtenerCiudadanoPorIdentifacionYTipoDeIdentificacion(identificacion, tipoIdentifiacion);
        } else {
            RespuestaCiudadano respuestaCiudadano = new RespuestaCiudadano();
            respuestaCiudadano.setErrorMensaje(operador.getErrorMensaje() != null ? operador.getErrorMensaje() : "");
            respuestaCiudadano.setErrorOriginal(operador.getErrorOriginal() != null ? operador.getErrorOriginal() : "");
            respuestaCiudadano.setRespuestaService(operador.getRespuestaService() != null ? operador.getRespuestaService() : "");
            respuestaCiudadano.setSePresentoError(operador.getSePresentoError());
            return respuestaCiudadano;
        }
    }

    /**
     * Método para crear un ciudadano en la carpeta ciudadana.
     *
     * @param identificacionOperador autorizado para realizar consultas de
     * ciudadano.
     * @param ciudadano a insertar.
     * @return RespuestaService como resultado en la operación.
     */
    @WebMethod(operationName = "crearCiudadano")
    public RespuestaService crearCiudadano(@WebParam(name = "identificacionOperador") String identificacionOperador, @WebParam(name = "ciudadano") CiudadanoDto ciudadano) {
        RespuestaOperador operador = this.OperadorServiceBean.operadorConSuscripcionPorIdentifiacion(identificacionOperador);
        if (operador != null && operador.getOperador() != null) {
            return ciudadanoServiceBean.crearCiudadano(ciudadano);
        } else {
            RespuestaService respuestaService = new RespuestaService();
            respuestaService.setErrorMensaje(operador.getErrorMensaje() != null ? operador.getErrorMensaje() : "");
            respuestaService.setErrorOriginal(operador.getErrorOriginal() != null ? operador.getErrorOriginal() : "");
            respuestaService.setRespuestaService(operador.getRespuestaService() != null ? operador.getRespuestaService() : "");
            respuestaService.setSePresentoError(operador.getSePresentoError());
            return respuestaService;
        }
    }

    /**
     * Método para actualizar un ciudadano en la carpeta ciudadana.
     *
     * @param identificacionOperador autorizado para realizar consultas de
     * ciudadano.
     * @param ciudadano a actualizar.
     * @return RespuestaService como resultado en la operación.
     */
    @WebMethod(operationName = "actualizarCiudadano")
    public RespuestaService actualizarCiudadano(@WebParam(name = "identificacionOperador") String identificacionOperador, @WebParam(name = "ciudadano") CiudadanoDto ciudadano) {
        RespuestaOperador operador = this.OperadorServiceBean.operadorConSuscripcionPorIdentifiacion(identificacionOperador);
        if (operador != null && operador.getOperador() != null) {
            return ciudadanoServiceBean.actaulizarCiudadano(ciudadano);
        } else {
            RespuestaService respuestaService = new RespuestaService();
            respuestaService.setErrorMensaje(operador.getErrorMensaje() != null ? operador.getErrorMensaje() : "");
            respuestaService.setErrorOriginal(operador.getErrorOriginal() != null ? operador.getErrorOriginal() : "");
            respuestaService.setRespuestaService(operador.getRespuestaService() != null ? operador.getRespuestaService() : "");
            respuestaService.setSePresentoError(operador.getSePresentoError());
            return respuestaService;
        }
    }
}
