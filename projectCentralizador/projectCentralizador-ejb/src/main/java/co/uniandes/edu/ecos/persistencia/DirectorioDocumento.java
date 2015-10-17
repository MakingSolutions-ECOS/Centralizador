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
@Table(name = "DIRECTORIO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirectorioDocumento.findAll", query = "SELECT d FROM DirectorioDocumento d"),
    @NamedQuery(name = "DirectorioDocumento.findByCodigoDirectorioDocumento", query = "SELECT d FROM DirectorioDocumento d WHERE d.codigoDirectorioDocumento = :codigoDirectorioDocumento")})
public class DirectorioDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_DIRECTORIO_DOCUMENTO")
    private Integer codigoDirectorioDocumento;
    @OneToMany(mappedBy = "codigoDirectorioDocumento")
    private List<Directorio> directorioList;
    @OneToMany(mappedBy = "codigoDirectorioDocuento")
    private List<Documento> documentoList;

    public DirectorioDocumento() {
    }

    public DirectorioDocumento(Integer codigoDirectorioDocumento) {
        this.codigoDirectorioDocumento = codigoDirectorioDocumento;
    }

    public Integer getCodigoDirectorioDocumento() {
        return codigoDirectorioDocumento;
    }

    public void setCodigoDirectorioDocumento(Integer codigoDirectorioDocumento) {
        this.codigoDirectorioDocumento = codigoDirectorioDocumento;
    }

    @XmlTransient
    public List<Directorio> getDirectorioList() {
        return directorioList;
    }

    public void setDirectorioList(List<Directorio> directorioList) {
        this.directorioList = directorioList;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDirectorioDocumento != null ? codigoDirectorioDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectorioDocumento)) {
            return false;
        }
        DirectorioDocumento other = (DirectorioDocumento) object;
        if ((this.codigoDirectorioDocumento == null && other.codigoDirectorioDocumento != null) || (this.codigoDirectorioDocumento != null && !this.codigoDirectorioDocumento.equals(other.codigoDirectorioDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.DirectorioDocumento[ codigoDirectorioDocumento=" + codigoDirectorioDocumento + " ]";
    }
    
}
