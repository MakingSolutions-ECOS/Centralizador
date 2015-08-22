/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class NacionalidadDto {

    private Integer codigoNacionalidad;
    private String nombreNacionaliad;
    private List<CiudadanoDto> ciudadanoList;

    public Integer getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(Integer codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public String getNombreNacionaliad() {
        return nombreNacionaliad;
    }

    public void setNombreNacionaliad(String nombreNacionaliad) {
        this.nombreNacionaliad = nombreNacionaliad;
    }

    public List<CiudadanoDto> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<CiudadanoDto> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

}
