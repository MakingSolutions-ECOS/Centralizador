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
@Table(name = "ROL_RECURSO_PERMITIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolRecursoPermitido.findAll", query = "SELECT r FROM RolRecursoPermitido r"),
    @NamedQuery(name = "RolRecursoPermitido.findByCodigoRolRecursoPermitido", query = "SELECT r FROM RolRecursoPermitido r WHERE r.codigoRolRecursoPermitido = :codigoRolRecursoPermitido")})
public class RolRecursoPermitido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ROL_RECURSO_PERMITIDO")
    private Integer codigoRolRecursoPermitido;
    @JoinColumn(name = "CODIGO_ROL", referencedColumnName = "CODIGO_ROL")
    @ManyToOne
    private Rol codigoRol;
    @JoinColumn(name = "CODIGO_RECURSO_PERMITIDO", referencedColumnName = "CODIGO_RECURSO_PERMITIDO")
    @ManyToOne
    private RecursoPermitido codigoRecursoPermitido;

    public RolRecursoPermitido() {
    }

    public RolRecursoPermitido(Integer codigoRolRecursoPermitido) {
        this.codigoRolRecursoPermitido = codigoRolRecursoPermitido;
    }

    public Integer getCodigoRolRecursoPermitido() {
        return codigoRolRecursoPermitido;
    }

    public void setCodigoRolRecursoPermitido(Integer codigoRolRecursoPermitido) {
        this.codigoRolRecursoPermitido = codigoRolRecursoPermitido;
    }

    public Rol getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(Rol codigoRol) {
        this.codigoRol = codigoRol;
    }

    public RecursoPermitido getCodigoRecursoPermitido() {
        return codigoRecursoPermitido;
    }

    public void setCodigoRecursoPermitido(RecursoPermitido codigoRecursoPermitido) {
        this.codigoRecursoPermitido = codigoRecursoPermitido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRolRecursoPermitido != null ? codigoRolRecursoPermitido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolRecursoPermitido)) {
            return false;
        }
        RolRecursoPermitido other = (RolRecursoPermitido) object;
        if ((this.codigoRolRecursoPermitido == null && other.codigoRolRecursoPermitido != null) || (this.codigoRolRecursoPermitido != null && !this.codigoRolRecursoPermitido.equals(other.codigoRolRecursoPermitido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.RolRecursoPermitido[ codigoRolRecursoPermitido=" + codigoRolRecursoPermitido + " ]";
    }
    
}
