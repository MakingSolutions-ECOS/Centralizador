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
public class TipoPersonaDto {

    private Integer codigoTipoPersona;
    private String nombreTipoPersona;
    private List<CiudadanoDto> ciudadanoList;

    public Integer getCodigoTipoPersona() {
        return codigoTipoPersona;
    }

    public void setCodigoTipoPersona(Integer codigoTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public List<CiudadanoDto> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<CiudadanoDto> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

}
