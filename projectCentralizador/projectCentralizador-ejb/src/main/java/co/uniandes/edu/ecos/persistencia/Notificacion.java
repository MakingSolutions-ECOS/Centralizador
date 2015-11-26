/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angela Suarez
 */
@Entity
@Table(name = "NOTIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n"),
    @NamedQuery(name = "Notificacion.findByCodigoNotificacion", query = "SELECT n FROM Notificacion n WHERE n.codigoNotificacion = :codigoNotificacion"),
    @NamedQuery(name = "Notificacion.findByCiudadano", query = "SELECT n FROM Notificacion n WHERE n.codigoCiudadano.codigoCiudadano = :codigoCiudadano"),
    @NamedQuery(name = "Notificacion.findByCiudadanoEstado", query = "SELECT n FROM Notificacion n WHERE n.codigoCiudadano.codigoCiudadano = :codigoCiudadano AND n.codigoNotificacionEstado.codigoEstado = :codigoEstado"),    
    @NamedQuery(name = "Notificacion.findByRemitente", query = "SELECT n FROM Notificacion n WHERE n.remitente = :remitente"),
    @NamedQuery(name = "Notificacion.findByMensaje", query = "SELECT n FROM Notificacion n WHERE n.mensaje = :mensaje"),
    @NamedQuery(name = "Notificacion.findByUrlAdjunto", query = "SELECT n FROM Notificacion n WHERE n.urlAdjunto = :urlAdjunto")})
public class Notificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull   
    @Column(name = "CODIGO_NOTIFICACION")       
    private Integer codigoNotificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "REMITENTE")
    private String remitente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Size(max = 300)
    @Column(name = "URL_ADJUNTO")
    private String urlAdjunto;
    @JoinColumn(name = "CODIGO_NOTIFICACION_ESTADO", referencedColumnName = "CODIGO_ESTADO")
    @ManyToOne(optional = false)
    private NotificacionEstado codigoNotificacionEstado;
    @JoinColumn(name = "CODIGO_CIUDADANO", referencedColumnName = "CODIGO_CIUDADANO")
    @ManyToOne(optional = false)
    private Ciudadano codigoCiudadano;

    public Notificacion() {
    }

    public Notificacion(Integer codigoNotificacion) {
        this.codigoNotificacion = codigoNotificacion;
    }

    public Notificacion(Integer codigoNotificacion, String remitente, String mensaje) {
        this.codigoNotificacion = codigoNotificacion;
        this.remitente = remitente;
        this.mensaje = mensaje;
    }

    public Integer getCodigoNotificacion() {
        return codigoNotificacion;
    }

    public void setCodigoNotificacion(Integer codigoNotificacion) {
        this.codigoNotificacion = codigoNotificacion;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrlAdjunto() {
        return urlAdjunto;
    }

    public void setUrlAdjunto(String urlAdjunto) {
        this.urlAdjunto = urlAdjunto;
    }

    public NotificacionEstado getCodigoNotificacionEstado() {
        return codigoNotificacionEstado;
    }

    public void setCodigoNotificacionEstado(NotificacionEstado codigoNotificacionEstado) {
        this.codigoNotificacionEstado = codigoNotificacionEstado;
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
        hash += (codigoNotificacion != null ? codigoNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.codigoNotificacion == null && other.codigoNotificacion != null) || (this.codigoNotificacion != null && !this.codigoNotificacion.equals(other.codigoNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Notificacion[ codigoNotificacion=" + codigoNotificacion + " ]";
    }
    
}
