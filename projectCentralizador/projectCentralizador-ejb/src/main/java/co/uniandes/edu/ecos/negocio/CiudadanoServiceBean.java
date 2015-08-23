package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.CiudadanoDto;
import co.uniandes.edu.ecos.persistencia.Ciudadano;
import co.uniandes.edu.ecos.plataforma.Mapper;
import co.uniandes.edu.service.Response.RespuestaCiudadano;
import co.uniandes.edu.service.Response.RespuestaService;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase para obtener y establecer información de ciudadanos.
 *
 * @author John Dany
 */
@PermitAll
@Stateless
public class CiudadanoServiceBean implements ICiudadanoServiceLocal {

    @PersistenceContext(unitName = "CentralizadorUP")
    EntityManager em;

    /**
     * Método para obtener el identificador único del usuario.
     *
     * @param identificador del ciudadano a obtener.
     * @return RespuestaCiudadano
     */
    @Override
    public RespuestaCiudadano obtenerCiudadanoPorIdentificador(Integer identificador) {
        RespuestaCiudadano respuestaCiudadano = new RespuestaCiudadano();
        try {
            Ciudadano entity = em.createNamedQuery("Ciudadano.findByCodigoCiudadano", Ciudadano.class).setParameter("codigoCiudadano", identificador).getSingleResult();
            respuestaCiudadano.setCiudadanoDto(Mapper.copyCompleto(entity, CiudadanoDto.class, true));
        } catch (IllegalArgumentException argumentException) {
            respuestaCiudadano.setSePresentoError(true);
            respuestaCiudadano.setErrorMensaje("La consulta de Emisor recibió un argumento inválido");
            respuestaCiudadano.setErrorOriginal(argumentException.getMessage() + " Causa: " + argumentException.getCause().getMessage());
        } catch (Exception exception) {
            respuestaCiudadano.setSePresentoError(true);
            respuestaCiudadano.setErrorMensaje("La consulta de Emisor envió excepción general");
            respuestaCiudadano.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }

        return respuestaCiudadano;
    }

    @Override
    public RespuestaCiudadano obtenerCiudadanoPorIdentifacionYTipoDeIdentificacion(Integer identificacion, Integer tipoIdentificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método para insertar un ciudadano en la base de datos.
     * @param ciudadano a insertar.
     * @return RespuestaService
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED) 
    @Override
    public RespuestaService crearCiudadano(CiudadanoDto ciudadano) {
        RespuestaService respuestaService = new RespuestaService();
        try {
            if (ciudadano == null) {
                respuestaService.setSePresentoError(true);
                respuestaService.setErrorMensaje("Error, se ha enviado un ciudadano nulo a insertar.");
            } else {
                em.getTransaction().begin();
                em.persist(Mapper.copyCompleto(ciudadano, Ciudadano.class, false));
                em.getTransaction().commit();
                respuestaService.setRespuestaService("Se ha creado el ciudadano correctamente.");
            }
        } catch (Exception exception) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("La consulta de Emisor envió excepción general");
            respuestaService.setErrorOriginal(exception.getMessage() + " Causa: " + exception.getCause().getMessage());
        }

        return respuestaService;
    }
}
