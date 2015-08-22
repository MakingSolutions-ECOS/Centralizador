/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

/**
 *
 * @author Usuario
 */
public class UsuarioDto {

    private Integer codigoUsuario;
    private String primerNombreUsuario;
    private String segundoNombreUsuario;
    private String primeroApellidoUsuario;
    private String segundoApellidoUsuario;
    private String correoUsuario;
    private String identificacionUsuario;
    private RolDto codigoRol;
    private TipoIdentificacionDto codigoTipoIdentificacion;

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getPrimerNombreUsuario() {
        return primerNombreUsuario;
    }

    public void setPrimerNombreUsuario(String primerNombreUsuario) {
        this.primerNombreUsuario = primerNombreUsuario;
    }

    public String getSegundoNombreUsuario() {
        return segundoNombreUsuario;
    }

    public void setSegundoNombreUsuario(String segundoNombreUsuario) {
        this.segundoNombreUsuario = segundoNombreUsuario;
    }

    public String getPrimeroApellidoUsuario() {
        return primeroApellidoUsuario;
    }

    public void setPrimeroApellidoUsuario(String primeroApellidoUsuario) {
        this.primeroApellidoUsuario = primeroApellidoUsuario;
    }

    public String getSegundoApellidoUsuario() {
        return segundoApellidoUsuario;
    }

    public void setSegundoApellidoUsuario(String segundoApellidoUsuario) {
        this.segundoApellidoUsuario = segundoApellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public RolDto getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(RolDto codigoRol) {
        this.codigoRol = codigoRol;
    }

    public TipoIdentificacionDto getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(TipoIdentificacionDto codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

}
