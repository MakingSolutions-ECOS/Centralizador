/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.ecos.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author Jimmy
 */
@Entity
@Table(name = "RECURSO_PERMITIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecursoPermitido.findAll", query = "SELECT r FROM RecursoPermitido r"),
    @NamedQuery(name = "RecursoPermitido.findByCodigoRecursoPermitido", query = "SELECT r FROM RecursoPermitido r WHERE r.codigoRecursoPermitido = :codigoRecursoPermitido"),
    @NamedQuery(name = "RecursoPermitido.findByDescripcionRecurso", query = "SELECT r FROM RecursoPermitido r WHERE r.descripcionRecurso = :descripcionRecurso")})
public class RecursoPermitido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_RECURSO_PERMITIDO")
    private Integer codigoRecursoPermitido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION_RECURSO")
    private String descripcionRecurso;
    @OneToMany(mappedBy = "codigoRecursoPermitido")
    private List<RolRecursoPermitido> rolRecursoPermitidoList;

    public RecursoPermitido() {
    }

    public RecursoPermitido(Integer codigoRecursoPermitido) {
        this.codigoRecursoPermitido = codigoRecursoPermitido;
    }

    public RecursoPermitido(Integer codigoRecursoPermitido, String descripcionRecurso) {
        this.codigoRecursoPermitido = codigoRecursoPermitido;
        this.descripcionRecurso = descripcionRecurso;
    }

    public Integer getCodigoRecursoPermitido() {
        return codigoRecursoPermitido;
    }

    public void setCodigoRecursoPermitido(Integer codigoRecursoPermitido) {
        this.codigoRecursoPermitido = codigoRecursoPermitido;
    }

    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    @XmlTransient
    public List<RolRecursoPermitido> getRolRecursoPermitidoList() {
        return rolRecursoPermitidoList;
    }

    public void setRolRecursoPermitidoList(List<RolRecursoPermitido> rolRecursoPermitidoList) {
        this.rolRecursoPermitidoList = rolRecursoPermitidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRecursoPermitido != null ? codigoRecursoPermitido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoPermitido)) {
            return false;
        }
        RecursoPermitido other = (RecursoPermitido) object;
        if ((this.codigoRecursoPermitido == null && other.codigoRecursoPermitido != null) || (this.codigoRecursoPermitido != null && !this.codigoRecursoPermitido.equals(other.codigoRecursoPermitido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.RecursoPermitido[ codigoRecursoPermitido=" + codigoRecursoPermitido + " ]";
    }
    
}
