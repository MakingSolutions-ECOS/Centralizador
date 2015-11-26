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
public class RolDto {

    private Integer codigoRol;
    private String nombreRol;
    private List<RolPermisoDto> rolPermisoList;
    private List<UsuarioDto> usuarioList;

    public Integer getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(Integer codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<RolPermisoDto> getRolPermisoList() {
        return rolPermisoList;
    }

    public void setRolPermisoList(List<RolPermisoDto> rolPermisoList) {
        this.rolPermisoList = rolPermisoList;
    }

    public List<UsuarioDto> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<UsuarioDto> usuarioList) {
        this.usuarioList = usuarioList;
    }

}
