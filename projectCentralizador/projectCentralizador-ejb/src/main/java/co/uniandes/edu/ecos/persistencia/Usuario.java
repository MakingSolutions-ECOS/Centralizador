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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angela Suarez
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodigoUsuario", query = "SELECT u FROM Usuario u WHERE u.codigoUsuario = :codigoUsuario"),
    @NamedQuery(name = "Usuario.findByPrimerNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.primerNombreUsuario = :primerNombreUsuario"),
    @NamedQuery(name = "Usuario.findBySegundoNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.segundoNombreUsuario = :segundoNombreUsuario"),
    @NamedQuery(name = "Usuario.findByPrimeroApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.primeroApellidoUsuario = :primeroApellidoUsuario"),
    @NamedQuery(name = "Usuario.findBySegundoApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.segundoApellidoUsuario = :segundoApellidoUsuario"),
    @NamedQuery(name = "Usuario.findByCorreoUsuario", query = "SELECT u FROM Usuario u WHERE u.correoUsuario = :correoUsuario"),
    @NamedQuery(name = "Usuario.findByIdentificacionUsuario", query = "SELECT u FROM Usuario u WHERE u.identificacionUsuario = :identificacionUsuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_USUARIO")
    private Integer codigoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRIMER_NOMBRE_USUARIO")
    private String primerNombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SEGUNDO_NOMBRE_USUARIO")
    private String segundoNombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRIMERO_APELLIDO_USUARIO")
    private String primeroApellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SEGUNDO_APELLIDO_USUARIO")
    private String segundoApellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO_USUARIO")
    private String correoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDENTIFICACION_USUARIO")
    private String identificacionUsuario;
    @JoinColumn(name = "CODIGO_TIPO_IDENTIFICACION", referencedColumnName = "CODIGO_TIPO_IDENTIFICACION")
    @ManyToOne(optional = false)
    private TipoIdentificacion codigoTipoIdentificacion;
    @JoinColumn(name = "CODIGO_ROL", referencedColumnName = "CODIGO_ROL")
    @ManyToOne(optional = false)
    private Rol codigoRol;

    public Usuario() {
    }

    public Usuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuario(Integer codigoUsuario, String primerNombreUsuario, String segundoNombreUsuario, String primeroApellidoUsuario, String segundoApellidoUsuario, String correoUsuario, String identificacionUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.primerNombreUsuario = primerNombreUsuario;
        this.segundoNombreUsuario = segundoNombreUsuario;
        this.primeroApellidoUsuario = primeroApellidoUsuario;
        this.segundoApellidoUsuario = segundoApellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.identificacionUsuario = identificacionUsuario;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getPrimerNombreUsuario() {
        return primerNombreUsuario;
    }

    public void setPrimerNombreUsuario(String primerNombreUsuario) {
        this.primerNombreUsuario = primerNombreUsuario;
    }

    public String getSegundoNombreUsuario() {
        return segundoNombreUsuario;
    }

    public void setSegundoNombreUsuario(String segundoNombreUsuario) {
        this.segundoNombreUsuario = segundoNombreUsuario;
    }

    public String getPrimeroApellidoUsuario() {
        return primeroApellidoUsuario;
    }

    public void setPrimeroApellidoUsuario(String primeroApellidoUsuario) {
        this.primeroApellidoUsuario = primeroApellidoUsuario;
    }

    public String getSegundoApellidoUsuario() {
        return segundoApellidoUsuario;
    }

    public void setSegundoApellidoUsuario(String segundoApellidoUsuario) {
        this.segundoApellidoUsuario = segundoApellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public TipoIdentificacion getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(TipoIdentificacion codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public Rol getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(Rol codigoRol) {
        this.codigoRol = codigoRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniandes.edu.ecos.persistencia.Usuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
