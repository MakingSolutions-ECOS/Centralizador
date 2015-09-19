/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.dto.EmisorDto;
import co.uniandes.edu.service.Response.*;
import javax.ejb.Local;

/**
 *
 * @author Camilo Marroquin
 */
@Local
public interface IEmisorServiceLocal {

    RespuestaEmisor crearEmisor(EmisorDto emisor);

    RespuestaEmisor obtenerEmisores();

    RespuestaEmisor obtenerEmisor(String codigoEmisor);

    RespuestaEmisor actualizarEmisor(EmisorDto emisor);
    
    RespuestaService deleteEmisor(String codigoEmisor);
}
