/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.dto.MetadataTipoDocumentoDto;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author John Dany
 */
@WebService(serviceName = "ServicioWebCentralizador")
public class ServicioWebCentralizador {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hola " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerMetadataTiposDocumentos")
    public List<MetadataTipoDocumentoDto> obtenerMetadataTiposDocumentos() {
        //TODO write your implementation code here:
        List<MetadataTipoDocumentoDto> metadatas = new ArrayList<>();
        MetadataTipoDocumentoDto metadata = new MetadataTipoDocumentoDto();
        metadata.setCodigoMetadataTipoDocumento(1);
        metadata.setDescripcionMetadataTipoDocumento("Mi tipo de doc");
        metadata.setNombreMetadataTipoDocumento("Doc prueba");
        metadata.setValidezDocumento(3);
        metadatas.add(metadata);
        return metadatas;
    }
}
