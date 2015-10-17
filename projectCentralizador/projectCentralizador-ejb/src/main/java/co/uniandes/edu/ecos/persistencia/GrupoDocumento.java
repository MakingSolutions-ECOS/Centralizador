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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "GRUPO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoDocumento.findAll", query = "SELECT g FROM GrupoDocumento g"),
    @NamedQuery(name = "GrupoDocumento.findByCodigoGrupoDocumento", query = "SELECT g FROM GrupoDocumento g WHERE g.codigoGrupoDocumento = :codigoGrupoDocumento")})
public class GrupoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_GRUPO_DOCUMENTO")
    private Integer codigoGrupoDocumento;
    @OneToMany(mappedBy = "codigoGrupoDocumento")
    private List<Documento> documentoList;
    @JoinColumn(name = "CODIGO_GRUPO", referencedColumnName = "CODIGO_GRUPO")
    @ManyToOne
    private Grupo codigoGrupo;

    public GrupoDocumento() {
    }

    public GrupoDocumento(Integer codigoGrupoDocumento) {
        this.codigoGrupoDocumento = codigoGrupoDocumento;
    }

    public Integer getCodigoGrupoDocumento() {
        return codigoGrupoDocumento;
    }

    public void setCodigoGrupoDocumento(Integer codigoGrupoDocumento) {
        this.codigoGrupoDocumento = codigoGrupoDocumento;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    public Grupo getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(Grupo codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoGrupoDocumento != null ? codigoGrupoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDocumento)) {
            return false;
        }
        GrupoDocumento other = (GrupoDocumento) object;
        if ((this.codigoGrupoDocumento == null && other.codigoGrupoDocumento != null) || (this.codigoGrupoDocumento != null && !this.codigoGrupoDocumento.equals(other.codigoGrupoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.GrupoDocumento[ codigoGrupoDocumento=" + codigoGrupoDocumento + " ]";
    }
    
}
