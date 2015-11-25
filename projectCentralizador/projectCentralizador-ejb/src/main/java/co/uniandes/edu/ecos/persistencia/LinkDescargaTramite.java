/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Your Name
 */
@Entity
@Table(name = "LINK_DESCARGA_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinkDescargaTramite.findAll", query = "SELECT l FROM LinkDescargaTramite l"),
    @NamedQuery(name = "LinkDescargaTramite.findByCodigoLinkDescarga", query = "SELECT l FROM LinkDescargaTramite l WHERE l.codigoLinkDescarga = :codigoLinkDescarga"),
    @NamedQuery(name = "LinkDescargaTramite.findByLinkDescarga", query = "SELECT l FROM LinkDescargaTramite l WHERE l.linkDescarga = :linkDescarga")})
public class LinkDescargaTramite implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_LINK_DESCARGA")
    private BigDecimal codigoLinkDescarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LINK_DESCARGA")
    private String linkDescarga;
    @JoinColumn(name = "CODIGO_TRAMITE", referencedColumnName = "CODIGO_TRAMITE")
    @ManyToOne(optional = false)
    private Tramite codigoTramite;

    public LinkDescargaTramite() {
    }

    public LinkDescargaTramite(BigDecimal codigoLinkDescarga) {
        this.codigoLinkDescarga = codigoLinkDescarga;
    }

    public LinkDescargaTramite(BigDecimal codigoLinkDescarga, String linkDescarga) {
        this.codigoLinkDescarga = codigoLinkDescarga;
        this.linkDescarga = linkDescarga;
    }

    public BigDecimal getCodigoLinkDescarga() {
        return codigoLinkDescarga;
    }

    public void setCodigoLinkDescarga(BigDecimal codigoLinkDescarga) {
        this.codigoLinkDescarga = codigoLinkDescarga;
    }

    public String getLinkDescarga() {
        return linkDescarga;
    }

    public void setLinkDescarga(String linkDescarga) {
        this.linkDescarga = linkDescarga;
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
        hash += (codigoLinkDescarga != null ? codigoLinkDescarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinkDescargaTramite)) {
            return false;
        }
        LinkDescargaTramite other = (LinkDescargaTramite) object;
        if ((this.codigoLinkDescarga == null && other.codigoLinkDescarga != null) || (this.codigoLinkDescarga != null && !this.codigoLinkDescarga.equals(other.codigoLinkDescarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.making.cp.entity.LinkDescargaTramite[ codigoLinkDescarga=" + codigoLinkDescarga + " ]";
    }
    
}
