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
public class SuscripcionDto {

    private Integer codigoSubscripcion;
    private String detalleSubscripcion;
    private Date fecha;
    private OperadorDto codigoOperador;
    private boolean vigente;

    public Integer getCodigoSubscripcion() {
        return codigoSubscripcion;
    }

    public void setCodigoSubscripcion(Integer codigoSubscripcion) {
        this.codigoSubscripcion = codigoSubscripcion;
    }

    public String getDetalleSubscripcion() {
        return detalleSubscripcion;
    }

    public void setDetalleSubscripcion(String detalleSubscripcion) {
        this.detalleSubscripcion = detalleSubscripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public OperadorDto getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(OperadorDto codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public boolean getVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

}
