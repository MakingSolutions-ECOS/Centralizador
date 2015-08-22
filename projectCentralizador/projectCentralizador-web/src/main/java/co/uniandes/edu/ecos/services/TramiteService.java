/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.services;

import co.uniandes.edu.ecos.negocio.ITramiteServiceLocal;
import co.uniandes.edu.service.Response.RespuestaTramite;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sergio Forero
 */
@WebService(serviceName = "TramiteService")
public class TramiteService {

    @EJB
    private ITramiteServiceLocal tramiteServiceBean;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerTramites")
    public RespuestaTramite obtenerTramites() {
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite = tramiteServiceBean.obtenerTramites();
        return respuestaTramite;
    }
}
