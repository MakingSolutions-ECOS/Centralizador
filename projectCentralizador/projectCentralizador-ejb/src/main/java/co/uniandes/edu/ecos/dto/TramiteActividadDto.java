/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

import java.util.Date;

/**
 *
 * @author Sergio Forero
 */
public class TramiteActividadDto {

    private Integer codigoTramiteActividad;
    private Date fechaTramiteActividad;
    private String descripcionTramiteActividad;
    private TramiteDto codigoTramite;

    public Integer getCodigoTramiteActividad() {
        return codigoTramiteActividad;
    }

    public void setCodigoTramiteActividad(Integer codigoTramiteActividad) {
        this.codigoTramiteActividad = codigoTramiteActividad;
    }

    public Date getFechaTramiteActividad() {
        return fechaTramiteActividad;
    }

    public void setFechaTramiteActividad(Date fechaTramiteActividad) {
        this.fechaTramiteActividad = fechaTramiteActividad;
    }

    public String getDescripcionTramiteActividad() {
        return descripcionTramiteActividad;
    }

    public void setDescripcionTramiteActividad(String descripcionTramiteActividad) {
        this.descripcionTramiteActividad = descripcionTramiteActividad;
    }

    public TramiteDto getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(TramiteDto codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

}
