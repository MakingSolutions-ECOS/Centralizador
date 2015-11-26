/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

/**
 *
 * @author Sergio Forero
 */
public class RolPermisoDto {

    private Integer codigoRolPermiso;
    private PermisoDto codigoPermiso;
    private RolDto codigoRol;

    public Integer getCodigoRolPermiso() {
        return codigoRolPermiso;
    }

    public void setCodigoRolPermiso(Integer codigoRolPermiso) {
        this.codigoRolPermiso = codigoRolPermiso;
    }

    public PermisoDto getCodigoPermiso() {
        return codigoPermiso;
    }

    public void setCodigoPermiso(PermisoDto codigoPermiso) {
        this.codigoPermiso = codigoPermiso;
    }

    public RolDto getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(RolDto codigoRol) {
        this.codigoRol = codigoRol;
    }

}
