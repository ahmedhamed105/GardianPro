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
@Table(name = "component", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Component.findAll", query = "SELECT c FROM Component c")
    , @NamedQuery(name = "Component.findByComponentID", query = "SELECT c FROM Component c WHERE c.componentID = :componentID")
    , @NamedQuery(name = "Component.findByName", query = "SELECT c FROM Component c WHERE c.name = :name")
    , @NamedQuery(name = "Component.findByDescription", query = "SELECT c FROM Component c WHERE c.description = :description")
    , @NamedQuery(name = "Component.findByParentID", query = "SELECT c FROM Component c WHERE c.parentID = :parentID")
    , @NamedQuery(name = "Component.findByType", query = "SELECT c FROM Component c WHERE c.type = :type")
    , @NamedQuery(name = "Component.findByCreateDate", query = "SELECT c FROM Component c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "Component.findByUpdateDate", query = "SELECT c FROM Component c WHERE c.updateDate = :updateDate")})
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "component_ID", nullable = false)
    private Integer componentID;
    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;
    @Size(max = 45)
    @Column(name = "Description", length = 45)
    private String description;
    @Column(name = "Parent_ID")
    private Integer parentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Type", nullable = false, length = 45)
    private String type;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentcomponentID")
    private Collection<RoleHasComponent> roleHasComponentCollection;

    public Component() {
    }

    public Component(Integer componentID) {
        this.componentID = componentID;
    }

    public Component(Integer componentID, String type, Date createDate, Date updateDate) {
        this.componentID = componentID;
        this.type = type;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getComponentID() {
        return componentID;
    }

    public void setComponentID(Integer componentID) {
        this.componentID = componentID;
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

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (componentID != null ? componentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Component)) {
            return false;
        }
        Component other = (Component) object;
        if ((this.componentID == null && other.componentID != null) || (this.componentID != null && !this.componentID.equals(other.componentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Component[ componentID=" + componentID + " ]";
    }
    
}
