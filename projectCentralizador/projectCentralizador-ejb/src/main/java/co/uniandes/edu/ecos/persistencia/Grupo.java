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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByCodigoGrupo", query = "SELECT g FROM Grupo g WHERE g.codigoGrupo = :codigoGrupo"),
    @NamedQuery(name = "Grupo.findByNombreGrupo", query = "SELECT g FROM Grupo g WHERE g.nombreGrupo = :nombreGrupo")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_GRUPO")
    private Integer codigoGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_GRUPO")
    private String nombreGrupo;
    @OneToMany(mappedBy = "codigoGrupo")
    private List<GrupoDocumento> grupoDocumentoList;
    @OneToMany(mappedBy = "codigoGrupo")
    private List<GrupoCiudadano> grupoCiudadanoList;
    @JoinColumn(name = "CODIGO_PERMISO", referencedColumnName = "CODIGO_PERMISO")
    @ManyToOne
    private Permiso codigoPermiso;

    public Grupo() {
    }

    public Grupo(Integer codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public Grupo(Integer codigoGrupo, String nombreGrupo) {
        this.codigoGrupo = codigoGrupo;
        this.nombreGrupo = nombreGrupo;
    }

    public Integer getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(Integer codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    @XmlTransient
    public List<GrupoDocumento> getGrupoDocumentoList() {
        return grupoDocumentoList;
    }

    public void setGrupoDocumentoList(List<GrupoDocumento> grupoDocumentoList) {
        this.grupoDocumentoList = grupoDocumentoList;
    }

    @XmlTransient
    public List<GrupoCiudadano> getGrupoCiudadanoList() {
        return grupoCiudadanoList;
    }

    public void setGrupoCiudadanoList(List<GrupoCiudadano> grupoCiudadanoList) {
        this.grupoCiudadanoList = grupoCiudadanoList;
    }

    public Permiso getCodigoPermiso() {
        return codigoPermiso;
    }

    public void setCodigoPermiso(Permiso codigoPermiso) {
        this.codigoPermiso = codigoPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoGrupo != null ? codigoGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.codigoGrupo == null && other.codigoGrupo != null) || (this.codigoGrupo != null && !this.codigoGrupo.equals(other.codigoGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Grupo[ codigoGrupo=" + codigoGrupo + " ]";
    }
    
}
