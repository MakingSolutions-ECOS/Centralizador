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
 * @author John Dany
 */
@Entity
@Table(name = "NOTIFICACION_ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificacionEstado.findAll", query = "SELECT n FROM NotificacionEstado n"),
    @NamedQuery(name = "NotificacionEstado.findByCodigoEstado", query = "SELECT n FROM NotificacionEstado n WHERE n.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "NotificacionEstado.findByNombreEstado", query = "SELECT n FROM NotificacionEstado n WHERE n.nombreEstado = :nombreEstado")})
public class NotificacionEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESTADO")
    private Integer codigoEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ESTADO")
    private String nombreEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNotificacionEstado")
    private List<Notificacion> notificacionList;

    public NotificacionEstado() {
    }

    public NotificacionEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public NotificacionEstado(Integer codigoEstado, String nombreEstado) {
        this.codigoEstado = codigoEstado;
        this.nombreEstado = nombreEstado;
    }

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @XmlTransient
    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstado != null ? codigoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificacionEstado)) {
            return false;
        }
        NotificacionEstado other = (NotificacionEstado) object;
        if ((this.codigoEstado == null && other.codigoEstado != null) || (this.codigoEstado != null && !this.codigoEstado.equals(other.codigoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.NotificacionEstado[ codigoEstado=" + codigoEstado + " ]";
    }
    
}
