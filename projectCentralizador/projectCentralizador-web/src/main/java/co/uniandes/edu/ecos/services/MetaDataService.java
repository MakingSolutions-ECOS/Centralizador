/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.negocio.IMetadataServiceLocal;
import co.uniandes.edu.service.Response.RespuestaMetadata;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author John Dany
 */
@WebService(serviceName = "MetaDataService")
public class MetaDataService {

    @EJB
    private IMetadataServiceLocal metaDataServiceBean;  

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "obtenerMetadataTiposDocumentos")
    public RespuestaMetadata obtenerMetadataTiposDocumentos() {
        //TODO write your implementation code here:
        RespuestaMetadata metadata = new RespuestaMetadata();
        metadata = metaDataServiceBean.obtenerTiposDocumentoMetadata();
        return metadata;
    }
}
