/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

/**
 *
 * @author John Dany
 */
public class EmisorDto {

    private String codigoEntidadEmisora;
    private String nombreEntidadEmisora;
    

    public String getCodigoEntidadEmisora(){
        return codigoEntidadEmisora;
    }

    public void setCodigoEntidadEmisora(String codigoEntidadEmisora) {
        this.codigoEntidadEmisora = codigoEntidadEmisora;
    }
    
    public String getNombreEntidadEmisora(){
        return nombreEntidadEmisora;
    }

    public void setNombreEntidadEmisora(String nombreEntidadEmisora) {
        this.nombreEntidadEmisora = nombreEntidadEmisora;
    }
}
