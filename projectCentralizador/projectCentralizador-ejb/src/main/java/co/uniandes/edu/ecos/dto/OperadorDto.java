/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class OperadorDto {

    private Integer codigoOperador;
    private String identificacionOperador;
    private String nombreOperador;
    private Date fechaActivacion;
    private Date fechaActualizacion;
    private List<CiudadanoDto> ciudadanoList;
    private List<SuscripcionDto> suscripcionList;

    public Integer getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(Integer codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public String getIdentificacionOperador() {
        return identificacionOperador;
    }

    public void setIdentificacionOperador(String identificacionOperador) {
        this.identificacionOperador = identificacionOperador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<CiudadanoDto> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<CiudadanoDto> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    public List<SuscripcionDto> getSuscripcionList() {
        return suscripcionList;
    }

    public void setSuscripcionList(List<SuscripcionDto> suscripcionList) {
        this.suscripcionList = suscripcionList;
    }

}
