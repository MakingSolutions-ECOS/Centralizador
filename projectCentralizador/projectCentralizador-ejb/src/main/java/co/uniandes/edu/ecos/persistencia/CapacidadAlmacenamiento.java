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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "CAPACIDAD_ALMACENAMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacidadAlmacenamiento.findAll", query = "SELECT c FROM CapacidadAlmacenamiento c"),
    @NamedQuery(name = "CapacidadAlmacenamiento.findByCodigoCapacidadAlmacenamiento", query = "SELECT c FROM CapacidadAlmacenamiento c WHERE c.codigoCapacidadAlmacenamiento = :codigoCapacidadAlmacenamiento"),
    @NamedQuery(name = "CapacidadAlmacenamiento.findByCodigoCiudadano", query = "SELECT c FROM CapacidadAlmacenamiento c WHERE c.codigoCiudadano = :codigoCiudadano"),
    @NamedQuery(name = "CapacidadAlmacenamiento.findByCapacidadGibabytes", query = "SELECT c FROM CapacidadAlmacenamiento c WHERE c.capacidadGibabytes = :capacidadGibabytes")})
public class CapacidadAlmacenamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CAPACIDAD_ALMACENAMIENTO")
    private Integer codigoCapacidadAlmacenamiento;
    @Column(name = "CODIGO_CIUDADANO")
    private Integer codigoCiudadano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDAD_GIBABYTES")
    private int capacidadGibabytes;
    @OneToMany(mappedBy = "codigoCapacidadAlmacenamiento")
    private List<Ciudadano> ciudadanoList;

    public CapacidadAlmacenamiento() {
    }

    public CapacidadAlmacenamiento(Integer codigoCapacidadAlmacenamiento) {
        this.codigoCapacidadAlmacenamiento = codigoCapacidadAlmacenamiento;
    }

    public CapacidadAlmacenamiento(Integer codigoCapacidadAlmacenamiento, int capacidadGibabytes) {
        this.codigoCapacidadAlmacenamiento = codigoCapacidadAlmacenamiento;
        this.capacidadGibabytes = capacidadGibabytes;
    }

    public Integer getCodigoCapacidadAlmacenamiento() {
        return codigoCapacidadAlmacenamiento;
    }

    public void setCodigoCapacidadAlmacenamiento(Integer codigoCapacidadAlmacenamiento) {
        this.codigoCapacidadAlmacenamiento = codigoCapacidadAlmacenamiento;
    }

    public Integer getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(Integer codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public int getCapacidadGibabytes() {
        return capacidadGibabytes;
    }

    public void setCapacidadGibabytes(int capacidadGibabytes) {
        this.capacidadGibabytes = capacidadGibabytes;
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
        hash += (codigoCapacidadAlmacenamiento != null ? codigoCapacidadAlmacenamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacidadAlmacenamiento)) {
            return false;
        }
        CapacidadAlmacenamiento other = (CapacidadAlmacenamiento) object;
        if ((this.codigoCapacidadAlmacenamiento == null && other.codigoCapacidadAlmacenamiento != null) || (this.codigoCapacidadAlmacenamiento != null && !this.codigoCapacidadAlmacenamiento.equals(other.codigoCapacidadAlmacenamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.CapacidadAlmacenamiento[ codigoCapacidadAlmacenamiento=" + codigoCapacidadAlmacenamiento + " ]";
    }
    
}
