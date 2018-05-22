/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "role", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByPrevilegeID", query = "SELECT r FROM Role r WHERE r.previlegeID = :previlegeID")
    , @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name")
    , @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")
    , @NamedQuery(name = "Role.findByCreateDate", query = "SELECT r FROM Role r WHERE r.createDate = :createDate")
    , @NamedQuery(name = "Role.findByUpdateDate", query = "SELECT r FROM Role r WHERE r.updateDate = :updateDate")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "previlege_ID", nullable = false)
    private Integer previlegeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Size(max = 45)
    @Column(name = "Description", length = 45)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleprevilegeID")
    private Collection<RoleHasComponent> roleHasComponentCollection;

    public Role() {
    }

    public Role(Integer previlegeID) {
        this.previlegeID = previlegeID;
    }

    public Role(Integer previlegeID, String name, Date createDate, Date updateDate) {
        this.previlegeID = previlegeID;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getPrevilegeID() {
        return previlegeID;
    }

    public void setPrevilegeID(Integer previlegeID) {
        this.previlegeID = previlegeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @XmlTransient
    public Collection<RoleHasComponent> getRoleHasComponentCollection() {
        return roleHasComponentCollection;
    }

    public void setRoleHasComponentCollection(Collection<RoleHasComponent> roleHasComponentCollection) {
        this.roleHasComponentCollection = roleHasComponentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (previlegeID != null ? previlegeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.previlegeID == null && other.previlegeID != null) || (this.previlegeID != null && !this.previlegeID.equals(other.previlegeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Role[ previlegeID=" + previlegeID + " ]";
    }
    
}
