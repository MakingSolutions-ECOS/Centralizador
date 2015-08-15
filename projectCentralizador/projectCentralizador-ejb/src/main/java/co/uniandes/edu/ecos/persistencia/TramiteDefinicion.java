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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Johans Gonzalez
 */
@Entity
@Table(name = "TRAMITE_DEFINICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TramiteDefinicion.findAll", query = "SELECT t FROM TramiteDefinicion t"),
    @NamedQuery(name = "TramiteDefinicion.findByCodigoTramiteDefinicion", query = "SELECT t FROM TramiteDefinicion t WHERE t.codigoTramiteDefinicion = :codigoTramiteDefinicion"),
    @NamedQuery(name = "TramiteDefinicion.findByCodigoCategoria", query = "SELECT t FROM TramiteDefinicion t WHERE t.codigoCategoria = :codigoCategoria"),
    @NamedQuery(name = "TramiteDefinicion.findByDefinicion", query = "SELECT t FROM TramiteDefinicion t WHERE t.definicion = :definicion"),
    @NamedQuery(name = "TramiteDefinicion.findByHabilitado", query = "SELECT t FROM TramiteDefinicion t WHERE t.habilitado = :habilitado"),
    @NamedQuery(name = "TramiteDefinicion.findByDescripcion", query = "SELECT t FROM TramiteDefinicion t WHERE t.descripcion = :descripcion")})
public class TramiteDefinicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TRAMITE_DEFINICION")
    private Integer codigoTramiteDefinicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CATEGORIA")
    private int codigoCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DEFINICION")
    private String definicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADO")
    private boolean habilitado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTramiteDefinicion")
    private List<DocumentoRequeridoTramite> documentoRequeridoTramiteList;
    @JoinColumn(name = "CODIGO_TRAMITE", referencedColumnName = "CODIGO_TRAMITE")
    @ManyToOne(optional = false)
    private Tramite codigoTramite;
    @JoinColumn(name = "CODIGO_ENTIDAD_EMISORA", referencedColumnName = "CODIGO_ENTIDAD_EMISORA")
    @ManyToOne(optional = false)
    private Emisor codigoEntidadEmisora;
    @JoinColumn(name = "CODIGO_TRAMITE", referencedColumnName = "CODIGO_CATEGORIA")
    @ManyToOne(optional = false)
    private CategoriasTramite codigoTramite1;

    public TramiteDefinicion() {
    }

    public TramiteDefinicion(Integer codigoTramiteDefinicion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
    }

    public TramiteDefinicion(Integer codigoTramiteDefinicion, int codigoCategoria, String definicion, boolean habilitado, String descripcion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
        this.codigoCategoria = codigoCategoria;
        this.definicion = definicion;
        this.habilitado = habilitado;
        this.descripcion = descripcion;
    }

    public Integer getCodigoTramiteDefinicion() {
        return codigoTramiteDefinicion;
    }

    public void setCodigoTramiteDefinicion(Integer codigoTramiteDefinicion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DocumentoRequeridoTramite> getDocumentoRequeridoTramiteList() {
        return documentoRequeridoTramiteList;
    }

    public void setDocumentoRequeridoTramiteList(List<DocumentoRequeridoTramite> documentoRequeridoTramiteList) {
        this.documentoRequeridoTramiteList = documentoRequeridoTramiteList;
    }

    public Tramite getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(Tramite codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    public Emisor getCodigoEntidadEmisora() {
        return codigoEntidadEmisora;
    }

    public void setCodigoEntidadEmisora(Emisor codigoEntidadEmisora) {
        this.codigoEntidadEmisora = codigoEntidadEmisora;
    }

    public CategoriasTramite getCodigoTramite1() {
        return codigoTramite1;
    }

    public void setCodigoTramite1(CategoriasTramite codigoTramite1) {
        this.codigoTramite1 = codigoTramite1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTramiteDefinicion != null ? codigoTramiteDefinicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TramiteDefinicion)) {
            return false;
        }
        TramiteDefinicion other = (TramiteDefinicion) object;
        if ((this.codigoTramiteDefinicion == null && other.codigoTramiteDefinicion != null) || (this.codigoTramiteDefinicion != null && !this.codigoTramiteDefinicion.equals(other.codigoTramiteDefinicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.TramiteDefinicion[ codigoTramiteDefinicion=" + codigoTramiteDefinicion + " ]";
    }
    
}
