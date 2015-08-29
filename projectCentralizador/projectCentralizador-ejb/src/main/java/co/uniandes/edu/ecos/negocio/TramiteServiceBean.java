/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.ecos.dto.TramiteDefinicionDto;
import co.uniandes.edu.ecos.dto.TramiteDto;
import co.uniandes.edu.ecos.persistencia.CategoriasTramite;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.ecos.persistencia.Tramite;
import co.uniandes.edu.ecos.persistencia.TramiteDefinicion;
import co.uniandes.edu.service.Response.RespuestaService;
import co.uniandes.edu.service.Response.RespuestaTramite;
import co.uniandes.edu.service.Response.RespuestaTramiteDefinicion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

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
        respuestaTramite.setTramiteDtos(new ArrayList<TramiteDto>());
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

    /**
     * Metodo encargado de obtener todos los tramites
     *
     * @param tramiteDto
     * @return RespuestaService
     */
    @Override
    public RespuestaService iniciarTramite(TramiteDto tramiteDto) throws PersistenceException{
        RespuestaService respuestaService = new RespuestaService();
        try {
            Tramite tramite = Mapper.copyCompleto(tramiteDto, Tramite.class, false);
            em.persist(tramite);
            respuestaService.setRespuestaService("Se ha iniciado el tramite.");
            respuestaService.setSePresentoError(false);
            return respuestaService;
        }catch (IllegalArgumentException argumentException) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("Se recibió un argumento inválido");
            respuestaService.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
            return null;
        } catch (Exception exception) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("La creación envió excepción general");
            respuestaService.setErrorOriginal(exception.getMessage() + " " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
            return null;
        }        
    }

    /**
     * Metodo encargado de obtener todos los tramites definidos
     *
     * @return
     */
    @Override
    public RespuestaTramiteDefinicion obtenerTramitesDefinicion() {
        RespuestaTramiteDefinicion respuestaTramite = new RespuestaTramiteDefinicion();
        respuestaTramite.setTramiteDefinicionDtos(new ArrayList<TramiteDefinicionDto>());
        try {
            List<TramiteDefinicion> tramites = em.createNamedQuery("TramiteDefinicion.findAll", TramiteDefinicion.class).getResultList();
            for (TramiteDefinicion tramite : tramites) {
                TramiteDefinicionDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDefinicionDto.class, true);
                respuestaTramite.getTramiteDefinicionDtos().add(tramiteDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite recibió un argumento inválido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite envió excepción general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
    }

    /**
     * Metodo encargado de obtener todos los tramites definidos por entidad
     *
     * @param Emisor e
     * @return
     */
    @Override
    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorEntidad(Emisor e) {
        RespuestaTramiteDefinicion respuestaTramite = new RespuestaTramiteDefinicion();
        respuestaTramite.setTramiteDefinicionDtos(new ArrayList<TramiteDefinicionDto>());
        try {
            List<TramiteDefinicion> tramites = em.createNamedQuery("TramiteDefinicion.findByCodigoEmisor", TramiteDefinicion.class).setParameter("codigoEntidadEmisora", e).getResultList();
            for (TramiteDefinicion tramite : tramites) {
                TramiteDefinicionDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDefinicionDto.class, true);
                respuestaTramite.getTramiteDefinicionDtos().add(tramiteDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por Emisor recibió un argumento inválido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por Emisor envió excepción general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
    }

    /**
     * Metodo encargado de obtener todos los tramites definidos por categoria
     *
     * @param CategoriasTramite codigoCategoria
     * @return
     */
    @Override
    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorCategoria(CategoriasTramite codigoCategoria) {
        RespuestaTramiteDefinicion respuestaTramite = new RespuestaTramiteDefinicion();
        respuestaTramite.setTramiteDefinicionDtos(new ArrayList<TramiteDefinicionDto>());
        try {
            List<TramiteDefinicion> tramites = em.createNamedQuery("TramiteDefinicion.findByCodigoCategoria", TramiteDefinicion.class).setParameter("codigoCategoria", codigoCategoria).getResultList();
            for (TramiteDefinicion tramite : tramites) {
                TramiteDefinicionDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDefinicionDto.class, true);
                respuestaTramite.getTramiteDefinicionDtos().add(tramiteDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por categoria recibió un argumento inválido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por categoria envió excepción general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
    }

}
