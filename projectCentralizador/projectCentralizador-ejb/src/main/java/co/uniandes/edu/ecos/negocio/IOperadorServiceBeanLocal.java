package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.service.Response.RespuestaOperador;
import javax.ejb.Local;

/**
 *
 * @author John Dany
 */
@Local
public interface IOperadorServiceBeanLocal {

    /**
     *Definición del método para obtener un operador por código único.
     * @param codigoOperador que identifica el cliente.
     * @return objeto OperadorDto
     */
    RespuestaOperador obtenerOperadorPorCodigo(Integer codigoOperador);
    
    /**
     * Definición del método para obtener un operador por identificación.
     * @param identificacion
     * @return objeto OperadorDto
     */
    RespuestaOperador obtenerOperadorPorIdenficacion (String identificacion);
    
    /**
     * Definición del método para obtener un operador por identificación y verificar su suscripcion.
     * @param identificacion
     * @return objeto OperadorDto
     */
    RespuestaOperador operadorConSuscripcionPorIdentifiacion (String identificacion);
    
    /**
     * Definición del método para obtener un operador por su codigo y verificar su suscripcion.
     * @param codigoOperador
     * @return objeto OperadorDto
     */
    RespuestaOperador operadorConSuscripcionPorCodigo (Integer codigoOperador);
}
