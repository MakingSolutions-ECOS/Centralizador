/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.MetadataTipoDocumentoDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John Dany
 */
public class RespuestaMetadata extends RespuestaService{

    public RespuestaMetadata() {
        this.tiposDocumentoMetaData = new ArrayList<>();
    }

    public RespuestaMetadata(List<MetadataTipoDocumentoDto> tiposDocumentoMetaData) {
        this.tiposDocumentoMetaData = tiposDocumentoMetaData;
    }
    
    private List<MetadataTipoDocumentoDto> tiposDocumentoMetaData;

    public List<MetadataTipoDocumentoDto> getTiposDocumentoMetaData() {
        return tiposDocumentoMetaData;
    }

    public void setTiposDocumentoMetaData(List<MetadataTipoDocumentoDto> tiposDocumentoMetaData) {
        this.tiposDocumentoMetaData = tiposDocumentoMetaData;
    }
    
    
    
}
