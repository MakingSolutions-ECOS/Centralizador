/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.negocio.IEmisorServiceLocal;
import co.uniandes.edu.service.Response.RespuestaEmisor;
import javax.ejb.EJB;
import javax.jws.WebService;        
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Camilo Marroquin
 */
@WebService(serviceName = "EmisorService")
public class EmisorService {

    @EJB
    private IEmisorServiceLocal emisorServiceBean;

    /**
     * Web service operation
     * 
     * @return 
     */
    @WebMethod(operationName = "obtenerEmisores")
    public RespuestaEmisor obtenerEmisores() {
        //TODO write your implementation code here:
        RespuestaEmisor emisores = new RespuestaEmisor();
        emisores = emisorServiceBean.obtenerEmisores();        
        return null;
    }
}
