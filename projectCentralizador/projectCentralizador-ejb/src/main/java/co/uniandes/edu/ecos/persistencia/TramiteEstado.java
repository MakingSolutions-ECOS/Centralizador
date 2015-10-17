/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "TRAMITE_ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TramiteEstado.findAll", query = "SELECT t FROM TramiteEstado t"),
    @NamedQuery(name = "TramiteEstado.findByCodigoTramiteEstado", query = "SELECT t FROM TramiteEstado t WHERE t.codigoTramiteEstado = :codigoTramiteEstado"),
    @NamedQuery(name = "TramiteEstado.findByNombreTramiteEstado", query = "SELECT t FROM TramiteEstado t WHERE t.nombreTramiteEstado = :nombreTramiteEstado")})
public class TramiteEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TRAMITE_ESTADO")
    private Integer codigoTramiteEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_TRAMITE_ESTADO")
    private String nombreTramiteEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTramiteEstado")
    private List<Tramite> tramiteList;

    public TramiteEstado() {
    }

    public TramiteEstado(Integer codigoTramiteEstado) {
        this.codigoTramiteEstado = codigoTramiteEstado;
    }

    public TramiteEstado(Integer codigoTramiteEstado, String nombreTramiteEstado) {
        this.codigoTramiteEstado = codigoTramiteEstado;
        this.nombreTramiteEstado = nombreTramiteEstado;
    }

    public Integer getCodigoTramiteEstado() {
        return codigoTramiteEstado;
    }

    public void setCodigoTramiteEstado(Integer codigoTramiteEstado) {
        this.codigoTramiteEstado = codigoTramiteEstado;
    }

    public String getNombreTramiteEstado() {
        return nombreTramiteEstado;
    }

    public void setNombreTramiteEstado(String nombreTramiteEstado) {
        this.nombreTramiteEstado = nombreTramiteEstado;
    }

    @XmlTransient
    public List<Tramite> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTramiteEstado != null ? codigoTramiteEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TramiteEstado)) {
            return false;
        }
        TramiteEstado other = (TramiteEstado) object;
        if ((this.codigoTramiteEstado == null && other.codigoTramiteEstado != null) || (this.codigoTramiteEstado != null && !this.codigoTramiteEstado.equals(other.codigoTramiteEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.TramiteEstado[ codigoTramiteEstado=" + codigoTramiteEstado + " ]";
    }
    
}
