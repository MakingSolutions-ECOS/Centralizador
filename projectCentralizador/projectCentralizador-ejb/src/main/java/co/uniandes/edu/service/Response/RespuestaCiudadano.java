package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.CiudadanoDto;

/**
 * Respuesta al consultar un ciudadano.
 *
 * @author John Dany
 */
public class RespuestaCiudadano extends RespuestaService {

    /**
     * CiudadanoDto
     */
    private CiudadanoDto ciudadanoDto;

    /**
     * Obtiene el ciudadano.
     *
     * @return
     */
    public CiudadanoDto getCiudadanoDto() {
        return ciudadanoDto;
    }

    /**
     * Estableceel ciudadano.
     *
     * @param ciudadanoDto a establecer.
     */
    public void setCiudadanoDto(CiudadanoDto ciudadanoDto) {
        this.ciudadanoDto = ciudadanoDto;
    }
}
