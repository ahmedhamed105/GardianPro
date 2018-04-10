/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "login_type", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginType.findAll", query = "SELECT l FROM LoginType l")
    , @NamedQuery(name = "LoginType.findById", query = "SELECT l FROM LoginType l WHERE l.id = :id")
    , @NamedQuery(name = "LoginType.findByLgtype", query = "SELECT l FROM LoginType l WHERE l.lgtype = :lgtype")})
public class LoginType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Lg_type", nullable = false, length = 45)
    private String lgtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logintypeID")
    private Collection<LoginWay> loginWayCollection;

    public LoginType() {
    }

    public LoginType(Integer id) {
        this.id = id;
    }

    public LoginType(Integer id, String lgtype) {
        this.id = id;
        this.lgtype = lgtype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLgtype() {
        return lgtype;
    }

    public void setLgtype(String lgtype) {
        this.lgtype = lgtype;
    }

    @XmlTransient
    public Collection<LoginWay> getLoginWayCollection() {
        return loginWayCollection;
    }

    public void setLoginWayCollection(Collection<LoginWay> loginWayCollection) {
        this.loginWayCollection = loginWayCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginType)) {
            return false;
        }
        LoginType other = (LoginType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.LoginType[ id=" + id + " ]";
    }
    
}
