/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.DocumentoRequeridoTramiteDto;
import co.uniandes.edu.ecos.dto.EmisorDto;
import co.uniandes.edu.ecos.dto.TramiteDefinicionDto;
import co.uniandes.edu.ecos.persistencia.DocumentoRequeridoTramite;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.ecos.persistencia.TramiteDefinicion;
import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.service.Response.RespuestaEmisor;
import co.uniandes.edu.service.Response.RespuestaService;
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
public class EmisorServiceBean implements IEmisorServiceLocal {
    
    @PersistenceContext(unitName = "CentralizadorUP")
    EntityManager em;

    /**
     * Retorna respuesta con tipos de documento en Metadata
     *
     * @return RespuestaMetadata
     */
    @Override
    public RespuestaEmisor obtenerEmisores() {
        RespuestaEmisor emisorRes = new RespuestaEmisor();
        try {
            List<Emisor> emisores = em.createNamedQuery("Emisor.findAll", Emisor.class).getResultList();
            for (Emisor emisor : emisores) {
                
                EmisorDto emisorDto = Mapper.copyCompleto(emisor, EmisorDto.class, true);
                
                List<TramiteDefinicionDto> listaTramitesNuevos = new ArrayList<>();
                
                for (int i = 0; i < emisor.getTramiteDefinicionList().size(); i++) {
                    TramiteDefinicion tramiteDefinicion = emisor.getTramiteDefinicionList().get(i);
                    
                    List<DocumentoRequeridoTramiteDto> documentosNuevos = new ArrayList<DocumentoRequeridoTramiteDto>();
                    for (DocumentoRequeridoTramite drt : tramiteDefinicion.getDocumentoRequeridoTramiteList()) {
                        DocumentoRequeridoTramiteDto documentoRequeridoTramiteDto = Mapper.copyCompleto(drt, DocumentoRequeridoTramiteDto.class, true);
                        documentosNuevos.add(documentoRequeridoTramiteDto);
                    }
                    TramiteDefinicionDto tdd = Mapper.copyCompleto(tramiteDefinicion, TramiteDefinicionDto.class, true);
                    
                    tdd.setDocumentoRequeridoTramiteList(documentosNuevos);
                    
                    listaTramitesNuevos.add(Mapper.copyCompleto(tramiteDefinicion, TramiteDefinicionDto.class, true));
                }
                
                emisorDto.setTramiteDefinicionList(listaTramitesNuevos);
                
                emisorRes.getEmisores().add(emisorDto);
            }
            
        } catch (IllegalArgumentException argumentException) {
            emisorRes.setSePresentoError(true);
            emisorRes.setErrorMensaje("La consulta de Emisor recibió un argumento inválido");
            emisorRes.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            emisorRes.setSePresentoError(true);
            emisorRes.setErrorMensaje("La consulta de Emisor envió excepción general");
            emisorRes.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return emisorRes;
    }
    
    @Override
    public RespuestaEmisor obtenerEmisor(String codigoEmisor) {
        RespuestaEmisor emisorRes = new RespuestaEmisor();
        try {
            List<Emisor> emisores = em.createNamedQuery("Emisor.findByCodigoEntidadEmisora", Emisor.class).setParameter("codigoEntidadEmisora", codigoEmisor).getResultList();
            for (Emisor emisor : emisores) {
                EmisorDto emisorDto = Mapper.copyCompleto(emisor, EmisorDto.class, false);
                emisorRes.getEmisores().add(emisorDto);
            }
        } catch (IllegalArgumentException argumentException) {
            emisorRes.setErrorMensaje("La consulta de Emisor recibió un argumento inválido");
            emisorRes.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            emisorRes.setErrorMensaje("La consulta de Emisor envió excepción general");
            emisorRes.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }
        return emisorRes;
    }
    
    @Override
    public RespuestaEmisor crearEmisor(EmisorDto emisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public RespuestaEmisor actualizarEmisor(EmisorDto emisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public RespuestaService deleteEmisor(String codigoEmisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
