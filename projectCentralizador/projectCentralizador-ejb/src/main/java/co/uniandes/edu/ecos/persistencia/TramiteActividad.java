/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johans Gonzalez
 */
@Entity
@Table(name = "TRAMITE_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TramiteActividad.findAll", query = "SELECT t FROM TramiteActividad t"),
    @NamedQuery(name = "TramiteActividad.findByCodigoTramiteActividad", query = "SELECT t FROM TramiteActividad t WHERE t.codigoTramiteActividad = :codigoTramiteActividad"),
    @NamedQuery(name = "TramiteActividad.findByFechaTramiteActividad", query = "SELECT t FROM TramiteActividad t WHERE t.fechaTramiteActividad = :fechaTramiteActividad"),
    @NamedQuery(name = "TramiteActividad.findByDescripcionTramiteActividad", query = "SELECT t FROM TramiteActividad t WHERE t.descripcionTramiteActividad = :descripcionTramiteActividad")})
public class TramiteActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TRAMITE_ACTIVIDAD")
    private Integer codigoTramiteActividad;
    @Column(name = "FECHA_TRAMITE_ACTIVIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTramiteActividad;
    @Size(max = 1024)
    @Column(name = "DESCRIPCION_TRAMITE_ACTIVIDAD")
    private String descripcionTramiteActividad;
    @JoinColumn(name = "CODIGO_TRAMITE", referencedColumnName = "CODIGO_TRAMITE")
    @ManyToOne(optional = false)
    private Tramite codigoTramite;

    public TramiteActividad() {
    }

    public TramiteActividad(Integer codigoTramiteActividad) {
        this.codigoTramiteActividad = codigoTramiteActividad;
    }

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

    public Tramite getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(Tramite codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTramiteActividad != null ? codigoTramiteActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TramiteActividad)) {
            return false;
        }
        TramiteActividad other = (TramiteActividad) object;
        if ((this.codigoTramiteActividad == null && other.codigoTramiteActividad != null) || (this.codigoTramiteActividad != null && !this.codigoTramiteActividad.equals(other.codigoTramiteActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.TramiteActividad[ codigoTramiteActividad=" + codigoTramiteActividad + " ]";
    }
    
}
