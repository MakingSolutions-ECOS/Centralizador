/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author John Dany
 */
@Entity
@Table(name = "CIUDADANO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadano.findAll", query = "SELECT c FROM Ciudadano c"),
    @NamedQuery(name = "Ciudadano.findByIdentificacionAndTipoIdenitificacion", query = "SELECT c FROM Ciudadano c WHERE c.identificacion = :identificacion AND c.codigoTipoIdentificacion = :codigoTipoIdentificacion"),
    @NamedQuery(name = "Ciudadano.findByCodigoCiudadano", query = "SELECT c FROM Ciudadano c WHERE c.codigoCiudadano = :codigoCiudadano"),
    @NamedQuery(name = "Ciudadano.findByHabilitadoCiudadano", query = "SELECT c FROM Ciudadano c WHERE c.habilitadoCiudadano = :habilitadoCiudadano"),
    @NamedQuery(name = "Ciudadano.findByPrimerNombre", query = "SELECT c FROM Ciudadano c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "Ciudadano.findBySegundoNombre", query = "SELECT c FROM Ciudadano c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Ciudadano.findByPrimerApellido", query = "SELECT c FROM Ciudadano c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Ciudadano.findBySegundoApellido", query = "SELECT c FROM Ciudadano c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Ciudadano.findByIdentificacion", query = "SELECT c FROM Ciudadano c WHERE c.identificacion = :identificacion"),
    @NamedQuery(name = "Ciudadano.findByFechaExpedicionIdentificacion", query = "SELECT c FROM Ciudadano c WHERE c.fechaExpedicionIdentificacion = :fechaExpedicionIdentificacion"),
    @NamedQuery(name = "Ciudadano.findByTelefonoFijo", query = "SELECT c FROM Ciudadano c WHERE c.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "Ciudadano.findByCelular", query = "SELECT c FROM Ciudadano c WHERE c.celular = :celular"),
    @NamedQuery(name = "Ciudadano.findByDireccion", query = "SELECT c FROM Ciudadano c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Ciudadano.findByCorreo", query = "SELECT c FROM Ciudadano c WHERE c.correo = :correo")})
public class Ciudadano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CODIGO_CIUDADANO")
    private Integer codigoCiudadano;
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
    private List<Tramite> tramiteList;
    @JoinColumn(name = "CODIGO_MUNICIPIO", referencedColumnName = "CODIGO_MUNICIPIO")
    @ManyToOne(optional = false)
    private Municipio codigoMunicipio;
    @JoinColumn(name = "CODIGO_NACIONALIDAD", referencedColumnName = "CODIGO_NACIONALIDAD")
    @ManyToOne(optional = false)
    private Nacionalidad codigoNacionalidad;
    @JoinColumn(name = "CODIGO_OPERADOR", referencedColumnName = "CODIGO_OPERADOR")
    @ManyToOne
    private Operador codigoOperador;
    @JoinColumn(name = "CODIGO_TIPO_IDENTIFICACION", referencedColumnName = "CODIGO_TIPO_IDENTIFICACION")
    @ManyToOne(optional = false)
    private TipoIdentificacion codigoTipoIdentificacion;
    @JoinColumn(name = "CODIGO_TIPO_PERSONA", referencedColumnName = "CODIGO_TIPO_PERSONA")
    @ManyToOne(optional = false)
    private TipoPersona codigoTipoPersona;

    public Ciudadano() {
    }

    public Ciudadano(Integer codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
    }

    public Ciudadano(Integer codigoCiudadano, short habilitadoCiudadano, String primerNombre, String primerApellido, String identificacion, Date fechaExpedicionIdentificacion, String telefonoFijo, String celular, String direccion, String correo) {
        this.codigoCiudadano = codigoCiudadano;
        this.habilitadoCiudadano = habilitadoCiudadano;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.identificacion = identificacion;
        this.fechaExpedicionIdentificacion = fechaExpedicionIdentificacion;
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Integer getCodigoCiudadano() {
        return codigoCiudadano;
    }

    public void setCodigoCiudadano(Integer codigoCiudadano) {
        this.codigoCiudadano = codigoCiudadano;
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
    public List<Tramite> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }

    public Municipio getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Municipio codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Nacionalidad getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(Nacionalidad codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public Operador getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(Operador codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public TipoIdentificacion getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(TipoIdentificacion codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public TipoPersona getCodigoTipoPersona() {
        return codigoTipoPersona;
    }

    public void setCodigoTipoPersona(TipoPersona codigoTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona;
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
    
}
