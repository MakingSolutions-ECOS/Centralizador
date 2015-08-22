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
public class DepartamentoDto {
    private Integer codigoDepartamento;
    private String nombreDepartamento;
    private List<MunicipioDto> municipioList;

    public Integer getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Integer codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public List<MunicipioDto> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<MunicipioDto> municipioList) {
        this.municipioList = municipioList;
    }
    
    
}
