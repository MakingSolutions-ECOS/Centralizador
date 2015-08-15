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
 * @author Johans Gonzalez
 */
@Entity
@Table(name = "OPERADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o"),
    @NamedQuery(name = "Operador.findByCodigoOperador", query = "SELECT o FROM Operador o WHERE o.codigoOperador = :codigoOperador"),
    @NamedQuery(name = "Operador.findByIdentificacionOperador", query = "SELECT o FROM Operador o WHERE o.identificacionOperador = :identificacionOperador"),
    @NamedQuery(name = "Operador.findByNombreOperador", query = "SELECT o FROM Operador o WHERE o.nombreOperador = :nombreOperador"),
    @NamedQuery(name = "Operador.findByFechaActivacion", query = "SELECT o FROM Operador o WHERE o.fechaActivacion = :fechaActivacion"),
    @NamedQuery(name = "Operador.findByFechaActualizacion", query = "SELECT o FROM Operador o WHERE o.fechaActualizacion = :fechaActualizacion")})
public class Operador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_OPERADOR")
    private Integer codigoOperador;
    @Size(max = 15)
    @Column(name = "IDENTIFICACION_OPERADOR")
    private String identificacionOperador;
    @Size(max = 15)
    @Column(name = "NOMBRE_OPERADOR")
    private String nombreOperador;
    @Column(name = "FECHA_ACTIVACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivacion;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoOperador")
    private List<Ciudadano> ciudadanoList;
    @JoinColumn(name = "CODIGO_SUBSCRIPCION", referencedColumnName = "CODIGO_SUBSCRIPCION")
    @ManyToOne
    private Suscripcion codigoSubscripcion;

    public Operador() {
    }

    public Operador(Integer codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public Integer getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(Integer codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public String getIdentificacionOperador() {
        return identificacionOperador;
    }

    public void setIdentificacionOperador(String identificacionOperador) {
        this.identificacionOperador = identificacionOperador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @XmlTransient
    public List<Ciudadano> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<Ciudadano> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    public Suscripcion getCodigoSubscripcion() {
        return codigoSubscripcion;
    }

    public void setCodigoSubscripcion(Suscripcion codigoSubscripcion) {
        this.codigoSubscripcion = codigoSubscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOperador != null ? codigoOperador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.codigoOperador == null && other.codigoOperador != null) || (this.codigoOperador != null && !this.codigoOperador.equals(other.codigoOperador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Operador[ codigoOperador=" + codigoOperador + " ]";
    }
    
}
