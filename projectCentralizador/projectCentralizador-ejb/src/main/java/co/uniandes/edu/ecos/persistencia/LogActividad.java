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
@Table(name = "LOG_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogActividad.findAll", query = "SELECT l FROM LogActividad l"),
    @NamedQuery(name = "LogActividad.findByCodigoLogActividad", query = "SELECT l FROM LogActividad l WHERE l.codigoLogActividad = :codigoLogActividad"),
    @NamedQuery(name = "LogActividad.findByFecha", query = "SELECT l FROM LogActividad l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "LogActividad.findByDescripcionLog", query = "SELECT l FROM LogActividad l WHERE l.descripcionLog = :descripcionLog")})
public class LogActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_LOG_ACTIVIDAD")
    private Integer codigoLogActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION_LOG")
    private String descripcionLog;
    @JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne
    private Usuario codigoUsuario;

    public LogActividad() {
    }

    public LogActividad(Integer codigoLogActividad) {
        this.codigoLogActividad = codigoLogActividad;
    }

    public LogActividad(Integer codigoLogActividad, Date fecha, String descripcionLog) {
        this.codigoLogActividad = codigoLogActividad;
        this.fecha = fecha;
        this.descripcionLog = descripcionLog;
    }

    public Integer getCodigoLogActividad() {
        return codigoLogActividad;
    }

    public void setCodigoLogActividad(Integer codigoLogActividad) {
        this.codigoLogActividad = codigoLogActividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionLog() {
        return descripcionLog;
    }

    public void setDescripcionLog(String descripcionLog) {
        this.descripcionLog = descripcionLog;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLogActividad != null ? codigoLogActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogActividad)) {
            return false;
        }
        LogActividad other = (LogActividad) object;
        if ((this.codigoLogActividad == null && other.codigoLogActividad != null) || (this.codigoLogActividad != null && !this.codigoLogActividad.equals(other.codigoLogActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.LogActividad[ codigoLogActividad=" + codigoLogActividad + " ]";
    }
    
}
