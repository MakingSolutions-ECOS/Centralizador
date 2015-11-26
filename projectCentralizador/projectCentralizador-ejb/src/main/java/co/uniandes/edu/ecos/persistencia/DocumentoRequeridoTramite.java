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
 * @author Angela Suarez
 */
@Entity
@Table(name = "DOCUMENTO_REQUERIDO_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoRequeridoTramite.findAll", query = "SELECT d FROM DocumentoRequeridoTramite d"),
    @NamedQuery(name = "DocumentoRequeridoTramite.findByCodigoDocumentoRequerido", query = "SELECT d FROM DocumentoRequeridoTramite d WHERE d.codigoDocumentoRequerido = :codigoDocumentoRequerido")})
public class DocumentoRequeridoTramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_DOCUMENTO_REQUERIDO")
    private Integer codigoDocumentoRequerido;
    @JoinColumn(name = "CODIGO_TRAMITE_DEFINICION", referencedColumnName = "CODIGO_TRAMITE_DEFINICION")
    @ManyToOne(optional = false)
    private TramiteDefinicion codigoTramiteDefinicion;
    @JoinColumn(name = "CODIGO_METADATA_TIPO_DOCUMENTO", referencedColumnName = "CODIGO_METADATA_TIPO_DOCUMENTO")
    @ManyToOne(optional = false)
    private MetadataTipoDocumento codigoMetadataTipoDocumento;

    public DocumentoRequeridoTramite() {
    }

    public DocumentoRequeridoTramite(Integer codigoDocumentoRequerido) {
        this.codigoDocumentoRequerido = codigoDocumentoRequerido;
    }

    public Integer getCodigoDocumentoRequerido() {
        return codigoDocumentoRequerido;
    }

    public void setCodigoDocumentoRequerido(Integer codigoDocumentoRequerido) {
        this.codigoDocumentoRequerido = codigoDocumentoRequerido;
    }

    public TramiteDefinicion getCodigoTramiteDefinicion() {
        return codigoTramiteDefinicion;
    }

    public void setCodigoTramiteDefinicion(TramiteDefinicion codigoTramiteDefinicion) {
        this.codigoTramiteDefinicion = codigoTramiteDefinicion;
    }

    public MetadataTipoDocumento getCodigoMetadataTipoDocumento() {
        return codigoMetadataTipoDocumento;
    }

    public void setCodigoMetadataTipoDocumento(MetadataTipoDocumento codigoMetadataTipoDocumento) {
        this.codigoMetadataTipoDocumento = codigoMetadataTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDocumentoRequerido != null ? codigoDocumentoRequerido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoRequeridoTramite)) {
            return false;
        }
        DocumentoRequeridoTramite other = (DocumentoRequeridoTramite) object;
        if ((this.codigoDocumentoRequerido == null && other.codigoDocumentoRequerido != null) || (this.codigoDocumentoRequerido != null && !this.codigoDocumentoRequerido.equals(other.codigoDocumentoRequerido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.DocumentoRequeridoTramite[ codigoDocumentoRequerido=" + codigoDocumentoRequerido + " ]";
    }
    
}
