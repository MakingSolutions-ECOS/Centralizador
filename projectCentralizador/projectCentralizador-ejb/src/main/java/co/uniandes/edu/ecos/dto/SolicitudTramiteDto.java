/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.dto;

/**
 *
 * @author Your Name
 */
public class SolicitudTramiteDto {
    private CiudadanoDto ciudadano;
    private TramiteDto tramiteDto;
    private String urlGetArchivoRepo;

    public CiudadanoDto getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoDto ciudadano) {
        this.ciudadano = ciudadano;
    }

    public TramiteDto getTramiteDto() {
        return tramiteDto;
    }

    public void setTramiteDto(TramiteDto tramiteDto) {
        this.tramiteDto = tramiteDto;
    }

    public String getUrlGetArchivoRepo() {
        return urlGetArchivoRepo;
    }

    public void setUrlGetArchivoRepo(String urlGetArchivoRepo) {
        this.urlGetArchivoRepo = urlGetArchivoRepo;
    }
    
    
    
}
