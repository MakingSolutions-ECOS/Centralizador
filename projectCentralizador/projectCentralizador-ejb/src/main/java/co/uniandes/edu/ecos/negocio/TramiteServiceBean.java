/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.SolicitudTramiteDto;
import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.ecos.dto.TramiteDefinicionDto;
import co.uniandes.edu.ecos.dto.TramiteDto;
import co.uniandes.edu.ecos.persistencia.CategoriasTramite;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.ecos.persistencia.Tramite;
import co.uniandes.edu.ecos.persistencia.TramiteDefinicion;
import co.uniandes.edu.ecos.persistencia.TramiteEstado;
import co.uniandes.edu.service.Response.RespuestaCiudadano;
import co.uniandes.edu.service.Response.RespuestaService;
import co.uniandes.edu.service.Response.RespuestaTramite;
import co.uniandes.edu.service.Response.RespuestaTramiteDefinicion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Sergio Forero
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
            respuestaTramite.setErrorMensaje("La consulta de Emisor recibiÃ³ un argumento invÃ¡lido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor enviÃ³ excepciÃ³n general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
    }
    
    /**
     * Metodo encargado de obtener los tramites actuales dado el cÃ³digo de un ciudadano.
     * @param codigoCiudadano
     * @return respuestaTramite
     */
    @Override
    public RespuestaTramite obtenerTramitesPorCiudadano(Integer codigoCiudadano){
        
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite.setTramiteDtos(new ArrayList<TramiteDto>());
        try {
            List<Tramite> tramites = em.createNamedQuery("Tramite.findByCodigoCiudadano", Tramite.class).setParameter("codigoCiudadano", codigoCiudadano).getResultList();
            for (Tramite tramite : tramites) {
                TramiteDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDto.class, true);
                respuestaTramite.getTramiteDtos().add(tramiteDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor recibiÃ³ un argumento invÃ¡lido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor enviÃ³ excepciÃ³n general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
        
    }
    
    /**
     * Metodo encargado de obtener los tramites actuales dado su estado.
     * @param tramiteEstado
     * @return respuestaTramite
     */
    @Override
    public RespuestaTramite obtenerTramitesPorEstado(TramiteEstado tramiteEstado) {

        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite.setTramiteDtos(new ArrayList<TramiteDto>());
        try {
            List<Tramite> tramites = em.createNamedQuery("Tramite.findByCodigoTramiteEstado", Tramite.class).setParameter("codigoTramiteEstado", tramiteEstado).getResultList();
            for (Tramite tramite : tramites) {
                TramiteDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDto.class, true);
                respuestaTramite.getTramiteDtos().add(tramiteDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor recibiÃ³ un argumento invÃ¡lido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor enviÃ³ excepciÃ³n general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;        
    }    

    /**
     * Metodo encargado de obtener los tramites actuales dado una entidad especifica.
     * @param emisor 
     * @return respuestaTramite
     */
    @Override
    public RespuestaTramite obtenerTramitePorEntidad(Emisor emisor) {
        
        RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite.setTramiteDtos(new ArrayList<TramiteDto>());
        
        try {
            List<Tramite> tramites = em.createNamedQuery("Tramite.findByCodigoEstado", Tramite.class).setParameter("codigoEntidadEmisora", emisor.getCodigoEntidadEmisora()).getResultList();
            for (Tramite tramite : tramites) {
                TramiteDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDto.class, true);
                respuestaTramite.getTramiteDtos().add(tramiteDto);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor recibió un argumento inválido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de Emisor enviá excepcián general");
            respuestaTramite.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;        
        
    }
    
    
    /**
     * Metodo encargado de obtener todos los tramites
     *
     * @param solicitudTramiteDto
     * @return RespuestaService
     */
    @Override
    public RespuestaService iniciarTramite(SolicitudTramiteDto solicitudTramiteDto) throws PersistenceException{
        RespuestaService respuestaService = new RespuestaService();
        try {
            Tramite tramite = Mapper.copyCompleto(solicitudTramiteDto.getTramiteDto(), Tramite.class, false);
            em.persist(tramite);
            respuestaService.setRespuestaService("Se ha iniciado el tramite.");
            respuestaService.setSePresentoError(false);
            return respuestaService;
        }catch (IllegalArgumentException argumentException) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("Se recibiÃ³ un argumento invÃ¡lido");
            respuestaService.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
            return null;
        } catch (Exception exception) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("La creaciÃ³n enviÃ³ excepciÃ³n general");
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
            respuestaTramite.setErrorMensaje("La consulta de tramite recibiÃ³ un argumento invÃ¡lido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite enviÃ³ excepciÃ³n general");
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
            respuestaTramite.setErrorMensaje("La consulta de tramite por Emisor recibiÃ³ un argumento invÃ¡lido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : " " + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por Emisor enviÃ³ excepciÃ³n general");
            respuestaTramite.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : " " + " Causa: " + exception.getCause().getMessage());
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
            respuestaTramite.setErrorMensaje("La consulta de tramite por categoria recibiÃ³ un argumento invÃ¡lido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : " " + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por categoria enviÃ³ excepciÃ³n general");
            respuestaTramite.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : " " + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
    }

    
    /**
     * Metodo que retorna los tramites pendientes
     * @param codigoEntidadEmisora
     * @param codigoTramiteEstado
     * @return 
     */
    @Override
    public RespuestaTramite consultarTramiteEntidadEstado(Integer codigoEntidadEmisora, Integer codigoTramiteEstado){
    RespuestaTramite respuestaTramite = new RespuestaTramite();
        respuestaTramite.setTramiteDtos(new ArrayList<TramiteDto>());
        try {
            List<Tramite> tramites = em.createNamedQuery("Tramite.findByEstadoPendienteTramite", Tramite.class).setParameter("codigoEntidadEmisora", codigoEntidadEmisora).setParameter("codigoTramiteEstado", codigoTramiteEstado).getResultList();
            for (Tramite tramite : tramites) {
                TramiteDto tramiteDto = Mapper.copyCompleto(tramite, TramiteDto.class, true);
                respuestaTramite.getTramiteDtos().add(tramiteDto);
                                
                // Se marca la el tramite como en proceso
                tramite.setCodigoTramiteEstado(em.find(TramiteEstado.class, 2));
                em.persist(tramite);
            }
        } catch (IllegalArgumentException argumentException) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por estado recibiÃ³ un argumento invÃ¡lido");
            respuestaTramite.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : " "  + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaTramite.setSePresentoError(true);
            respuestaTramite.setErrorMensaje("La consulta de tramite por estado enviÃ³ excepciÃ³n general");
            respuestaTramite.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : " " + " Causa: " + exception.getCause().getMessage());
        }
        return respuestaTramite;
        
    }

    /**
     * Motodo que cambia el estado de un tramite
     * @param codigoTramite
     * @param codigoEntidadEmisora
     * @param idEstadoTramite
     * @return 
     */
    @Override
    public RespuestaService CambiarEstadoTramite(Integer codigoTramite, Integer codigoEntidadEmisora, Integer idEstadoTramite) {
        RespuestaService respuesta = new RespuestaService();
        try {
            //Obtener la entidad
            Tramite tramite = em.createNamedQuery("Tramite.findByCodigoTramite", Tramite.class).setParameter("codigoTramite", codigoTramite).getSingleResult();
            
            if (tramite == null) {
                //Setear la respuesta
                respuesta.setSePresentoError(true);
                respuesta.setErrorMensaje("El tramite con ese Id no está registrado en el sistema.");
                return respuesta;
            }
            
            //Cambiar de estado
            if (tramite.getCodigoTramiteDefinicion().getCodigoEntidadEmisora().getCodigoEntidadEmisora() == codigoEntidadEmisora) {
                tramite.setCodigoTramiteEstado(em.find(TramiteEstado.class, 2));
                em.persist(tramite);
                //Setear la respuesta
                respuesta.setSePresentoError(false);
                respuesta.setErrorMensaje("El cambio se realizó de forma correcta"); 
            }
            else
            {
                //Setear la respuesta
                respuesta.setSePresentoError(true);
                respuesta.setErrorMensaje("El tramite con ese Id no está asignado a esa entidad emisora.");  
            }          
            
        } catch (IllegalArgumentException argumentException) {
            respuesta.setSePresentoError(true);
            respuesta.setErrorMensaje("La consulta de tramite por estado recibiÃ³ un argumento invÃ¡lido");
            respuesta.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : " "  + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuesta.setSePresentoError(true);
            respuesta.setErrorMensaje("La consulta de tramite por estado enviÃ³ excepciÃ³n general");
            respuesta.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : " " + " Causa: " + exception.getCause().getMessage());
        }
        return respuesta;
    }
}
