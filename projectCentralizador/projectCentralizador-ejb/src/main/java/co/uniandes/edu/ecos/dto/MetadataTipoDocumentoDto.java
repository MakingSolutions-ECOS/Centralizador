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
public class MetadataTipoDocumentoDto {

    private Integer codigoMetadataTipoDocumento;
    private String nombreMetadataTipoDocumento;
    private String descripcionMetadataTipoDocumento;
    private int validezDocumento;

    public Integer getCodigoMetadataTipoDocumento() {
        return codigoMetadataTipoDocumento;
    }

    public void setCodigoMetadataTipoDocumento(Integer codigoMetadataTipoDocumento) {
        this.codigoMetadataTipoDocumento = codigoMetadataTipoDocumento;
    }

    public String getNombreMetadataTipoDocumento() {
        return nombreMetadataTipoDocumento;
    }

    public void setNombreMetadataTipoDocumento(String nombreMetadataTipoDocumento) {
        this.nombreMetadataTipoDocumento = nombreMetadataTipoDocumento;
    }

    public String getDescripcionMetadataTipoDocumento() {
        return descripcionMetadataTipoDocumento;
    }

    public void setDescripcionMetadataTipoDocumento(String descripcionMetadataTipoDocumento) {
        this.descripcionMetadataTipoDocumento = descripcionMetadataTipoDocumento;
    }

    public int getValidezDocumento() {
        return validezDocumento;
    }

    public void setValidezDocumento(int validezDocumento) {
        this.validezDocumento = validezDocumento;
    }
}
