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
public class MunicipioDto {

    private Integer codigoMunicipio;
    private String nombreMunicipio;
    private List<CiudadanoDto> ciudadanoList;
    private DepartamentoDto codigoDepartamento;

    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public List<CiudadanoDto> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<CiudadanoDto> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    public DepartamentoDto getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(DepartamentoDto codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

}
