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
 * 
 */
@Entity
@Table(name = "CATEGORIAS_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriasTramite.findAll", query = "SELECT c FROM CategoriasTramite c"),
    @NamedQuery(name = "CategoriasTramite.findByCodigoCategoria", query = "SELECT c FROM CategoriasTramite c WHERE c.codigoCategoria = :codigoCategoria"),
    @NamedQuery(name = "CategoriasTramite.findByNombreCategoria", query = "SELECT c FROM CategoriasTramite c WHERE c.nombreCategoria = :nombreCategoria")})
public class CategoriasTramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CATEGORIA")
    private Integer codigoCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_CATEGORIA")
    private String nombreCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCategoria")
    private List<TramiteDefinicion> tramiteDefinicionList;

    public CategoriasTramite() {
    }

    public CategoriasTramite(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public CategoriasTramite(Integer codigoCategoria, String nombreCategoria) {
        this.codigoCategoria = codigoCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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
        hash += (codigoCategoria != null ? codigoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriasTramite)) {
            return false;
        }
        CategoriasTramite other = (CategoriasTramite) object;
        if ((this.codigoCategoria == null && other.codigoCategoria != null) || (this.codigoCategoria != null && !this.codigoCategoria.equals(other.codigoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.CategoriasTramite[ codigoCategoria=" + codigoCategoria + " ]";
    }
    
}
