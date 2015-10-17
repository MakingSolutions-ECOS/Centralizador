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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "GRUPO_CIUDADANO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoCiudadano.findAll", query = "SELECT g FROM GrupoCiudadano g"),
    @NamedQuery(name = "GrupoCiudadano.findByCodigoGrupoCiudadano", query = "SELECT g FROM GrupoCiudadano g WHERE g.codigoGrupoCiudadano = :codigoGrupoCiudadano")})
public class GrupoCiudadano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_GRUPO_CIUDADANO")
    private Integer codigoGrupoCiudadano;
    @JoinColumn(name = "CODIGO_GRUPO", referencedColumnName = "CODIGO_GRUPO")
    @ManyToOne
    private Grupo codigoGrupo;
    @JoinColumn(name = "CODIGO_CIUDADANO", referencedColumnName = "CODIGO_CIUDADANO")
    @ManyToOne
    private Ciudadano codigoCiudadano;

    public GrupoCiudadano() {
    }

    public GrupoCiudadano(Integer codigoGrupoCiudadano) {
        this.codigoGrupoCiudadano = codigoGrupoCiudadano;
    }

    public Integer getCodigoGrupoCiudadano() {
        return codigoGrupoCiudadano;
    }

    public void setCodigoGrupoCiudadano(Integer codigoGrupoCiudadano) {
        this.codigoGrupoCiudadano = codigoGrupoCiudadano;
    }

    public Grupo getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(Grupo codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public Ciudadano getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(Ciudadano codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoGrupoCiudadano != null ? codigoGrupoCiudadano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoCiudadano)) {
            return false;
        }
        GrupoCiudadano other = (GrupoCiudadano) object;
        if ((this.codigoGrupoCiudadano == null && other.codigoGrupoCiudadano != null) || (this.codigoGrupoCiudadano != null && !this.codigoGrupoCiudadano.equals(other.codigoGrupoCiudadano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.GrupoCiudadano[ codigoGrupoCiudadano=" + codigoGrupoCiudadano + " ]";
    }
    
}
