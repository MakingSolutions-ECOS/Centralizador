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
@Table(name = "EMISOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emisor.findAll", query = "SELECT e FROM Emisor e"),
    @NamedQuery(name = "Emisor.findByCodigoEntidadEmisora", query = "SELECT e FROM Emisor e WHERE e.codigoEntidadEmisora = :codigoEntidadEmisora"),
    @NamedQuery(name = "Emisor.findByNombreEntidadEmisora", query = "SELECT e FROM Emisor e WHERE e.nombreEntidadEmisora = :nombreEntidadEmisora")})
public class Emisor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ENTIDAD_EMISORA")
    private Integer codigoEntidadEmisora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ENTIDAD_EMISORA")
    private String nombreEntidadEmisora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEntidadEmisora")
    private List<TramiteDefinicion> tramiteDefinicionList;
    @JoinColumn(name = "CODIGO_GRUPO_EMISOR", referencedColumnName = "CODIGO_GRUPO_EMISOR")
    @ManyToOne(optional = false)
    private GrupoEmisor codigoGrupoEmisor;
    @JoinColumn(name = "CODIGO_TIPO_ENTIDAD", referencedColumnName = "CODIGO_TIPO_ENTIDAD")
    @ManyToOne(optional = false)
    private TipoEntidad codigoTipoEntidad;

    public Emisor() {
    }

    public Emisor(Integer codigoEntidadEmisora) {
        this.codigoEntidadEmisora = codigoEntidadEmisora;
    }

    public Emisor(Integer codigoEntidadEmisora, String nombreEntidadEmisora) {
        this.codigoEntidadEmisora = codigoEntidadEmisora;
        this.nombreEntidadEmisora = nombreEntidadEmisora;
    }

    public Integer getCodigoEntidadEmisora() {
        return codigoEntidadEmisora;
    }

    public void setCodigoEntidadEmisora(Integer codigoEntidadEmisora) {
        this.codigoEntidadEmisora = codigoEntidadEmisora;
    }

    public String getNombreEntidadEmisora() {
        return nombreEntidadEmisora;
    }

    public void setNombreEntidadEmisora(String nombreEntidadEmisora) {
        this.nombreEntidadEmisora = nombreEntidadEmisora;
    }

    @XmlTransient
    public List<TramiteDefinicion> getTramiteDefinicionList() {
        return tramiteDefinicionList;
    }

    public void setTramiteDefinicionList(List<TramiteDefinicion> tramiteDefinicionList) {
        this.tramiteDefinicionList = tramiteDefinicionList;
    }

    public GrupoEmisor getCodigoGrupoEmisor() {
        return codigoGrupoEmisor;
    }

    public void setCodigoGrupoEmisor(GrupoEmisor codigoGrupoEmisor) {
        this.codigoGrupoEmisor = codigoGrupoEmisor;
    }

    public TipoEntidad getCodigoTipoEntidad() {
        return codigoTipoEntidad;
    }

    public void setCodigoTipoEntidad(TipoEntidad codigoTipoEntidad) {
        this.codigoTipoEntidad = codigoTipoEntidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEntidadEmisora != null ? codigoEntidadEmisora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emisor)) {
            return false;
        }
        Emisor other = (Emisor) object;
        if ((this.codigoEntidadEmisora == null && other.codigoEntidadEmisora != null) || (this.codigoEntidadEmisora != null && !this.codigoEntidadEmisora.equals(other.codigoEntidadEmisora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Emisor[ codigoEntidadEmisora=" + codigoEntidadEmisora + " ]";
    }
    
}
