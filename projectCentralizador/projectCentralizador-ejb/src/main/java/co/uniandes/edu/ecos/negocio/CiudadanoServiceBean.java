package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.CiudadanoDto;
import co.uniandes.edu.ecos.dto.TipoIdentificacionDto;
import co.uniandes.edu.ecos.persistencia.Ciudadano;
import co.uniandes.edu.ecos.persistencia.TipoIdentificacion;
import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.service.Response.RespuestaCiudadano;
import co.uniandes.edu.service.Response.RespuestaService;
import co.uniandes.edu.service.Response.RespuestaTipoIdentificacion;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

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
     * Método para obtener el ciudadano por el identificador único.
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

        } catch (NoResultException noResultException) {
            respuestaCiudadano.setSePresentoError(false);
            respuestaCiudadano.setRespuestaService("Ciudadano no encontrado.");
            respuestaCiudadano.setErrorOriginal(noResultException.getMessage() != null ? noResultException.getMessage() : "");
        } catch (IllegalArgumentException argumentException) {
            respuestaCiudadano.setSePresentoError(true);
            respuestaCiudadano.setErrorMensaje("La consulta de Ciudadano recibió un argumento inválido");
            respuestaCiudadano.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : "" + " " + argumentException.getCause() != null ? "Causa: " + argumentException.getCause().getMessage() : "");
        } catch (Exception exception) {
            respuestaCiudadano.setSePresentoError(true);
            respuestaCiudadano.setErrorMensaje("La consulta de Ciudadano envió excepción general");
            respuestaCiudadano.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaCiudadano;
    }

    /**
     * Método para obtener un ciudadano por su identificación y su tipo de
     * identifiación.
     *
     * @param identificacion del ciudadano.
     * @param tipoIdentificacion correspondiente a la identificación
     * parametrizada.
     * @return RespuestaCiudadano
     */
    @Override
    public RespuestaCiudadano obtenerCiudadanoPorIdentifacionYTipoDeIdentificacion(String identificacion, Integer tipoIdentificacion) {

        TipoIdentificacion tipoId = new TipoIdentificacion();
        tipoId.setCodigoTipoIdentificacion(tipoIdentificacion);
        RespuestaCiudadano respuestaCiudadano = new RespuestaCiudadano();
        try {
            Ciudadano entity = em.createNamedQuery("Ciudadano.findByIdentificacionAndTipoIdenitificacion", Ciudadano.class).setParameter("identificacion", identificacion).setParameter("codigoTipoIdentificacion", tipoId).getSingleResult();
            respuestaCiudadano.setCiudadanoDto(Mapper.copyCompleto(entity, CiudadanoDto.class, true));

        } catch (NoResultException noResultException) {
            respuestaCiudadano.setSePresentoError(false);
            respuestaCiudadano.setRespuestaService("Ciudadano no encontrado.");
            respuestaCiudadano.setErrorOriginal(noResultException.getMessage() != null ? noResultException.getMessage() : "");
        } catch (IllegalArgumentException argumentException) {
            respuestaCiudadano.setSePresentoError(true);
            respuestaCiudadano.setErrorMensaje("La consulta de Ciudadadano recibió un argumento inválido");
            respuestaCiudadano.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : "" + " " + argumentException.getCause() != null ? "Causa: " + argumentException.getCause().getMessage() : "");
        } catch (Exception exception) {
            respuestaCiudadano.setSePresentoError(true);
            respuestaCiudadano.setErrorMensaje("La consulta de Ciudadano envió excepción general");
            respuestaCiudadano.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " " + exception.getCause() != null ? "Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaCiudadano;
    }

    /**
     * Método para insertar un ciudadano en la base de datos.
     *
     * @param ciudadano a insertar.
     * @return RespuestaService
     */
    @Override
    public RespuestaService crearCiudadano(CiudadanoDto ciudadano) {
        RespuestaService respuestaService = new RespuestaService();
        try {
            if (ciudadano == null) {
                respuestaService.setSePresentoError(true);
                respuestaService.setErrorMensaje("Error, se ha enviado un ciudadano nulo a insertar.");
            } else {
                //em.getTransaction().begin();
                em.persist(Mapper.copyCompleto(ciudadano, Ciudadano.class, false));
                //em.getTransaction().commit();
                respuestaService.setRespuestaService("Se ha creado el ciudadano correctamente.");
            }
        } catch (PersistenceException exception) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("La creación del ciudadano envió excepción general");
            respuestaService.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " " + exception.getCause() != null ? "Causa: " + exception.getCause().getMessage() : "");
        } catch (Exception exception) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("La creación del ciudadano envió excepción general");
            respuestaService.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " " + exception.getCause() != null ? "Causa: " + exception.getCause().getMessage() : "");

        }

        return respuestaService;
    }

    /**
     * Método que permite actualizar la información de un ciudadano.
     *
     * @param ciudadanoDto
     * @return RespuestaService
     */
    @Override
    public RespuestaService actaulizarCiudadano(CiudadanoDto ciudadanoDto) {
        RespuestaService respuestaService = new RespuestaService();
        try {
            if (ciudadanoDto == null) {
                respuestaService.setSePresentoError(true);
                respuestaService.setErrorMensaje("Error, se ha enviado un ciudadano nulo a actualizar.");
            } else {
                em.merge(Mapper.copyCompleto(ciudadanoDto, Ciudadano.class, false));
                respuestaService.setRespuestaService("Se ha actualizado el ciudadano correctamente.");
            }
        } catch (Exception exception) {
            respuestaService.setSePresentoError(true);
            respuestaService.setErrorMensaje("La actualización del ciudadano se envió excepción general");
            respuestaService.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " " + exception.getCause() != null ? "Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaService;
    }

    /**
     * Método para obtener todos los tipos de identificaciones de un usuario o
     * un ciudadano.
     *
     * @return objeto RespuestaTipoIdentificacion.
     */
    @Override
    public RespuestaTipoIdentificacion obtenerTipoIdentificaciones() {
        RespuestaTipoIdentificacion respuestaTipoIdentificacion = new RespuestaTipoIdentificacion();

        try {
            List<TipoIdentificacion> tipoIdentificaciones = em.createNamedQuery("TipoIdentificacion.findAll", TipoIdentificacion.class).getResultList();
            for (TipoIdentificacion tipoIdentificacion : tipoIdentificaciones) {
                TipoIdentificacionDto tipoIdentificacionDto = Mapper.copyCompleto(tipoIdentificacion, TipoIdentificacionDto.class, false);
                respuestaTipoIdentificacion.getTipoIdentificacionDtos().add(tipoIdentificacionDto);
            }

        } catch (NoResultException noResultException) {
            respuestaTipoIdentificacion.setSePresentoError(false);
            respuestaTipoIdentificacion.setRespuestaService("Tipos de identificación sin resultados.");
            respuestaTipoIdentificacion.setErrorOriginal(noResultException.getMessage() != null ? noResultException.getMessage() : "");
        } catch (IllegalArgumentException argumentException) {
            respuestaTipoIdentificacion.setSePresentoError(true);
            respuestaTipoIdentificacion.setErrorMensaje("La consulta de los tipos de identificación recibió un argumento inválido");
            respuestaTipoIdentificacion.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : "" + " " + argumentException.getCause() != null ? "Causa: " + argumentException.getCause().getMessage() : "");
        } catch (Exception exception) {
            respuestaTipoIdentificacion.setSePresentoError(true);
            respuestaTipoIdentificacion.setErrorMensaje("La consulta de los tipos de identificación envió excepción una general");
            respuestaTipoIdentificacion.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaTipoIdentificacion;
    }
}
