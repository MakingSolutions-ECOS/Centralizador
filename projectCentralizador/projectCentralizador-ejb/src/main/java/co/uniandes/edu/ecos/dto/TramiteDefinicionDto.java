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
public class TramiteDefinicionDto {

    private Integer codigoTramiteDefinicion;
    private String definicion;
    private short habilitado;
    private String descripcion;
    private CategoriasTramiteDto codigoCategoria;
    private EmisorDto codigoEntidadEmisora;
    private List<DocumentoRequeridoTramiteDto> documentoRequeridoTramiteList;

    public Integer getCodigoTramiteDefinicion() {
        return codigoTramiteDefinicion;
    }

    public void setCodigoTramiteDefinicion(Integer codigoTramiteDefinicion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public short getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(short habilitado) {
        this.habilitado = habilitado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriasTramiteDto getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(CategoriasTramiteDto codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public EmisorDto getCodigoEntidadEmisora() {
        return codigoEntidadEmisora;
    }

    public void setCodigoEntidadEmisora(EmisorDto codigoEntidadEmisora) {
        this.codigoEntidadEmisora = codigoEntidadEmisora;
    }

    public List<DocumentoRequeridoTramiteDto> getDocumentoRequeridoTramiteList() {
        return documentoRequeridoTramiteList;
    }

    public void setDocumentoRequeridoTramiteList(List<DocumentoRequeridoTramiteDto> documentoRequeridoTramiteList) {
        this.documentoRequeridoTramiteList = documentoRequeridoTramiteList;
    }

}
