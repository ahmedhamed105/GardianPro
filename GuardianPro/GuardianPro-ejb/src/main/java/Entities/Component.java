/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "component", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Component.findAll", query = "SELECT c FROM Component c")
    , @NamedQuery(name = "Component.findByComponentID", query = "SELECT c FROM Component c WHERE c.componentPK.componentID = :componentID")
    , @NamedQuery(name = "Component.findByName", query = "SELECT c FROM Component c WHERE c.componentPK.name = :name")
    , @NamedQuery(name = "Component.findByDescription", query = "SELECT c FROM Component c WHERE c.description = :description")
    , @NamedQuery(name = "Component.findByParentID", query = "SELECT c FROM Component c WHERE c.parentID = :parentID")
    , @NamedQuery(name = "Component.findByType", query = "SELECT c FROM Component c WHERE c.type = :type")})
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComponentPK componentPK;
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
    @ManyToMany(mappedBy = "componentCollection")
    private Collection<Role> roleCollection;

    public Component() {
    }

    public Component(ComponentPK componentPK) {
        this.componentPK = componentPK;
    }

    public Component(ComponentPK componentPK, String type) {
        this.componentPK = componentPK;
        this.type = type;
    }

    public Component(int componentID, String name) {
        this.componentPK = new ComponentPK(componentID, name);
    }

    public ComponentPK getComponentPK() {
        return componentPK;
    }

    public void setComponentPK(ComponentPK componentPK) {
        this.componentPK = componentPK;
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

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentPK != null ? componentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Component)) {
            return false;
        }
        Component other = (Component) object;
        if ((this.componentPK == null && other.componentPK != null) || (this.componentPK != null && !this.componentPK.equals(other.componentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Component[ componentPK=" + componentPK + " ]";
    }
    
}
