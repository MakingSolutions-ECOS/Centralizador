/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.MetadataTipoDocumentoDto;
import co.uniandes.edu.ecos.persistencia.MetadataTipoDocumento;
import co.uniandes.edu.ecos.plataforma.Mapper;
import co.uniandes.edu.service.Response.RespuestaMetadata;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author John Dany
 */
@Stateless
public class MetadataServiceBean implements IMetadataServiceLocal {

    @PersistenceContext(unitName = "CentralizadorUP")
    EntityManager em;
    
    /**
     * Retorna respuesta con tipos de documento en Metadata
     * @return  RespuestaMetadata
     */
    @Override
    public RespuestaMetadata obtenerTiposDocumentoMetadata() {
        RespuestaMetadata metadata = new RespuestaMetadata();
        List<MetadataTipoDocumento> metadataTipoDocumentos= em.createNamedQuery("MetadataTipoDocumento.findAll",MetadataTipoDocumento.class).getResultList();
        for(MetadataTipoDocumento tipoDocumento : metadataTipoDocumentos){            
             MetadataTipoDocumentoDto documentoDto = Mapper.copyCompleto(tipoDocumento, MetadataTipoDocumentoDto.class, false);
             metadata.getTiposDocumentoMetaData().add(documentoDto);            
        }
        return metadata;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}