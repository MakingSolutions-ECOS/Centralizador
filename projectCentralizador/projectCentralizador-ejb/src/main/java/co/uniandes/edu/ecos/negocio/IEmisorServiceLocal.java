/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.service.Response.*;
import javax.ejb.Local;

/**
 *
 * @author John Dany
 */
@Local
public interface IEmisorServiceLocal {
    
    RespuestaEmisor obtenerEmisores ();
}
