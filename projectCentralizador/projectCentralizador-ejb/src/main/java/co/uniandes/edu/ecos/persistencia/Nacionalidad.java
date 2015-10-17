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
@Table(name = "NACIONALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n"),
    @NamedQuery(name = "Nacionalidad.findByCodigoNacionalidad", query = "SELECT n FROM Nacionalidad n WHERE n.codigoNacionalidad = :codigoNacionalidad"),
    @NamedQuery(name = "Nacionalidad.findByNombreNacionaliad", query = "SELECT n FROM Nacionalidad n WHERE n.nombreNacionaliad = :nombreNacionaliad")})
public class Nacionalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_NACIONALIDAD")
    private Integer codigoNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE_NACIONALIAD")
    private String nombreNacionaliad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNacionalidad")
    private List<Ciudadano> ciudadanoList;

    public Nacionalidad() {
    }

    public Nacionalidad(Integer codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public Nacionalidad(Integer codigoNacionalidad, String nombreNacionaliad) {
        this.codigoNacionalidad = codigoNacionalidad;
        this.nombreNacionaliad = nombreNacionaliad;
    }

    public Integer getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(Integer codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public String getNombreNacionaliad() {
        return nombreNacionaliad;
    }

    public void setNombreNacionaliad(String nombreNacionaliad) {
        this.nombreNacionaliad = nombreNacionaliad;
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
        hash += (codigoNacionalidad != null ? codigoNacionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.codigoNacionalidad == null && other.codigoNacionalidad != null) || (this.codigoNacionalidad != null && !this.codigoNacionalidad.equals(other.codigoNacionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Nacionalidad[ codigoNacionalidad=" + codigoNacionalidad + " ]";
    }
    
}
