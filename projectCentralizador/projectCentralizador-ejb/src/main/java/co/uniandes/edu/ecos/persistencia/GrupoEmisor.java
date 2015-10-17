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
@Table(name = "GRUPO_EMISOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoEmisor.findAll", query = "SELECT g FROM GrupoEmisor g"),
    @NamedQuery(name = "GrupoEmisor.findByCodigoGrupoEmisor", query = "SELECT g FROM GrupoEmisor g WHERE g.codigoGrupoEmisor = :codigoGrupoEmisor"),
    @NamedQuery(name = "GrupoEmisor.findByNombreGrupoEmisor", query = "SELECT g FROM GrupoEmisor g WHERE g.nombreGrupoEmisor = :nombreGrupoEmisor")})
public class GrupoEmisor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_GRUPO_EMISOR")
    private Integer codigoGrupoEmisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_GRUPO_EMISOR")
    private String nombreGrupoEmisor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoGrupoEmisor")
    private List<Emisor> emisorList;

    public GrupoEmisor() {
    }

    public GrupoEmisor(Integer codigoGrupoEmisor) {
        this.codigoGrupoEmisor = codigoGrupoEmisor;
    }

    public GrupoEmisor(Integer codigoGrupoEmisor, String nombreGrupoEmisor) {
        this.codigoGrupoEmisor = codigoGrupoEmisor;
        this.nombreGrupoEmisor = nombreGrupoEmisor;
    }

    public Integer getCodigoGrupoEmisor() {
        return codigoGrupoEmisor;
    }

    public void setCodigoGrupoEmisor(Integer codigoGrupoEmisor) {
        this.codigoGrupoEmisor = codigoGrupoEmisor;
    }

    public String getNombreGrupoEmisor() {
        return nombreGrupoEmisor;
    }

    public void setNombreGrupoEmisor(String nombreGrupoEmisor) {
        this.nombreGrupoEmisor = nombreGrupoEmisor;
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
        hash += (codigoGrupoEmisor != null ? codigoGrupoEmisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoEmisor)) {
            return false;
        }
        GrupoEmisor other = (GrupoEmisor) object;
        if ((this.codigoGrupoEmisor == null && other.codigoGrupoEmisor != null) || (this.codigoGrupoEmisor != null && !this.codigoGrupoEmisor.equals(other.codigoGrupoEmisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.GrupoEmisor[ codigoGrupoEmisor=" + codigoGrupoEmisor + " ]";
    }
    
}
