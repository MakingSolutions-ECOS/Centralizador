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
 * @author Angela Suarez
 */
@Entity
@Table(name = "TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t"),
    @NamedQuery(name = "Tramite.findByCodigoTramite", query = "SELECT t FROM Tramite t WHERE t.codigoTramite = :codigoTramite"),
    @NamedQuery(name = "Tramite.findByCodigoCiudadano", query = "SELECT t FROM Tramite t WHERE t.codigoCiudadano.codigoCiudadano = :codigoCiudadano"),
    @NamedQuery(name = "Tramite.findByCodigoTramiteEstado", query = "SELECT t FROM Tramite t WHERE t.codigoTramiteEstado = :codigoTramiteEstado"),   
    @NamedQuery(name = "Tramite.findByCodigoEstado", query = "SELECT t FROM Tramite t WHERE  t.codigoTramiteDefinicion.codigoEntidadEmisora.codigoEntidadEmisora = :codigoEntidadEmisora"),    
    @NamedQuery(name = "Tramite.findByEstadoPendienteTramite", query = "SELECT t FROM Tramite t WHERE t.codigoTramiteDefinicion.codigoEntidadEmisora.codigoEntidadEmisora = :codigoEntidadEmisora and t.codigoTramiteEstado.codigoTramiteEstado = :codigoTramiteEstado"),
    @NamedQuery(name = "Tramite.findByCodigoTramiteOperador", query = "SELECT t FROM Tramite t WHERE t.codigoTramiteOperador = :codigoTramiteOperador")})
public class Tramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TRAMITE")
    private Integer codigoTramite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TRAMITE_OPERADOR")
    private int codigoTramiteOperador;
    @JoinColumn(name = "CODIGO_TRAMITE_ESTADO", referencedColumnName = "CODIGO_TRAMITE_ESTADO")
    @ManyToOne(optional = false)
    private TramiteEstado codigoTramiteEstado;
    @JoinColumn(name = "CODIGO_TRAMITE_DEFINICION", referencedColumnName = "CODIGO_TRAMITE_DEFINICION")
    @ManyToOne(optional = false)
    private TramiteDefinicion codigoTramiteDefinicion;
    @JoinColumn(name = "CODIGO_CIUDADANO", referencedColumnName = "CODIGO_CIUDADANO")
    @ManyToOne(optional = false)
    private Ciudadano codigoCiudadano;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTramite")
    private List<LinkDescargaTramite> linkDescargaTramiteList;

    public Tramite() {
    }

    public Tramite(Integer codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    public Tramite(Integer codigoTramite, int codigoTramiteOperador) {
        this.codigoTramite = codigoTramite;
        this.codigoTramiteOperador = codigoTramiteOperador;
    }

    public Integer getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(Integer codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    public int getCodigoTramiteOperador() {
        return codigoTramiteOperador;
    }

    public void setCodigoTramiteOperador(int codigoTramiteOperador) {
        this.codigoTramiteOperador = codigoTramiteOperador;
    }

    public TramiteEstado getCodigoTramiteEstado() {
        return codigoTramiteEstado;
    }

    public void setCodigoTramiteEstado(TramiteEstado codigoTramiteEstado) {
        this.codigoTramiteEstado = codigoTramiteEstado;
    }

    public TramiteDefinicion getCodigoTramiteDefinicion() {
        return codigoTramiteDefinicion;
    }

    public void setCodigoTramiteDefinicion(TramiteDefinicion codigoTramiteDefinicion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
    }

    public Ciudadano getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(Ciudadano codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
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
    
    @XmlTransient
    public List<LinkDescargaTramite> getLinkDescargaTramiteList() {
        return linkDescargaTramiteList;
    }

    public void setLinkDescargaTramiteList(List<LinkDescargaTramite> linkDescargaTramiteList) {
        this.linkDescargaTramiteList = linkDescargaTramiteList;
    }
    
}
