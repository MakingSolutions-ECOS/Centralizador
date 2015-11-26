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
 * @author Angela Suarez
 */
@Entity
@Table(name = "TIPO_ENTIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEntidad.findAll", query = "SELECT t FROM TipoEntidad t"),
    @NamedQuery(name = "TipoEntidad.findByCodigoTipoEntidad", query = "SELECT t FROM TipoEntidad t WHERE t.codigoTipoEntidad = :codigoTipoEntidad"),
    @NamedQuery(name = "TipoEntidad.findByNombreTipoEntidad", query = "SELECT t FROM TipoEntidad t WHERE t.nombreTipoEntidad = :nombreTipoEntidad")})
public class TipoEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TIPO_ENTIDAD")
    private Integer codigoTipoEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_TIPO_ENTIDAD")
    private String nombreTipoEntidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoEntidad")
    private List<Emisor> emisorList;

    public TipoEntidad() {
    }

    public TipoEntidad(Integer codigoTipoEntidad) {
        this.codigoTipoEntidad = codigoTipoEntidad;
    }

    public TipoEntidad(Integer codigoTipoEntidad, String nombreTipoEntidad) {
        this.codigoTipoEntidad = codigoTipoEntidad;
        this.nombreTipoEntidad = nombreTipoEntidad;
    }

    public Integer getCodigoTipoEntidad() {
        return codigoTipoEntidad;
    }

    public void setCodigoTipoEntidad(Integer codigoTipoEntidad) {
        this.codigoTipoEntidad = codigoTipoEntidad;
    }

    public String getNombreTipoEntidad() {
        return nombreTipoEntidad;
    }

    public void setNombreTipoEntidad(String nombreTipoEntidad) {
        this.nombreTipoEntidad = nombreTipoEntidad;
    }

    @XmlTransient
    public List<Emisor> getEmisorList() {
        return emisorList;
    }

    public void setEmisorList(List<Emisor> emisorList) {
        this.emisorList = emisorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoEntidad != null ? codigoTipoEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEntidad)) {
            return false;
        }
        TipoEntidad other = (TipoEntidad) object;
        if ((this.codigoTipoEntidad == null && other.codigoTipoEntidad != null) || (this.codigoTipoEntidad != null && !this.codigoTipoEntidad.equals(other.codigoTipoEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.TipoEntidad[ codigoTipoEntidad=" + codigoTipoEntidad + " ]";
    }
    
}
