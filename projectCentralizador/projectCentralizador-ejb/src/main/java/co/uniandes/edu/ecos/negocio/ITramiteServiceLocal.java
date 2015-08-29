/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.negocio;

import co.uniandes.edu.ecos.persistencia.CategoriasTramite;
import co.uniandes.edu.ecos.persistencia.Emisor;
import co.uniandes.edu.service.Response.RespuestaTramite;
import co.uniandes.edu.service.Response.RespuestaTramiteDefinicion;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface ITramiteServiceLocal {

    public RespuestaTramite obtenerTramites();

    public RespuestaTramiteDefinicion obtenerTramitesDefinicion();

    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorEntidad(Emisor e);

    public RespuestaTramiteDefinicion obtenerTramitesDefinicionPorCategoria(CategoriasTramite codigoCategoria);

}
