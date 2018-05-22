/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "role_has_groups", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleHasGroups.findAll", query = "SELECT r FROM RoleHasGroups r")
    , @NamedQuery(name = "RoleHasGroups.findById", query = "SELECT r FROM RoleHasGroups r WHERE r.id = :id")
    , @NamedQuery(name = "RoleHasGroups.findByGroupsid", query = "SELECT r FROM RoleHasGroups r WHERE r.groupsGroupid = :id")
    , @NamedQuery(name = "RoleHasGroups.findByCreateDate", query = "SELECT r FROM RoleHasGroups r WHERE r.createDate = :createDate")
    , @NamedQuery(name = "RoleHasGroups.findByUpdateDate", query = "SELECT r FROM RoleHasGroups r WHERE r.updateDate = :updateDate")})
public class RoleHasGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
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
    @JoinColumn(name = "Groups_Group_id", referencedColumnName = "Group_id", nullable = false)
    @ManyToOne(optional = false)
    private Groups groupsGroupid;
    @JoinColumn(name = "Role_previlege_ID", referencedColumnName = "previlege_ID", nullable = false)
    @ManyToOne(optional = false)
    private Role roleprevilegeID;

    public RoleHasGroups() {
    }

    public RoleHasGroups(Integer id) {
        this.id = id;
    }

    public RoleHasGroups(Integer id, Date createDate, Date updateDate) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Groups getGroupsGroupid() {
        return groupsGroupid;
    }

    public void setGroupsGroupid(Groups groupsGroupid) {
        this.groupsGroupid = groupsGroupid;
    }

    public Role getRoleprevilegeID() {
        return roleprevilegeID;
    }

    public void setRoleprevilegeID(Role roleprevilegeID) {
        this.roleprevilegeID = roleprevilegeID;
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
        if (!(object instanceof RoleHasGroups)) {
            return false;
        }
        RoleHasGroups other = (RoleHasGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RoleHasGroups[ id=" + id + " ]";
    }
    
}
