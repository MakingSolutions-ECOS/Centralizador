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
@Table(name = "METADATA_TIPO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetadataTipoDocumento.findAll", query = "SELECT m FROM MetadataTipoDocumento m"),
    @NamedQuery(name = "MetadataTipoDocumento.findByCodigoMetadataTipoDocumento", query = "SELECT m FROM MetadataTipoDocumento m WHERE m.codigoMetadataTipoDocumento = :codigoMetadataTipoDocumento"),
    @NamedQuery(name = "MetadataTipoDocumento.findByNombreMetadataTipoDocumento", query = "SELECT m FROM MetadataTipoDocumento m WHERE m.nombreMetadataTipoDocumento = :nombreMetadataTipoDocumento"),
    @NamedQuery(name = "MetadataTipoDocumento.findByDescripcionMetadataTipoDocumento", query = "SELECT m FROM MetadataTipoDocumento m WHERE m.descripcionMetadataTipoDocumento = :descripcionMetadataTipoDocumento"),
    @NamedQuery(name = "MetadataTipoDocumento.findByValidezDocumento", query = "SELECT m FROM MetadataTipoDocumento m WHERE m.validezDocumento = :validezDocumento")})
public class MetadataTipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_METADATA_TIPO_DOCUMENTO")
    private Integer codigoMetadataTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_METADATA_TIPO_DOCUMENTO")
    private String nombreMetadataTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION_METADATA_TIPO_DOCUMENTO")
    private String descripcionMetadataTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALIDEZ_DOCUMENTO")
    private int validezDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMetadataTipoDocumento")
    private List<DocumentoRequeridoTramite> documentoRequeridoTramiteList;

    public MetadataTipoDocumento() {
    }

    public MetadataTipoDocumento(Integer codigoMetadataTipoDocumento) {
        this.codigoMetadataTipoDocumento = codigoMetadataTipoDocumento;
    }

    public MetadataTipoDocumento(Integer codigoMetadataTipoDocumento, String nombreMetadataTipoDocumento, String descripcionMetadataTipoDocumento, int validezDocumento) {
        this.codigoMetadataTipoDocumento = codigoMetadataTipoDocumento;
        this.nombreMetadataTipoDocumento = nombreMetadataTipoDocumento;
        this.descripcionMetadataTipoDocumento = descripcionMetadataTipoDocumento;
        this.validezDocumento = validezDocumento;
    }

    public Integer getCodigoMetadataTipoDocumento() {
        return codigoMetadataTipoDocumento;
    }

    public void setCodigoMetadataTipoDocumento(Integer codigoMetadataTipoDocumento) {
        this.codigoMetadataTipoDocumento = codigoMetadataTipoDocumento;
    }

    public String getNombreMetadataTipoDocumento() {
        return nombreMetadataTipoDocumento;
    }

    public void setNombreMetadataTipoDocumento(String nombreMetadataTipoDocumento) {
        this.nombreMetadataTipoDocumento = nombreMetadataTipoDocumento;
    }

    public String getDescripcionMetadataTipoDocumento() {
        return descripcionMetadataTipoDocumento;
    }

    public void setDescripcionMetadataTipoDocumento(String descripcionMetadataTipoDocumento) {
        this.descripcionMetadataTipoDocumento = descripcionMetadataTipoDocumento;
    }

    public int getValidezDocumento() {
        return validezDocumento;
    }

    public void setValidezDocumento(int validezDocumento) {
        this.validezDocumento = validezDocumento;
    }

    @XmlTransient
    public List<DocumentoRequeridoTramite> getDocumentoRequeridoTramiteList() {
        return documentoRequeridoTramiteList;
    }

    public void setDocumentoRequeridoTramiteList(List<DocumentoRequeridoTramite> documentoRequeridoTramiteList) {
        this.documentoRequeridoTramiteList = documentoRequeridoTramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMetadataTipoDocumento != null ? codigoMetadataTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetadataTipoDocumento)) {
            return false;
        }
        MetadataTipoDocumento other = (MetadataTipoDocumento) object;
        if ((this.codigoMetadataTipoDocumento == null && other.codigoMetadataTipoDocumento != null) || (this.codigoMetadataTipoDocumento != null && !this.codigoMetadataTipoDocumento.equals(other.codigoMetadataTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.MetadataTipoDocumento[ codigoMetadataTipoDocumento=" + codigoMetadataTipoDocumento + " ]";
    }
    
}
