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
 * @author John Dany
 */
@Entity
@Table(name = "TIPO_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPersona.findAll", query = "SELECT t FROM TipoPersona t"),
    @NamedQuery(name = "TipoPersona.findByCodigoTipoPersona", query = "SELECT t FROM TipoPersona t WHERE t.codigoTipoPersona = :codigoTipoPersona"),
    @NamedQuery(name = "TipoPersona.findByNombreTipoPersona", query = "SELECT t FROM TipoPersona t WHERE t.nombreTipoPersona = :nombreTipoPersona")})
public class TipoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TIPO_PERSONA")
    private Integer codigoTipoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE_TIPO_PERSONA")
    private String nombreTipoPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoPersona")
    private List<Ciudadano> ciudadanoList;

    public TipoPersona() {
    }

    public TipoPersona(Integer codigoTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona;
    }

    public TipoPersona(Integer codigoTipoPersona, String nombreTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona;
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public Integer getCodigoTipoPersona() {
        return codigoTipoPersona;
    }

    public void setCodigoTipoPersona(Integer codigoTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
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
        hash += (codigoTipoPersona != null ? codigoTipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.codigoTipoPersona == null && other.codigoTipoPersona != null) || (this.codigoTipoPersona != null && !this.codigoTipoPersona.equals(other.codigoTipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.TipoPersona[ codigoTipoPersona=" + codigoTipoPersona + " ]";
    }
    
}
