package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.MetadataTipoDocumentoDto;
import co.uniandes.edu.ecos.persistencia.MetadataTipoDocumento;
import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.service.Response.RespuestaMetadata;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author John Dany
 */
@PermitAll
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
            try {
                MetadataTipoDocumentoDto documentoDto = Mapper.copyCompleto(tipoDocumento, MetadataTipoDocumentoDto.class, false);            
                metadata.getTiposDocumentoMetaData().add(documentoDto);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MetadataServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return metadata;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
