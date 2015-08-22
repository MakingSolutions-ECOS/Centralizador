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
public class TramiteEstadoDto {

    private Integer codigoTramiteEstado;
    private String nombreTramiteEstado;
    private List<TramiteDto> tramiteList;

    public Integer getCodigoTramiteEstado() {
        return codigoTramiteEstado;
    }

    public void setCodigoTramiteEstado(Integer codigoTramiteEstado) {
        this.codigoTramiteEstado = codigoTramiteEstado;
    }

    public String getNombreTramiteEstado() {
        return nombreTramiteEstado;
    }

    public void setNombreTramiteEstado(String nombreTramiteEstado) {
        this.nombreTramiteEstado = nombreTramiteEstado;
    }

    public List<TramiteDto> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<TramiteDto> tramiteList) {
        this.tramiteList = tramiteList;
    }

}
