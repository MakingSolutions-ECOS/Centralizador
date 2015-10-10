package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.OperadorDto;

/**
 * Respuesta a la consulta de un operador.
 *
 * @author John Dany
 */
public class RespuestaOperador extends RespuestaService {

    /**
     * Operador de carpeta ciudadana.
     */
    private OperadorDto operador;

    /**
     * Obtiene el operador
     * @return objeto OperadorDto.
     */
    public OperadorDto getOperador() {
        return operador;
    }

    /**
     * Establece el operador
     * @param operador a establecer.
     */
    public void setOperador(OperadorDto operador) {
        this.operador = operador;
    }
}
