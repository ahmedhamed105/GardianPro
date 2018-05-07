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
 * @author ahmed.elemam
 */
@Entity
@Table(name = "accessory", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessory.findAll", query = "SELECT a FROM Accessory a"),
    @NamedQuery(name = "Accessory.findById", query = "SELECT a FROM Accessory a WHERE a.id = :id"),
    @NamedQuery(name = "Accessory.findByCreateDate", query = "SELECT a FROM Accessory a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "Accessory.findByUpdateDate", query = "SELECT a FROM Accessory a WHERE a.updateDate = :updateDate"),
    @NamedQuery(name = "Accessory.findByAccName", query = "SELECT a FROM Accessory a WHERE a.accName = :accName"),
    @NamedQuery(name = "Accessory.findByAccDescr", query = "SELECT a FROM Accessory a WHERE a.accDescr = :accDescr"),
    @NamedQuery(name = "Accessory.findByAccCatalog", query = "SELECT a FROM Accessory a WHERE a.accCatalog = :accCatalog")})
public class Accessory implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "acc_name", nullable = false, length = 150)
    private String accName;
    @Size(max = 400)
    @Column(name = "acc_descr", length = 400)
    private String accDescr;
    @Size(max = 150)
    @Column(name = "acc_catalog", length = 150)
    private String accCatalog;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessoryID")
    private Collection<AccessoryHasGroup> accessoryHasGroupCollection;

    public Accessory() {
    }

    public Accessory(Integer id) {
        this.id = id;
    }

    public Accessory(Integer id, Date createDate, Date updateDate, String accName) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.accName = accName;
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

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccDescr() {
        return accDescr;
    }

    public void setAccDescr(String accDescr) {
        this.accDescr = accDescr;
    }

    public String getAccCatalog() {
        return accCatalog;
    }

    public void setAccCatalog(String accCatalog) {
        this.accCatalog = accCatalog;
    }

    @XmlTransient
    public Collection<AccessoryHasGroup> getAccessoryHasGroupCollection() {
        return accessoryHasGroupCollection;
    }

    public void setAccessoryHasGroupCollection(Collection<AccessoryHasGroup> accessoryHasGroupCollection) {
        this.accessoryHasGroupCollection = accessoryHasGroupCollection;
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
        if (!(object instanceof Accessory)) {
            return false;
        }
        Accessory other = (Accessory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Accessory[ id=" + id + " ]";
    }
    
}
