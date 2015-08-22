/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.*;
import co.uniandes.edu.ecos.persistencia.*;
import co.uniandes.edu.ecos.plataforma.Mapper;
import co.uniandes.edu.service.Response.*;
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
        RespuestaEmisor respuestaEmisor = new RespuestaEmisor();
        List<Emisor> emisores= em.createNamedQuery("Emisor.findAll",Emisor.class).getResultList();
        for(Emisor emisor : emisores){            
             EmisorDto emisorDto = Mapper.copyCompleto(emisor, EmisorDto.class, false);
             respuestaEmisor.getEmisores().add(emisorDto);            
        }
        return respuestaEmisor;
    }
}
