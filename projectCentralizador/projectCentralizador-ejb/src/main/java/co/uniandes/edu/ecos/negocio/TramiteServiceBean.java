/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.TramiteDto;
import co.uniandes.edu.ecos.persistencia.Tramite;
import co.uniandes.edu.ecos.plataforma.Mapper;
import co.uniandes.edu.service.Response.RespuestaTramite;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@PermitAll
@Stateless
public class TramiteServiceBean implements ITramiteServiceLocal {

    @PersistenceContext(unitName = "CentralizadorUP")
    EntityManager em;

    /**
     * Metodo encargado de obtener todos los tramites
     *
     * @return
     */
    @Override
    public RespuestaTramite obtenerTramites() {
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        try {
            List<Tramite> tramites = em.createNamedQuery("Tramite.findAll", Tramite.class).getResultList();
            for (Tramite tramite : tramites) {
                TramiteDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDto.class, false);
                respuestaTramite.getTramiteDtos().add(tramiteDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor recibió un argumento inválido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor envió excepción general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
    }

}
