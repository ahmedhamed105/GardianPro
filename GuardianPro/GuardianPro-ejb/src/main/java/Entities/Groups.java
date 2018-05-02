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
@Table(name = "groups", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g")
    , @NamedQuery(name = "Groups.findByGroupid", query = "SELECT g FROM Groups g WHERE g.groupid = :groupid")
    , @NamedQuery(name = "Groups.findByName", query = "SELECT g FROM Groups g WHERE g.name = :name")
    , @NamedQuery(name = "Groups.findByADname", query = "SELECT g FROM Groups g WHERE g.aDname = :aDname")
    , @NamedQuery(name = "Groups.findByDescription", query = "SELECT g FROM Groups g WHERE g.description = :description")
    , @NamedQuery(name = "Groups.findByCreateDate", query = "SELECT g FROM Groups g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "Groups.findByUpdateDate", query = "SELECT g FROM Groups g WHERE g.updateDate = :updateDate")})
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Group_id", nullable = false)
    private Integer groupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Size(max = 45)
    @Column(name = "AD_name", length = 45)
    private String aDname;
    @Size(max = 45)
    @Column(name = "description", length = 45)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupsGroupid")
    private Collection<RoleHasGroups> roleHasGroupsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupsGroupid")
    private Collection<GroupsHasUser> groupsHasUserCollection;

    public Groups() {
    }

    public Groups(Integer groupid) {
        this.groupid = groupid;
    }

    public Groups(Integer groupid, String name, Date createDate, Date updateDate) {
        this.groupid = groupid;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getADname() {
        return aDname;
    }

    public void setADname(String aDname) {
        this.aDname = aDname;
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
    public Collection<RoleHasGroups> getRoleHasGroupsCollection() {
        return roleHasGroupsCollection;
    }

    public void setRoleHasGroupsCollection(Collection<RoleHasGroups> roleHasGroupsCollection) {
        this.roleHasGroupsCollection = roleHasGroupsCollection;
    }

    @XmlTransient
    public Collection<GroupsHasUser> getGroupsHasUserCollection() {
        return groupsHasUserCollection;
    }

    public void setGroupsHasUserCollection(Collection<GroupsHasUser> groupsHasUserCollection) {
        this.groupsHasUserCollection = groupsHasUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Groups[ groupid=" + groupid + " ]";
    }
    
}
