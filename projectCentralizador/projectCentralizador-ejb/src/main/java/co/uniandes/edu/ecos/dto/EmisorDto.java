package co.uniandes.edu.ecos.dto;

/**
 * Clase que representa una entidad emisora.
 * @author John Dany
 */
public class EmisorDto {

    private Integer codigoEntidadEmisora;
    private String nombreEntidadEmisora;
    

    /**
     * Obtiene el codigo de la entidad emisora.
     * @return 
     */
    public Integer getCodigoEntidadEmisora(){
        return codigoEntidadEmisora;
    }

    /**
     * Establece el código de la entidad emisora.
     * @param codigoEntidadEmisora 
     */
    public void setCodigoEntidadEmisora(Integer codigoEntidadEmisora) {
        this.codigoEntidadEmisora = codigoEntidadEmisora;
    }
    
    /**
     * Obtiene el nombre de la entidad emisora.
     * @return String
     */
    public String getNombreEntidadEmisora(){
        return nombreEntidadEmisora;
    }

    /**
     * Establece el nombre de la entidad emisora.
     * @param nombreEntidadEmisora 
     */
    public void setNombreEntidadEmisora(String nombreEntidadEmisora) {
        this.nombreEntidadEmisora = nombreEntidadEmisora;
    }
}
