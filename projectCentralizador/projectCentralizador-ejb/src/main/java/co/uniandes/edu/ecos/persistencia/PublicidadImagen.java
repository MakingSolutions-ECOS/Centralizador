/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
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
 * @author Jimmy
 */
@Entity
@Table(name = "PUBLICIDAD_IMAGEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublicidadImagen.findAll", query = "SELECT p FROM PublicidadImagen p"),
    @NamedQuery(name = "PublicidadImagen.findByCodigoPublicidadImagen", query = "SELECT p FROM PublicidadImagen p WHERE p.codigoPublicidadImagen = :codigoPublicidadImagen"),
    @NamedQuery(name = "PublicidadImagen.findByRutaFisicaImagen", query = "SELECT p FROM PublicidadImagen p WHERE p.rutaFisicaImagen = :rutaFisicaImagen")})
public class PublicidadImagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PUBLICIDAD_IMAGEN")
    private Integer codigoPublicidadImagen;
    @Size(max = 100)
    @Column(name = "RUTA_FISICA_IMAGEN")
    private String rutaFisicaImagen;
    @JoinColumn(name = "CODIGO_PUBLICIDAD", referencedColumnName = "CODIGO_PUBLICIDAD")
    @ManyToOne
    private Publicidad codigoPublicidad;

    public PublicidadImagen() {
    }

    public PublicidadImagen(Integer codigoPublicidadImagen) {
        this.codigoPublicidadImagen = codigoPublicidadImagen;
    }

    public Integer getCodigoPublicidadImagen() {
        return codigoPublicidadImagen;
    }

    public void setCodigoPublicidadImagen(Integer codigoPublicidadImagen) {
        this.codigoPublicidadImagen = codigoPublicidadImagen;
    }

    public String getRutaFisicaImagen() {
        return rutaFisicaImagen;
    }

    public void setRutaFisicaImagen(String rutaFisicaImagen) {
        this.rutaFisicaImagen = rutaFisicaImagen;
    }

    public Publicidad getCodigoPublicidad() {
        return codigoPublicidad;
    }

    public void setCodigoPublicidad(Publicidad codigoPublicidad) {
        this.codigoPublicidad = codigoPublicidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPublicidadImagen != null ? codigoPublicidadImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicidadImagen)) {
            return false;
        }
        PublicidadImagen other = (PublicidadImagen) object;
        if ((this.codigoPublicidadImagen == null && other.codigoPublicidadImagen != null) || (this.codigoPublicidadImagen != null && !this.codigoPublicidadImagen.equals(other.codigoPublicidadImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.PublicidadImagen[ codigoPublicidadImagen=" + codigoPublicidadImagen + " ]";
    }
    
}
