package co.uniandes.edu.service.Response;

/**
 *
 * @author Sergio Forero
 */
public class RespuestaService {
    
    /**
     * Campo que indíca si se ha presentado un error.
     */
    private Boolean sePresentoError;
    
    private String respuestaService;
    private String errorOriginal;
    private String errorMensaje;

    public Boolean getSePresentoError() {
        return sePresentoError;
    }

    public void setSePresentoError(Boolean sePresentoError) {
        this.sePresentoError = sePresentoError;
    } 
    
    public String getRespuestaService() {
        return respuestaService;
    }

    public void setRespuestaService(String respuestaService) {
        this.respuestaService = respuestaService;
    }

    public String getErrorOriginal() {
        return errorOriginal;
    }

    public void setErrorOriginal(String errorOriginal) {
        this.errorOriginal = errorOriginal;
    }

    public String getErrorMensaje() {
        return errorMensaje;
    }

    public void setErrorMensaje(String errorMensaje) {
        this.errorMensaje = errorMensaje;
    }        
}
