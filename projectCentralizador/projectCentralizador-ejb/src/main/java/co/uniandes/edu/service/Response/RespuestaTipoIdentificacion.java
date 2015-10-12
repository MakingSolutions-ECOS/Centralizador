package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.TipoIdentificacionDto;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la respuesta a la consulta de los tipos de
 * identificación.
 *
 * @author John Dany
 */
public class RespuestaTipoIdentificacion extends RespuestaService {

    /**
     * Colección de tipos de identificación de una persona o ciudadano.
     */
    private List<TipoIdentificacionDto> tipoIdentificacionDtos;

    /**
     * Inicializa una nueva isntancia sin parámetros.
     */
    public RespuestaTipoIdentificacion() {
        this.tipoIdentificacionDtos = new ArrayList<TipoIdentificacionDto>();
    }

    /**
     * Inicializa una nueva isntancia con parámetros..
     *
     * @param tipoIdentificacionDtos
     */
    public RespuestaTipoIdentificacion(List<TipoIdentificacionDto> tipoIdentificacionDtos) {
        this.tipoIdentificacionDtos = tipoIdentificacionDtos;
    }

    /**
     * Obtiene una colección de tipos de identificación.
     *
     * @return colección de objetos de tipo TipoIdentificacionDto.
     */
    public List<TipoIdentificacionDto> getTipoIdentificacionDtos() {
        return tipoIdentificacionDtos;
    }

    /**
     * Establece una colección de tipos de identificación.
     *
     * @param tipoIdentificacionDtos a establecer.
     */
    public void setTipoIdentificacionDtos(List<TipoIdentificacionDto> tipoIdentificacionDtos) {
        this.tipoIdentificacionDtos = tipoIdentificacionDtos;
    }

}
