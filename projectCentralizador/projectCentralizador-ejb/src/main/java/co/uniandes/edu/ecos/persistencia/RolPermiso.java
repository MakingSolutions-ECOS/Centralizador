/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "ROL_PERMISO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r"),
    @NamedQuery(name = "RolPermiso.findByCodigoRolPermiso", query = "SELECT r FROM RolPermiso r WHERE r.codigoRolPermiso = :codigoRolPermiso")})
public class RolPermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ROL_PERMISO")
    private Integer codigoRolPermiso;
    @JoinColumn(name = "CODIGO_ROL", referencedColumnName = "CODIGO_ROL")
    @ManyToOne
    private Rol codigoRol;
    @JoinColumn(name = "CODIGO_PERMISO", referencedColumnName = "CODIGO_PERMISO")
    @ManyToOne(optional = false)
    private Permiso codigoPermiso;

    public RolPermiso() {
    }

    public RolPermiso(Integer codigoRolPermiso) {
        this.codigoRolPermiso = codigoRolPermiso;
    }

    public Integer getCodigoRolPermiso() {
        return codigoRolPermiso;
    }

    public void setCodigoRolPermiso(Integer codigoRolPermiso) {
        this.codigoRolPermiso = codigoRolPermiso;
    }

    public Rol getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(Rol codigoRol) {
        this.codigoRol = codigoRol;
    }

    public Permiso getCodigoPermiso() {
        return codigoPermiso;
    }

    public void setCodigoPermiso(Permiso codigoPermiso) {
        this.codigoPermiso = codigoPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRolPermiso != null ? codigoRolPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPermiso)) {
            return false;
        }
        RolPermiso other = (RolPermiso) object;
        if ((this.codigoRolPermiso == null && other.codigoRolPermiso != null) || (this.codigoRolPermiso != null && !this.codigoRolPermiso.equals(other.codigoRolPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.RolPermiso[ codigoRolPermiso=" + codigoRolPermiso + " ]";
    }
    
}
