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
public class PermisoDto {

    private Integer codigoPermiso;
    private String nombrePermiso;
    private String zonaPermiso;
    private List<RolPermisoDto> rolPermisoList;

    public Integer getCodigoPermiso() {
        return codigoPermiso;
    }

    public void setCodigoPermiso(Integer codigoPermiso) {
        this.codigoPermiso = codigoPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getZonaPermiso() {
        return zonaPermiso;
    }

    public void setZonaPermiso(String zonaPermiso) {
        this.zonaPermiso = zonaPermiso;
    }

    public List<RolPermisoDto> getRolPermisoList() {
        return rolPermisoList;
    }

    public void setRolPermisoList(List<RolPermisoDto> rolPermisoList) {
        this.rolPermisoList = rolPermisoList;
    }

}
