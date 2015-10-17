/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByCodigoDocumento", query = "SELECT d FROM Documento d WHERE d.codigoDocumento = :codigoDocumento"),
    @NamedQuery(name = "Documento.findByCodigoTipoMetadataCentralizador", query = "SELECT d FROM Documento d WHERE d.codigoTipoMetadataCentralizador = :codigoTipoMetadataCentralizador"),
    @NamedQuery(name = "Documento.findByFechaModificacion", query = "SELECT d FROM Documento d WHERE d.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Documento.findByNombreDocumento", query = "SELECT d FROM Documento d WHERE d.nombreDocumento = :nombreDocumento"),
    @NamedQuery(name = "Documento.findByRutaLogicaDocumento", query = "SELECT d FROM Documento d WHERE d.rutaLogicaDocumento = :rutaLogicaDocumento"),
    @NamedQuery(name = "Documento.findByFechaCreacionDirectorio", query = "SELECT d FROM Documento d WHERE d.fechaCreacionDirectorio = :fechaCreacionDirectorio"),
    @NamedQuery(name = "Documento.findByRutaFisicaDirectorio", query = "SELECT d FROM Documento d WHERE d.rutaFisicaDirectorio = :rutaFisicaDirectorio")})
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_DOCUMENTO")
    private Integer codigoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TIPO_METADATA_CENTRALIZADOR")
    private int codigoTipoMetadataCentralizador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_DOCUMENTO")
    private String nombreDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "RUTA_LOGICA_DOCUMENTO")
    private String rutaLogicaDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION_DIRECTORIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionDirectorio;
    @Size(max = 150)
    @Column(name = "RUTA_FISICA_DIRECTORIO")
    private String rutaFisicaDirectorio;
    @JoinColumn(name = "CODIGO_GRUPO_DOCUMENTO", referencedColumnName = "CODIGO_GRUPO_DOCUMENTO")
    @ManyToOne
    private GrupoDocumento codigoGrupoDocumento;
    @JoinColumn(name = "CODIGO_DIRECTORIO_DOCUENTO", referencedColumnName = "CODIGO_DIRECTORIO_DOCUMENTO")
    @ManyToOne
    private DirectorioDocumento codigoDirectorioDocuento;
    @JoinColumn(name = "CODIGO_CIUDADANO", referencedColumnName = "CODIGO_CIUDADANO")
    @ManyToOne
    private Ciudadano codigoCiudadano;

    public Documento() {
    }

    public Documento(Integer codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public Documento(Integer codigoDocumento, int codigoTipoMetadataCentralizador, Date fechaModificacion, String nombreDocumento, String rutaLogicaDocumento, Date fechaCreacionDirectorio) {
        this.codigoDocumento = codigoDocumento;
        this.codigoTipoMetadataCentralizador = codigoTipoMetadataCentralizador;
        this.fechaModificacion = fechaModificacion;
        this.nombreDocumento = nombreDocumento;
        this.rutaLogicaDocumento = rutaLogicaDocumento;
        this.fechaCreacionDirectorio = fechaCreacionDirectorio;
    }

    public Integer getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(Integer codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public int getCodigoTipoMetadataCentralizador() {
        return codigoTipoMetadataCentralizador;
    }

    public void setCodigoTipoMetadataCentralizador(int codigoTipoMetadataCentralizador) {
        this.codigoTipoMetadataCentralizador = codigoTipoMetadataCentralizador;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getRutaLogicaDocumento() {
        return rutaLogicaDocumento;
    }

    public void setRutaLogicaDocumento(String rutaLogicaDocumento) {
        this.rutaLogicaDocumento = rutaLogicaDocumento;
    }

    public Date getFechaCreacionDirectorio() {
        return fechaCreacionDirectorio;
    }

    public void setFechaCreacionDirectorio(Date fechaCreacionDirectorio) {
        this.fechaCreacionDirectorio = fechaCreacionDirectorio;
    }

    public String getRutaFisicaDirectorio() {
        return rutaFisicaDirectorio;
    }

    public void setRutaFisicaDirectorio(String rutaFisicaDirectorio) {
        this.rutaFisicaDirectorio = rutaFisicaDirectorio;
    }

    public GrupoDocumento getCodigoGrupoDocumento() {
        return codigoGrupoDocumento;
    }

    public void setCodigoGrupoDocumento(GrupoDocumento codigoGrupoDocumento) {
        this.codigoGrupoDocumento = codigoGrupoDocumento;
    }

    public DirectorioDocumento getCodigoDirectorioDocuento() {
        return codigoDirectorioDocuento;
    }

    public void setCodigoDirectorioDocuento(DirectorioDocumento codigoDirectorioDocuento) {
        this.codigoDirectorioDocuento = codigoDirectorioDocuento;
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
        hash += (codigoDocumento != null ? codigoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.codigoDocumento == null && other.codigoDocumento != null) || (this.codigoDocumento != null && !this.codigoDocumento.equals(other.codigoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Documento[ codigoDocumento=" + codigoDocumento + " ]";
    }
    
}
