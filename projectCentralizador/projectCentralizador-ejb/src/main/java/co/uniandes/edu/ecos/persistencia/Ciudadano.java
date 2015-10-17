/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "CIUDADANO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadano.findAll", query = "SELECT c FROM Ciudadano c"),
    @NamedQuery(name = "Ciudadano.findByCodigoCiudadano", query = "SELECT c FROM Ciudadano c WHERE c.codigoCiudadano = :codigoCiudadano"),
    @NamedQuery(name = "Ciudadano.findByFechaAfiliacion", query = "SELECT c FROM Ciudadano c WHERE c.fechaAfiliacion = :fechaAfiliacion"),
    @NamedQuery(name = "Ciudadano.findByEmail", query = "SELECT c FROM Ciudadano c WHERE c.email = :email"),
    @NamedQuery(name = "Ciudadano.findByNumeroIdentificacion", query = "SELECT c FROM Ciudadano c WHERE c.numeroIdentificacion = :numeroIdentificacion"),
    @NamedQuery(name = "Ciudadano.findByTipoIdentificacion", query = "SELECT c FROM Ciudadano c WHERE c.tipoIdentificacion = :tipoIdentificacion")})
public class Ciudadano implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADO_CIUDADANO")
    private short habilitadoCiudadano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 15)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 15)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EXPEDICION_IDENTIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpedicionIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONO_FIJO")
    private String telefonoFijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CELULAR")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCiudadano")
    private List<Notificacion> notificacionList;
    @JoinColumn(name = "CODIGO_TIPO_PERSONA", referencedColumnName = "CODIGO_TIPO_PERSONA")
    @ManyToOne(optional = false)
    private TipoPersona codigoTipoPersona;
    @JoinColumn(name = "CODIGO_TIPO_IDENTIFICACION", referencedColumnName = "CODIGO_TIPO_IDENTIFICACION")
    @ManyToOne(optional = false)
    private TipoIdentificacion codigoTipoIdentificacion;
    @JoinColumn(name = "CODIGO_OPERADOR", referencedColumnName = "CODIGO_OPERADOR")
    @ManyToOne
    private Operador codigoOperador;
    @JoinColumn(name = "CODIGO_NACIONALIDAD", referencedColumnName = "CODIGO_NACIONALIDAD")
    @ManyToOne(optional = false)
    private Nacionalidad codigoNacionalidad;
    @JoinColumn(name = "CODIGO_MUNICIPIO", referencedColumnName = "CODIGO_MUNICIPIO")
    @ManyToOne(optional = false)
    private Municipio codigoMunicipio;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CIUDADANO")
    private Integer codigoCiudadano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_AFILIACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAfiliacion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_IDENTIFICACION")
    private int tipoIdentificacion;
    @JoinColumn(name = "CODIGO_TIPO_CIUDADANO", referencedColumnName = "CODIGO_TIPO_CIUDADANO")
    @ManyToOne
    private TipoCiudadano codigoTipoCiudadano;
    @JoinColumn(name = "CODIGO_CAPACIDAD_ALMACENAMIENTO", referencedColumnName = "CODIGO_CAPACIDAD_ALMACENAMIENTO")
    @ManyToOne
    private CapacidadAlmacenamiento codigoCapacidadAlmacenamiento;
    @OneToMany(mappedBy = "codigoCiudadano")
    private List<Tramite> tramiteList;
    @OneToMany(mappedBy = "codigoCiudadano")
    private List<Documento> documentoList;
    @OneToMany(mappedBy = "codigoCiudadano")
    private List<GrupoCiudadano> grupoCiudadanoList;
    @OneToMany(mappedBy = "codigoCiudadano")
    private List<Publicidad> publicidadList;

    public Ciudadano() {
    }

    public Ciudadano(Integer codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public Ciudadano(Integer codigoCiudadano, Date fechaAfiliacion, String email, String numeroIdentificacion, int tipoIdentificacion) {
        this.codigoCiudadano = codigoCiudadano;
        this.fechaAfiliacion = fechaAfiliacion;
        this.email = email;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(Integer codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public Date getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(Date fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public TipoCiudadano getCodigoTipoCiudadano() {
        return codigoTipoCiudadano;
    }

    public void setCodigoTipoCiudadano(TipoCiudadano codigoTipoCiudadano) {
        this.codigoTipoCiudadano = codigoTipoCiudadano;
    }

    public CapacidadAlmacenamiento getCodigoCapacidadAlmacenamiento() {
        return codigoCapacidadAlmacenamiento;
    }

    public void setCodigoCapacidadAlmacenamiento(CapacidadAlmacenamiento codigoCapacidadAlmacenamiento) {
        this.codigoCapacidadAlmacenamiento = codigoCapacidadAlmacenamiento;
    }

    @XmlTransient
    public List<Tramite> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @XmlTransient
    public List<GrupoCiudadano> getGrupoCiudadanoList() {
        return grupoCiudadanoList;
    }

    public void setGrupoCiudadanoList(List<GrupoCiudadano> grupoCiudadanoList) {
        this.grupoCiudadanoList = grupoCiudadanoList;
    }

    @XmlTransient
    public List<Publicidad> getPublicidadList() {
        return publicidadList;
    }

    public void setPublicidadList(List<Publicidad> publicidadList) {
        this.publicidadList = publicidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCiudadano != null ? codigoCiudadano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudadano)) {
            return false;
        }
        Ciudadano other = (Ciudadano) object;
        if ((this.codigoCiudadano == null && other.codigoCiudadano != null) || (this.codigoCiudadano != null && !this.codigoCiudadano.equals(other.codigoCiudadano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Ciudadano[ codigoCiudadano=" + codigoCiudadano + " ]";
    }

    public short getHabilitadoCiudadano() {
        return habilitadoCiudadano;
    }

    public void setHabilitadoCiudadano(short habilitadoCiudadano) {
        this.habilitadoCiudadano = habilitadoCiudadano;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaExpedicionIdentificacion() {
        return fechaExpedicionIdentificacion;
    }

    public void setFechaExpedicionIdentificacion(Date fechaExpedicionIdentificacion) {
        this.fechaExpedicionIdentificacion = fechaExpedicionIdentificacion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    public TipoPersona getCodigoTipoPersona() {
        return codigoTipoPersona;
    }

    public void setCodigoTipoPersona(TipoPersona codigoTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona;
    }

    public TipoIdentificacion getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(TipoIdentificacion codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public Operador getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(Operador codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public Nacionalidad getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(Nacionalidad codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public Municipio getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Municipio codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }
    
}
