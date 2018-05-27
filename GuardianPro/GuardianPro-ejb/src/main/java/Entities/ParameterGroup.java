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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author ahmed.elemam
 */
@Entity
@Table(name = "parameter_group", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParameterGroup.findAll", query = "SELECT p FROM ParameterGroup p"),
    @NamedQuery(name = "ParameterGroup.findById", query = "SELECT p FROM ParameterGroup p WHERE p.id = :id"),
    @NamedQuery(name = "ParameterGroup.findByGroupname", query = "SELECT p FROM ParameterGroup p WHERE p.groupname = :groupname"),
    @NamedQuery(name = "ParameterGroup.findByCreateDate", query = "SELECT p FROM ParameterGroup p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "ParameterGroup.findByUpdateDate", query = "SELECT p FROM ParameterGroup p WHERE p.updateDate = :updateDate")})
public class ParameterGroup implements Serializable {

    @JoinColumn(name = "Parameter_type_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ParameterType parametertypeID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parameterGroupID")
    private Collection<TgroupHasGparameter> tgroupHasGparameterCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Group_name", nullable = false, length = 100)
    private String groupname;
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
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parameterGroupID")
    private Collection<GroupHasParameter> groupHasParameterCollection;

    public ParameterGroup() {
    }

    public ParameterGroup(Integer id) {
        this.id = id;
    }

    public ParameterGroup(Integer id, String groupname, Date createDate, Date updateDate) {
        this.id = id;
        this.groupname = groupname;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
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

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Collection<GroupHasParameter> getGroupHasParameterCollection() {
        return groupHasParameterCollection;
    }

    public void setGroupHasParameterCollection(Collection<GroupHasParameter> groupHasParameterCollection) {
        this.groupHasParameterCollection = groupHasParameterCollection;
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
        if (!(object instanceof ParameterGroup)) {
            return false;
        }
        ParameterGroup other = (ParameterGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ParameterGroup[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<TgroupHasGparameter> getTgroupHasGparameterCollection() {
        return tgroupHasGparameterCollection;
    }

    public void setTgroupHasGparameterCollection(Collection<TgroupHasGparameter> tgroupHasGparameterCollection) {
        this.tgroupHasGparameterCollection = tgroupHasGparameterCollection;
    }

    public ParameterType getParametertypeID() {
        return parametertypeID;
    }

    public void setParametertypeID(ParameterType parametertypeID) {
        this.parametertypeID = parametertypeID;
    }
    
}
