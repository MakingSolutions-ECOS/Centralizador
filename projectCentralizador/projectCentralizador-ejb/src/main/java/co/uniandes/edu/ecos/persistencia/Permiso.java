/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "PERMISO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByCodigoPermiso", query = "SELECT p FROM Permiso p WHERE p.codigoPermiso = :codigoPermiso"),
    @NamedQuery(name = "Permiso.findByNombrePermiso", query = "SELECT p FROM Permiso p WHERE p.nombrePermiso = :nombrePermiso"),
    @NamedQuery(name = "Permiso.findByZonaPermiso", query = "SELECT p FROM Permiso p WHERE p.zonaPermiso = :zonaPermiso")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PERMISO")
    private Integer codigoPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_PERMISO")
    private String nombrePermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ZONA_PERMISO")
    private String zonaPermiso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPermiso")
    private List<RolPermiso> rolPermisoList;

    public Permiso() {
    }

    public Permiso(Integer codigoPermiso) {
        this.codigoPermiso = codigoPermiso;
    }

    public Permiso(Integer codigoPermiso, String nombrePermiso, String zonaPermiso) {
        this.codigoPermiso = codigoPermiso;
        this.nombrePermiso = nombrePermiso;
        this.zonaPermiso = zonaPermiso;
    }

    public Integer getCodigoPermiso() {
        return codigoPermiso;
    }

    public void setCodigoPermiso(Integer codigoPermiso) {
        this.codigoPermiso = codigoPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getZonaPermiso() {
        return zonaPermiso;
    }

    public void setZonaPermiso(String zonaPermiso) {
        this.zonaPermiso = zonaPermiso;
    }

    @XmlTransient
    public List<RolPermiso> getRolPermisoList() {
        return rolPermisoList;
    }

    public void setRolPermisoList(List<RolPermiso> rolPermisoList) {
        this.rolPermisoList = rolPermisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPermiso != null ? codigoPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.codigoPermiso == null && other.codigoPermiso != null) || (this.codigoPermiso != null && !this.codigoPermiso.equals(other.codigoPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Permiso[ codigoPermiso=" + codigoPermiso + " ]";
    }
    
}
