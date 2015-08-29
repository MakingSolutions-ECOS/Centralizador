/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.EmisorDto;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.service.Response.RespuestaEmisor;
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
     * @return  RespuestaMetadata
     */
    @Override
    public RespuestaEmisor obtenerEmisores() {
        RespuestaEmisor emisorRes = new RespuestaEmisor();
        try {
            List<Emisor> emisores = em.createNamedQuery("Emisor.findAll", Emisor.class).getResultList();
            for (Emisor emisor : emisores) {
                EmisorDto emisorDto = Mapper.copyCompleto(emisor, EmisorDto.class, false);
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
}
