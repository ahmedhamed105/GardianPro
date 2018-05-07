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
 * @author ahmed.elemam
 */
@Entity
@Table(name = "accessory_has_group", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccessoryHasGroup.findAll", query = "SELECT a FROM AccessoryHasGroup a"),
    @NamedQuery(name = "AccessoryHasGroup.findById", query = "SELECT a FROM AccessoryHasGroup a WHERE a.id = :id"),
    @NamedQuery(name = "AccessoryHasGroup.findByCreateDate", query = "SELECT a FROM AccessoryHasGroup a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "AccessoryHasGroup.findByUpdateDate", query = "SELECT a FROM AccessoryHasGroup a WHERE a.updateDate = :updateDate")})
public class AccessoryHasGroup implements Serializable {

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
    @JoinColumn(name = "accessory_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Accessory accessoryID;
    @JoinColumn(name = "accessory_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private AccessoryGroup accessoryGroupID;

    public AccessoryHasGroup() {
    }

    public AccessoryHasGroup(Integer id) {
        this.id = id;
    }

    public AccessoryHasGroup(Integer id, Date createDate, Date updateDate) {
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

    public Accessory getAccessoryID() {
        return accessoryID;
    }

    public void setAccessoryID(Accessory accessoryID) {
        this.accessoryID = accessoryID;
    }

    public AccessoryGroup getAccessoryGroupID() {
        return accessoryGroupID;
    }

    public void setAccessoryGroupID(AccessoryGroup accessoryGroupID) {
        this.accessoryGroupID = accessoryGroupID;
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
        if (!(object instanceof AccessoryHasGroup)) {
            return false;
        }
        AccessoryHasGroup other = (AccessoryHasGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AccessoryHasGroup[ id=" + id + " ]";
    }
    
}
