/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "PUBLICIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicidad.findAll", query = "SELECT p FROM Publicidad p"),
    @NamedQuery(name = "Publicidad.findByCodigoPublicidad", query = "SELECT p FROM Publicidad p WHERE p.codigoPublicidad = :codigoPublicidad"),
    @NamedQuery(name = "Publicidad.findByFechaCreacionPublicidad", query = "SELECT p FROM Publicidad p WHERE p.fechaCreacionPublicidad = :fechaCreacionPublicidad"),
    @NamedQuery(name = "Publicidad.findByFechaInicioPublicacion", query = "SELECT p FROM Publicidad p WHERE p.fechaInicioPublicacion = :fechaInicioPublicacion"),
    @NamedQuery(name = "Publicidad.findByDuracionPublicacionMinutos", query = "SELECT p FROM Publicidad p WHERE p.duracionPublicacionMinutos = :duracionPublicacionMinutos"),
    @NamedQuery(name = "Publicidad.findByHabilitada", query = "SELECT p FROM Publicidad p WHERE p.habilitada = :habilitada")})
public class Publicidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PUBLICIDAD")
    private Integer codigoPublicidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION_PUBLICIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionPublicidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO_PUBLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioPublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION_PUBLICACION_MINUTOS")
    private int duracionPublicacionMinutos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADA")
    private short habilitada;
    @OneToMany(mappedBy = "codigoPublicidad")
    private List<PublicidadImagen> publicidadImagenList;
    @JoinColumn(name = "CODIGO_CIUDADANO", referencedColumnName = "CODIGO_CIUDADANO")
    @ManyToOne
    private Ciudadano codigoCiudadano;

    public Publicidad() {
    }

    public Publicidad(Integer codigoPublicidad) {
        this.codigoPublicidad = codigoPublicidad;
    }

    public Publicidad(Integer codigoPublicidad, Date fechaCreacionPublicidad, Date fechaInicioPublicacion, int duracionPublicacionMinutos, short habilitada) {
        this.codigoPublicidad = codigoPublicidad;
        this.fechaCreacionPublicidad = fechaCreacionPublicidad;
        this.fechaInicioPublicacion = fechaInicioPublicacion;
        this.duracionPublicacionMinutos = duracionPublicacionMinutos;
        this.habilitada = habilitada;
    }

    public Integer getCodigoPublicidad() {
        return codigoPublicidad;
    }

    public void setCodigoPublicidad(Integer codigoPublicidad) {
        this.codigoPublicidad = codigoPublicidad;
    }

    public Date getFechaCreacionPublicidad() {
        return fechaCreacionPublicidad;
    }

    public void setFechaCreacionPublicidad(Date fechaCreacionPublicidad) {
        this.fechaCreacionPublicidad = fechaCreacionPublicidad;
    }

    public Date getFechaInicioPublicacion() {
        return fechaInicioPublicacion;
    }

    public void setFechaInicioPublicacion(Date fechaInicioPublicacion) {
        this.fechaInicioPublicacion = fechaInicioPublicacion;
    }

    public int getDuracionPublicacionMinutos() {
        return duracionPublicacionMinutos;
    }

    public void setDuracionPublicacionMinutos(int duracionPublicacionMinutos) {
        this.duracionPublicacionMinutos = duracionPublicacionMinutos;
    }

    public short getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(short habilitada) {
        this.habilitada = habilitada;
    }

    @XmlTransient
    public List<PublicidadImagen> getPublicidadImagenList() {
        return publicidadImagenList;
    }

    public void setPublicidadImagenList(List<PublicidadImagen> publicidadImagenList) {
        this.publicidadImagenList = publicidadImagenList;
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
        hash += (codigoPublicidad != null ? codigoPublicidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicidad)) {
            return false;
        }
        Publicidad other = (Publicidad) object;
        if ((this.codigoPublicidad == null && other.codigoPublicidad != null) || (this.codigoPublicidad != null && !this.codigoPublicidad.equals(other.codigoPublicidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Publicidad[ codigoPublicidad=" + codigoPublicidad + " ]";
    }
    
}
