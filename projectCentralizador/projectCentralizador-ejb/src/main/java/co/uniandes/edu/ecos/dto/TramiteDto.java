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
public class TramiteDto {

    private Integer codigoTramite;
    private Integer codigoTramiteOperador;
    private CiudadanoDto codigoCiudadano;
    private TramiteDefinicionDto codigoTramiteDefinicion;
    private TramiteEstadoDto codigoTramiteEstado;
    private List<TramiteActividadDto> tramiteActividadList;

    public Integer getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(Integer codigoTramite) {
        this.codigoTramite = codigoTramite;
    }
    
    public Integer getCodigoTramiteOperador() {
        return codigoTramiteOperador;
    }

    public void setCodigoTramiteOperador(Integer codigoTramiteOperador) {
        this.codigoTramiteOperador = codigoTramiteOperador;
    }    

    public CiudadanoDto getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(CiudadanoDto codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public TramiteDefinicionDto getCodigoTramiteDefinicion() {
        return codigoTramiteDefinicion;
    }

    public void setCodigoTramiteDefinicion(TramiteDefinicionDto codigoTramiteDefinicion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
    }

    public TramiteEstadoDto getCodigoTramiteEstado() {
        return codigoTramiteEstado;
    }

    public void setCodigoTramiteEstado(TramiteEstadoDto codigoTramiteEstado) {
        this.codigoTramiteEstado = codigoTramiteEstado;
    }

    public List<TramiteActividadDto> getTramiteActividadList() {
        return tramiteActividadList;
    }

    public void setTramiteActividadList(List<TramiteActividadDto> tramiteActividadList) {
        this.tramiteActividadList = tramiteActividadList;
    }

}
