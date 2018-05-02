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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "role_has_component", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleHasComponent.findAll", query = "SELECT r FROM RoleHasComponent r")
    , @NamedQuery(name = "RoleHasComponent.findById", query = "SELECT r FROM RoleHasComponent r WHERE r.id = :id")})
public class RoleHasComponent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @JoinColumn(name = "Role_previlege_ID", referencedColumnName = "previlege_ID", nullable = false)
    @ManyToOne(optional = false)
    private Role roleprevilegeID;
    @JoinColumn(name = "component_component_ID", referencedColumnName = "component_ID", nullable = false)
    @ManyToOne(optional = false)
    private Component componentcomponentID;

    public RoleHasComponent() {
    }

    public RoleHasComponent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRoleprevilegeID() {
        return roleprevilegeID;
    }

    public void setRoleprevilegeID(Role roleprevilegeID) {
        this.roleprevilegeID = roleprevilegeID;
    }

    public Component getComponentcomponentID() {
        return componentcomponentID;
    }

    public void setComponentcomponentID(Component componentcomponentID) {
        this.componentcomponentID = componentcomponentID;
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
        if (!(object instanceof RoleHasComponent)) {
            return false;
        }
        RoleHasComponent other = (RoleHasComponent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RoleHasComponent[ id=" + id + " ]";
    }
    
}
