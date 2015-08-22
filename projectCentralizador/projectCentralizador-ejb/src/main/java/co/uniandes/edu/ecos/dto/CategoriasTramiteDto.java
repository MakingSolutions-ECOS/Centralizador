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
public class CategoriasTramiteDto {

    private Integer codigoCategoria;
    private String nombreCategoria;
    private List<TramiteDefinicionDto> tramiteDefinicionList;

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<TramiteDefinicionDto> getTramiteDefinicionList() {
        return tramiteDefinicionList;
    }

    public void setTramiteDefinicionList(List<TramiteDefinicionDto> tramiteDefinicionList) {
        this.tramiteDefinicionList = tramiteDefinicionList;
    }

}
