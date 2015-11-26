/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

import java.util.List;

/**
 *
 * @author Sergio Forero
 */
public class TipoIdentificacionDto {

    private Integer codigoTipoIdentificacion;
    private String nombreTipoIdentificacion;
    private List<CiudadanoDto> ciudadanoList;
    private List<UsuarioDto> usuarioList;

    public Integer getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(Integer codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public String getNombreTipoIdentificacion() {
        return nombreTipoIdentificacion;
    }

    public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }

    public List<CiudadanoDto> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<CiudadanoDto> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    public List<UsuarioDto> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<UsuarioDto> usuarioList) {
        this.usuarioList = usuarioList;
    }

}
