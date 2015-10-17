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
@Table(name = "DIRECTORIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Directorio.findAll", query = "SELECT d FROM Directorio d"),
    @NamedQuery(name = "Directorio.findByCodigoMetadata", query = "SELECT d FROM Directorio d WHERE d.codigoMetadata = :codigoMetadata"),
    @NamedQuery(name = "Directorio.findByCodigoCiudadano", query = "SELECT d FROM Directorio d WHERE d.codigoCiudadano = :codigoCiudadano"),
    @NamedQuery(name = "Directorio.findByCodigoGrupoDocumento", query = "SELECT d FROM Directorio d WHERE d.codigoGrupoDocumento = :codigoGrupoDocumento"),
    @NamedQuery(name = "Directorio.findByCodigoTipoMetadataCentralizador", query = "SELECT d FROM Directorio d WHERE d.codigoTipoMetadataCentralizador = :codigoTipoMetadataCentralizador"),
    @NamedQuery(name = "Directorio.findByFechaModificacion", query = "SELECT d FROM Directorio d WHERE d.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Directorio.findByNombreDirectorio", query = "SELECT d FROM Directorio d WHERE d.nombreDirectorio = :nombreDirectorio"),
    @NamedQuery(name = "Directorio.findByRutaLogicaDirectorio", query = "SELECT d FROM Directorio d WHERE d.rutaLogicaDirectorio = :rutaLogicaDirectorio"),
    @NamedQuery(name = "Directorio.findByFechaCreacionDirectorio", query = "SELECT d FROM Directorio d WHERE d.fechaCreacionDirectorio = :fechaCreacionDirectorio"),
    @NamedQuery(name = "Directorio.findByRutaFisicaDirectorio", query = "SELECT d FROM Directorio d WHERE d.rutaFisicaDirectorio = :rutaFisicaDirectorio")})
public class Directorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_METADATA")
    private Integer codigoMetadata;
    @Column(name = "CODIGO_CIUDADANO")
    private Integer codigoCiudadano;
    @Column(name = "CODIGO_GRUPO_DOCUMENTO")
    private Integer codigoGrupoDocumento;
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
    @Column(name = "NOMBRE_DIRECTORIO")
    private String nombreDirectorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "RUTA_LOGICA_DIRECTORIO")
    private String rutaLogicaDirectorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION_DIRECTORIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionDirectorio;
    @Size(max = 150)
    @Column(name = "RUTA_FISICA_DIRECTORIO")
    private String rutaFisicaDirectorio;
    @JoinColumn(name = "CODIGO_DIRECTORIO_DOCUMENTO", referencedColumnName = "CODIGO_DIRECTORIO_DOCUMENTO")
    @ManyToOne
    private DirectorioDocumento codigoDirectorioDocumento;

    public Directorio() {
    }

    public Directorio(Integer codigoMetadata) {
        this.codigoMetadata = codigoMetadata;
    }

    public Directorio(Integer codigoMetadata, int codigoTipoMetadataCentralizador, Date fechaModificacion, String nombreDirectorio, String rutaLogicaDirectorio, Date fechaCreacionDirectorio) {
        this.codigoMetadata = codigoMetadata;
        this.codigoTipoMetadataCentralizador = codigoTipoMetadataCentralizador;
        this.fechaModificacion = fechaModificacion;
        this.nombreDirectorio = nombreDirectorio;
        this.rutaLogicaDirectorio = rutaLogicaDirectorio;
        this.fechaCreacionDirectorio = fechaCreacionDirectorio;
    }

    public Integer getCodigoMetadata() {
        return codigoMetadata;
    }

    public void setCodigoMetadata(Integer codigoMetadata) {
        this.codigoMetadata = codigoMetadata;
    }

    public Integer getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(Integer codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public Integer getCodigoGrupoDocumento() {
        return codigoGrupoDocumento;
    }

    public void setCodigoGrupoDocumento(Integer codigoGrupoDocumento) {
        this.codigoGrupoDocumento = codigoGrupoDocumento;
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

    public String getNombreDirectorio() {
        return nombreDirectorio;
    }

    public void setNombreDirectorio(String nombreDirectorio) {
        this.nombreDirectorio = nombreDirectorio;
    }

    public String getRutaLogicaDirectorio() {
        return rutaLogicaDirectorio;
    }

    public void setRutaLogicaDirectorio(String rutaLogicaDirectorio) {
        this.rutaLogicaDirectorio = rutaLogicaDirectorio;
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

    public DirectorioDocumento getCodigoDirectorioDocumento() {
        return codigoDirectorioDocumento;
    }

    public void setCodigoDirectorioDocumento(DirectorioDocumento codigoDirectorioDocumento) {
        this.codigoDirectorioDocumento = codigoDirectorioDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMetadata != null ? codigoMetadata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directorio)) {
            return false;
        }
        Directorio other = (Directorio) object;
        if ((this.codigoMetadata == null && other.codigoMetadata != null) || (this.codigoMetadata != null && !this.codigoMetadata.equals(other.codigoMetadata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Directorio[ codigoMetadata=" + codigoMetadata + " ]";
    }
    
}
