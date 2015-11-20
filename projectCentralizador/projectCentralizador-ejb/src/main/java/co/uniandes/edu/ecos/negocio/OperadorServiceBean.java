package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.OperadorDto;
import co.uniandes.edu.ecos.dto.SuscripcionDto;
import co.uniandes.edu.ecos.persistencia.Operador;
import co.uniandes.edu.ecos.utilidad.Mapper;
import co.uniandes.edu.service.Response.RespuestaOperador;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John Dany
 */
@PermitAll
@Stateful
public class OperadorServiceBean implements IOperadorServiceLocal {

    /**
     * Administrador de entidades.
     */
    @PersistenceContext(unitName = "CentralizadorUP")
    EntityManager em;

    /**
     * Método que obtiene un operador
     *
     * @param codigoOperador a consultar
     * @return objeto RespuestaOperador
     */
    @Override
    public RespuestaOperador obtenerOperadorPorCodigo(Integer codigoOperador) {
        RespuestaOperador respuestaOperador = new RespuestaOperador();
        try {
            Operador entity = em.createNamedQuery("Operador.findByCodigoOperador", Operador.class).setParameter("codigoOperador", codigoOperador).getSingleResult();
            respuestaOperador.setOperador(Mapper.copyCompleto(entity, OperadorDto.class, true));

        } catch (NoResultException noResultException) {
            respuestaOperador.setSePresentoError(false);
            respuestaOperador.setRespuestaService("Operador no encontrado.");
            respuestaOperador.setErrorOriginal(noResultException.getMessage() != null ? noResultException.getMessage() : "");
        } catch (IllegalArgumentException argumentException) {
            respuestaOperador.setSePresentoError(true);
            respuestaOperador.setErrorMensaje("La consulta de Operador recibió un argumento inválido");
            respuestaOperador.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : "" + " " + argumentException.getCause() != null ? "Causa: " + argumentException.getCause().getMessage() : "");
        } catch (Exception exception) {
            respuestaOperador.setSePresentoError(true);
            respuestaOperador.setErrorMensaje("La consulta de Operador envió excepción general");
            respuestaOperador.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaOperador;
    }

    /**
     * Método que obtiene el operador por su identificación.
     *
     * @param identificacion a consultar.
     * @return objeto RespuestaOperador.
     */
    @Override
    public RespuestaOperador obtenerOperadorPorIdenficacion(String identificacion) {
        RespuestaOperador respuestaOperador = new RespuestaOperador();
        try {
            Operador entity = em.createNamedQuery("Operador.findByIdentificacionOperador", Operador.class).setParameter("identificacionOperador", identificacion).getSingleResult();
            respuestaOperador.setOperador(Mapper.copyCompleto(entity, OperadorDto.class, true));

        } catch (NoResultException noResultException) {
            respuestaOperador.setSePresentoError(false);
            respuestaOperador.setRespuestaService("Operador no encontrado.");
            respuestaOperador.setErrorOriginal(noResultException.getMessage() != null ? noResultException.getMessage() : "");
        } catch (IllegalArgumentException argumentException) {
            respuestaOperador.setSePresentoError(true);
            respuestaOperador.setErrorMensaje("La consulta de Operador recibió un argumento inválido");
            respuestaOperador.setErrorOriginal(argumentException.getMessage() != null ? argumentException.getMessage() : "" + " " + argumentException.getCause() != null ? "Causa: " + argumentException.getCause().getMessage() : "");
        } catch (Exception exception) {
            respuestaOperador.setSePresentoError(true);
            respuestaOperador.setErrorMensaje("La consulta de Operador envió excepción general");
            respuestaOperador.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaOperador;
    }

    @Override
    public RespuestaOperador operadorConSuscripcionPorIdentifiacion(String identificacion) {
        RespuestaOperador respuestaOperador = new RespuestaOperador();
        try {
            respuestaOperador = this.obtenerOperadorPorIdenficacion(identificacion);
            respuestaOperador = validarRespuestaOperadorSuscrito(respuestaOperador);

        } catch (Exception exception) {
            respuestaOperador.setSePresentoError(true);
            respuestaOperador.setOperador(null);
            respuestaOperador.setErrorMensaje("La consulta de Operador envió excepción general");
            respuestaOperador.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaOperador;
    }

    @Override
    public RespuestaOperador operadorConSuscripcionPorCodigo(Integer codigoOperador) {
        RespuestaOperador respuestaOperador = new RespuestaOperador();
        try {
            respuestaOperador = this.obtenerOperadorPorCodigo(codigoOperador);
            respuestaOperador = validarRespuestaOperadorSuscrito(respuestaOperador);

        } catch (Exception exception) {
            respuestaOperador.setSePresentoError(true);
            respuestaOperador.setErrorMensaje("La consulta de Operador envió excepción general");
            respuestaOperador.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }
        return respuestaOperador;
    }

    /**
     * Metodo que validad una respuesta y verfica si el operador tiene la
     * suscripcion vigente.
     *
     * @param respuesta a validar
     * @return objeto RespuestaOperador
     */
    private RespuestaOperador validarRespuestaOperadorSuscrito(RespuestaOperador respuesta) {
        RespuestaOperador respuestaOperador = null;
        try {
            OperadorDto operador = respuesta.getOperador();
            if (respuesta != null && operador != null) {
                List<SuscripcionDto> suscripciones = operador.getSuscripcionList();
                if (suscripciones != null && suscripciones.size() > 0) {
                    boolean suscrito = false;

                    for (SuscripcionDto sus : suscripciones) {
                        if (sus.getVigente()) {
                            suscrito = true;
                            break;
                        }
                    }

                    if (suscrito) {
                        return respuesta;
                    } else {
                        respuestaOperador = new RespuestaOperador();
                        respuestaOperador.setRespuestaService("El operador no se encuentra con una suscripción vigente.");
                        respuestaOperador.setErrorOriginal("");
                        respuestaOperador.setSePresentoError(false);
                    }
                } else {
                    respuestaOperador = new RespuestaOperador();
                    respuestaOperador.setRespuestaService("El operador no se encuentra con una suscripción vigente.");
                    respuestaOperador.setErrorOriginal("");
                    respuestaOperador.setSePresentoError(false);
                }
            } else {
                return respuesta;
            }

        } catch (Exception exception) {
            respuestaOperador = new RespuestaOperador();
            respuestaOperador.setSePresentoError(true);
            respuestaOperador.setErrorMensaje("La consulta de Operador envió excepción general");
            respuestaOperador.setErrorOriginal(exception.getMessage() != null ? exception.getMessage() : "" + " Causa: " + exception.getCause() != null ? " Causa: " + exception.getCause().getMessage() : "");
        }

        return respuestaOperador;
    }
}
