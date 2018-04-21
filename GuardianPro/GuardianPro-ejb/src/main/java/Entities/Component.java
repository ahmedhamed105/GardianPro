/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    , @NamedQuery(name = "Component.findByDescription", query = "SELECT c FROM Component c WHERE c.description = :description")})
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
    @JoinColumn(name = "previlege_previlege_ID", referencedColumnName = "previlege_ID", nullable = false)
    @ManyToOne(optional = false)
    private Role previlegeprevilegeID;

    public Component() {
    }

    public Component(Integer componentID) {
        this.componentID = componentID;
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

    public Role getPrevilegeprevilegeID() {
        return previlegeprevilegeID;
    }

    public void setPrevilegeprevilegeID(Role previlegeprevilegeID) {
        this.previlegeprevilegeID = previlegeprevilegeID;
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
