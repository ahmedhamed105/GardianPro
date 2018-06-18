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
 * @author ahmed.elemam
 */
@Entity
@Table(name = "component_name", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComponentName.findAll", query = "SELECT c FROM ComponentName c"),
    @NamedQuery(name = "ComponentName.findById", query = "SELECT c FROM ComponentName c WHERE c.id = :id"),
    @NamedQuery(name = "ComponentName.findByName", query = "SELECT c FROM ComponentName c WHERE c.name = :name"),
    @NamedQuery(name = "ComponentName.findByValue", query = "SELECT c FROM ComponentName c WHERE c.value = :value"),
    @NamedQuery(name = "ComponentName.findByDescription", query = "SELECT c FROM ComponentName c WHERE c.description = :description"),
    @NamedQuery(name = "ComponentName.findByEdit", query = "SELECT c FROM ComponentName c WHERE c.edit = :edit"),
    @NamedQuery(name = "ComponentName.findByCreateDate", query = "SELECT c FROM ComponentName c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "ComponentName.findByUpdateDate", query = "SELECT c FROM ComponentName c WHERE c.updateDate = :updateDate")})
public class ComponentName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "Name", length = 45)
    private String name;
    @Size(max = 45)
    @Column(name = "Value", length = 45)
    private String value;
    @Size(max = 45)
    @Column(name = "Description", length = 45)
    private String description;
    @Column(name = "Edit")
    private Integer edit;
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
    @JoinColumn(name = "component_component_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Component componentcomponentID;

    public ComponentName() {
    }

    public ComponentName(Integer id) {
        this.id = id;
    }

    public ComponentName(Integer id, Date createDate, Date updateDate) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEdit() {
        return edit;
    }

    public void setEdit(Integer edit) {
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
        if (!(object instanceof ComponentName)) {
            return false;
        }
        ComponentName other = (ComponentName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ComponentName[ id=" + id + " ]";
    }
    
}
