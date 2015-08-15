/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Johans Gonzalez
 */
@Entity
@Table(name = "TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t"),
    @NamedQuery(name = "Tramite.findByCodigoTramite", query = "SELECT t FROM Tramite t WHERE t.codigoTramite = :codigoTramite")})
public class Tramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TRAMITE")
    private Integer codigoTramite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTramite")
    private List<TramiteActividad> tramiteActividadList;
    @JoinColumn(name = "CODIGO_TRAMITE_ESTADO", referencedColumnName = "CODIGO_TRAMITE_ESTADO")
    @ManyToOne(optional = false)
    private TramiteEstado codigoTramiteEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTramite")
    private List<TramiteDefinicion> tramiteDefinicionList;

    public Tramite() {
    }

    public Tramite(Integer codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    public Integer getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(Integer codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    @XmlTransient
    public List<TramiteActividad> getTramiteActividadList() {
        return tramiteActividadList;
    }

    public void setTramiteActividadList(List<TramiteActividad> tramiteActividadList) {
        this.tramiteActividadList = tramiteActividadList;
    }

    public TramiteEstado getCodigoTramiteEstado() {
        return codigoTramiteEstado;
    }

    public void setCodigoTramiteEstado(TramiteEstado codigoTramiteEstado) {
        this.codigoTramiteEstado = codigoTramiteEstado;
    }

    @XmlTransient
    public List<TramiteDefinicion> getTramiteDefinicionList() {
        return tramiteDefinicionList;
    }

    public void setTramiteDefinicionList(List<TramiteDefinicion> tramiteDefinicionList) {
        this.tramiteDefinicionList = tramiteDefinicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTramite != null ? codigoTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.codigoTramite == null && other.codigoTramite != null) || (this.codigoTramite != null && !this.codigoTramite.equals(other.codigoTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Tramite[ codigoTramite=" + codigoTramite + " ]";
    }
    
}
