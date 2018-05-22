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
import javax.validation.constraints.Size;
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
    , @NamedQuery(name = "RoleHasComponent.findById", query = "SELECT r FROM RoleHasComponent r WHERE r.id = :id")
    , @NamedQuery(name = "RoleHasComponent.findByRole", query = "SELECT r FROM RoleHasComponent r WHERE r.roleprevilegeID = :id")
    , @NamedQuery(name = "RoleHasComponent.findByView", query = "SELECT r FROM RoleHasComponent r WHERE r.view = :view")
    , @NamedQuery(name = "RoleHasComponent.findByEdit", query = "SELECT r FROM RoleHasComponent r WHERE r.edit = :edit")
    , @NamedQuery(name = "RoleHasComponent.findByCreateDate", query = "SELECT r FROM RoleHasComponent r WHERE r.createDate = :createDate")
    , @NamedQuery(name = "RoleHasComponent.findByUpdateDate", query = "SELECT r FROM RoleHasComponent r WHERE r.updateDate = :updateDate")})
public class RoleHasComponent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "view", nullable = false, length = 45)
    private String view;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "edit", nullable = false, length = 45)
    private String edit;
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

    public RoleHasComponent(Integer id, String view, String edit, Date createDate, Date updateDate) {
        this.id = id;
        this.view = view;
        this.edit = edit;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
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
