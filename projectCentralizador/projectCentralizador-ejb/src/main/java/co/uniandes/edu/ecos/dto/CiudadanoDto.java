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
public class CiudadanoDto {

    private Integer codigoCiudadano;
    private short habilitadoCiudadano;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String identificacion;
    private Date fechaExpedicionIdentificacion;
    private String telefonoFijo;
    private String celular;
    private String direccion;
    private String correo;
    private List<TramiteDto> tramiteList;
    private MunicipioDto codigoMunicipio;
    private NacionalidadDto codigoNacionalidad;
    private OperadorDto codigoOperador;
    private TipoIdentificacionDto codigoTipoIdentificacion;
    private TipoPersonaDto codigoTipoPersona;

    public Integer getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(Integer codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public short getHabilitadoCiudadano() {
        return habilitadoCiudadano;
    }

    public void setHabilitadoCiudadano(short habilitadoCiudadano) {
        this.habilitadoCiudadano = habilitadoCiudadano;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaExpedicionIdentificacion() {
        return fechaExpedicionIdentificacion;
    }

    public void setFechaExpedicionIdentificacion(Date fechaExpedicionIdentificacion) {
        this.fechaExpedicionIdentificacion = fechaExpedicionIdentificacion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<TramiteDto> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<TramiteDto> tramiteList) {
        this.tramiteList = tramiteList;
    }

    public MunicipioDto getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(MunicipioDto codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public NacionalidadDto getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(NacionalidadDto codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public OperadorDto getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(OperadorDto codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public TipoIdentificacionDto getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(TipoIdentificacionDto codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public TipoPersonaDto getCodigoTipoPersona() {
        return codigoTipoPersona;
    }

    public void setCodigoTipoPersona(TipoPersonaDto codigoTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona;
    }

}
