package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.CiudadanoDto;
import co.uniandes.edu.service.Response.RespuestaCiudadano;
import co.uniandes.edu.service.Response.RespuestaService;
import javax.ejb.Local;

/**
 * Definición de los métodos relacionados con un ciudadano.
 *
 * @author John Dany
 */
@Local
public interface ICiudadanoServiceLocal {

    /**
     * Método para obtener el identificador único del usuario.
     *
     * @param identificador del ciudadano.
     * @return objeto RespuestaCiudadano
     */
    RespuestaCiudadano obtenerCiudadanoPorIdentificador(Integer identificador);

    /**
     * Método para obtener un usuario por el número de identificación y el tipo
     * de identificación.
     *
     * @param identificacion del ciudadano.
     * @param tipoIdentificacion correspondiente a la identificación del
     * ciudadano.
     * @return objeto RespuestaCiudadano.
     */
    RespuestaCiudadano obtenerCiudadanoPorIdentifacionYTipoDeIdentificacion(String identificacion, Integer tipoIdentificacion);

    /**
     * Método que permite la creación de un ciudadano.
     *
     * @param ciudadano
     * @return RespuestaService
     */
    RespuestaService crearCiudadano(CiudadanoDto ciudadano);
}
