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
 * @author Angela Suarez
 */
@Entity
@Table(name = "SUSCRIPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscripcion.findAll", query = "SELECT s FROM Suscripcion s"),
    @NamedQuery(name = "Suscripcion.findByCodigoSubscripcion", query = "SELECT s FROM Suscripcion s WHERE s.codigoSubscripcion = :codigoSubscripcion"),
    @NamedQuery(name = "Suscripcion.findByDetalleSubscripcion", query = "SELECT s FROM Suscripcion s WHERE s.detalleSubscripcion = :detalleSubscripcion"),
    @NamedQuery(name = "Suscripcion.findByFecha", query = "SELECT s FROM Suscripcion s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Suscripcion.findByVigente", query = "SELECT s FROM Suscripcion s WHERE s.vigente = :vigente")})
public class Suscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_SUBSCRIPCION")
    private Integer codigoSubscripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DETALLE_SUBSCRIPCION")
    private String detalleSubscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIGENTE")
    private boolean vigente;
    @JoinColumn(name = "CODIGO_OPERADOR", referencedColumnName = "CODIGO_OPERADOR")
    @ManyToOne(optional = false)
    private Operador codigoOperador;

    public Suscripcion() {
    }

    public Suscripcion(Integer codigoSubscripcion) {
        this.codigoSubscripcion = codigoSubscripcion;
    }

    public Suscripcion(Integer codigoSubscripcion, String detalleSubscripcion, Date fecha, boolean vigente) {
        this.codigoSubscripcion = codigoSubscripcion;
        this.detalleSubscripcion = detalleSubscripcion;
        this.fecha = fecha;
        this.vigente = vigente;
    }

    public Integer getCodigoSubscripcion() {
        return codigoSubscripcion;
    }

    public void setCodigoSubscripcion(Integer codigoSubscripcion) {
        this.codigoSubscripcion = codigoSubscripcion;
    }

    public String getDetalleSubscripcion() {
        return detalleSubscripcion;
    }

    public void setDetalleSubscripcion(String detalleSubscripcion) {
        this.detalleSubscripcion = detalleSubscripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Operador getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(Operador codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSubscripcion != null ? codigoSubscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscripcion)) {
            return false;
        }
        Suscripcion other = (Suscripcion) object;
        if ((this.codigoSubscripcion == null && other.codigoSubscripcion != null) || (this.codigoSubscripcion != null && !this.codigoSubscripcion.equals(other.codigoSubscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Suscripcion[ codigoSubscripcion=" + codigoSubscripcion + " ]";
    }
    
}
