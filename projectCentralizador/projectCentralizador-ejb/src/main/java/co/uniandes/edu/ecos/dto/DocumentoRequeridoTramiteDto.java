/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

/**
 *
 * @author Sergio Forero
 */
public class DocumentoRequeridoTramiteDto {

    private Integer codigoDocumentoRequerido;
    private MetadataTipoDocumentoDto codigoMetadataTipoDocumento;
    private TramiteDefinicionDto codigoTramiteDefinicion;

    public Integer getCodigoDocumentoRequerido() {
        return codigoDocumentoRequerido;
    }

    public void setCodigoDocumentoRequerido(Integer codigoDocumentoRequerido) {
        this.codigoDocumentoRequerido = codigoDocumentoRequerido;
    }

    public MetadataTipoDocumentoDto getCodigoMetadataTipoDocumento() {
        return codigoMetadataTipoDocumento;
    }

    public void setCodigoMetadataTipoDocumento(MetadataTipoDocumentoDto codigoMetadataTipoDocumento) {
        this.codigoMetadataTipoDocumento = codigoMetadataTipoDocumento;
    }

    public TramiteDefinicionDto getCodigoTramiteDefinicion() {
        return codigoTramiteDefinicion;
    }

    public void setCodigoTramiteDefinicion(TramiteDefinicionDto codigoTramiteDefinicion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
    }

}
