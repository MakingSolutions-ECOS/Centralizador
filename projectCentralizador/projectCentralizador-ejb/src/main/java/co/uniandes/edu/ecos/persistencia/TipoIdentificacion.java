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
@Table(name = "TIPO_IDENTIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT t FROM TipoIdentificacion t"),
    @NamedQuery(name = "TipoIdentificacion.findByCodigoTipoIdentificacion", query = "SELECT t FROM TipoIdentificacion t WHERE t.codigoTipoIdentificacion = :codigoTipoIdentificacion"),
    @NamedQuery(name = "TipoIdentificacion.findByNombreTipoIdentificacion", query = "SELECT t FROM TipoIdentificacion t WHERE t.nombreTipoIdentificacion = :nombreTipoIdentificacion")})
public class TipoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TIPO_IDENTIFICACION")
    private Integer codigoTipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_TIPO_IDENTIFICACION")
    private String nombreTipoIdentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoIdentificacion")
    private List<Ciudadano> ciudadanoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoIdentificacion")
    private List<Usuario> usuarioList;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Integer codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public TipoIdentificacion(Integer codigoTipoIdentificacion, String nombreTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }

    public Integer getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(Integer codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public String getNombreTipoIdentificacion() {
        return nombreTipoIdentificacion;
    }

    public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }

    @XmlTransient
    public List<Ciudadano> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<Ciudadano> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoIdentificacion != null ? codigoTipoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.codigoTipoIdentificacion == null && other.codigoTipoIdentificacion != null) || (this.codigoTipoIdentificacion != null && !this.codigoTipoIdentificacion.equals(other.codigoTipoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.TipoIdentificacion[ codigoTipoIdentificacion=" + codigoTipoIdentificacion + " ]";
    }
    
}
