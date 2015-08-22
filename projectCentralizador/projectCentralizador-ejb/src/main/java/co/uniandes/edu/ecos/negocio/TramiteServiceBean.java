/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.persistencia.Tramite;
import co.uniandes.edu.service.Response.RespuestaTramite;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class TramiteServiceBean implements ITramiteServiceLocal{
    
    @PersistenceContext(unitName = "CentralizadorUP")
    EntityManager em;
    
    /**
     * Metodo encargado de obtener todos los tramites
     * @return 
     */
    @Override
    public RespuestaTramite obtenerTramites(){
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        try {
            List<Tramite> tramites = em.createNamedQuery("Tramite.findAll",Tramite.class).getResultList();
        } catch (Exception e) {
        }
        return respuestaTramite;
    }
    
}
