/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TIPO_CIUDADANO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCiudadano.findAll", query = "SELECT t FROM TipoCiudadano t"),
    @NamedQuery(name = "TipoCiudadano.findByNombreTipoCiudadano", query = "SELECT t FROM TipoCiudadano t WHERE t.nombreTipoCiudadano = :nombreTipoCiudadano"),
    @NamedQuery(name = "TipoCiudadano.findByCodigoTipoCiudadano", query = "SELECT t FROM TipoCiudadano t WHERE t.codigoTipoCiudadano = :codigoTipoCiudadano")})
public class TipoCiudadano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE_TIPO_CIUDADANO")
    private String nombreTipoCiudadano;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TIPO_CIUDADANO")
    private Integer codigoTipoCiudadano;
    @OneToMany(mappedBy = "codigoTipoCiudadano")
    private List<Ciudadano> ciudadanoList;

    public TipoCiudadano() {
    }

    public TipoCiudadano(Integer codigoTipoCiudadano) {
        this.codigoTipoCiudadano = codigoTipoCiudadano;
    }

    public TipoCiudadano(Integer codigoTipoCiudadano, String nombreTipoCiudadano) {
        this.codigoTipoCiudadano = codigoTipoCiudadano;
        this.nombreTipoCiudadano = nombreTipoCiudadano;
    }

    public String getNombreTipoCiudadano() {
        return nombreTipoCiudadano;
    }

    public void setNombreTipoCiudadano(String nombreTipoCiudadano) {
        this.nombreTipoCiudadano = nombreTipoCiudadano;
    }

    public Integer getCodigoTipoCiudadano() {
        return codigoTipoCiudadano;
    }

    public void setCodigoTipoCiudadano(Integer codigoTipoCiudadano) {
        this.codigoTipoCiudadano = codigoTipoCiudadano;
    }

    @XmlTransient
    public List<Ciudadano> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<Ciudadano> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoCiudadano != null ? codigoTipoCiudadano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCiudadano)) {
            return false;
        }
        TipoCiudadano other = (TipoCiudadano) object;
        if ((this.codigoTipoCiudadano == null && other.codigoTipoCiudadano != null) || (this.codigoTipoCiudadano != null && !this.codigoTipoCiudadano.equals(other.codigoTipoCiudadano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.TipoCiudadano[ codigoTipoCiudadano=" + codigoTipoCiudadano + " ]";
    }
    
}
