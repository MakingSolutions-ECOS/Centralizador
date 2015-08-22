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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByCodigoMunicipio", query = "SELECT m FROM Municipio m WHERE m.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Municipio.findByNombreMunicipio", query = "SELECT m FROM Municipio m WHERE m.nombreMunicipio = :nombreMunicipio")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MUNICIPIO")
    private Integer codigoMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_MUNICIPIO")
    private String nombreMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMunicipio")
    private List<Ciudadano> ciudadanoList;
    @JoinColumn(name = "CODIGO_DEPARTAMENTO", referencedColumnName = "CODIGO_DEPARTAMENTO")
    @ManyToOne(optional = false)
    private Departamento codigoDepartamento;

    public Municipio() {
    }

    public Municipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Municipio(Integer codigoMunicipio, String nombreMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
        this.nombreMunicipio = nombreMunicipio;
    }

    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    @XmlTransient
    public List<Ciudadano> getCiudadanoList() {
        return ciudadanoList;
    }

    public void setCiudadanoList(List<Ciudadano> ciudadanoList) {
        this.ciudadanoList = ciudadanoList;
    }

    public Departamento getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Departamento codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMunicipio != null ? codigoMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.codigoMunicipio == null && other.codigoMunicipio != null) || (this.codigoMunicipio != null && !this.codigoMunicipio.equals(other.codigoMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Municipio[ codigoMunicipio=" + codigoMunicipio + " ]";
    }
    
}
