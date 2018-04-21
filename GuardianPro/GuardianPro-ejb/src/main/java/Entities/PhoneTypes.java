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
@Table(name = "phone_types", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneTypes.findAll", query = "SELECT p FROM PhoneTypes p")
    , @NamedQuery(name = "PhoneTypes.findById", query = "SELECT p FROM PhoneTypes p WHERE p.id = :id")
    , @NamedQuery(name = "PhoneTypes.findByTeleType", query = "SELECT p FROM PhoneTypes p WHERE p.teleType = :teleType")
    , @NamedQuery(name = "PhoneTypes.findByCreateDate", query = "SELECT p FROM PhoneTypes p WHERE p.createDate = :createDate")
    , @NamedQuery(name = "PhoneTypes.findByUpdateDate", query = "SELECT p FROM PhoneTypes p WHERE p.updateDate = :updateDate")})
public class PhoneTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "tele_type", length = 45)
    private String teleType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phonetypesID")
    private Collection<PhoneData> phoneDataCollection;

    public PhoneTypes() {
    }

    public PhoneTypes(Integer id) {
        this.id = id;
    }

    public PhoneTypes(Integer id, Date createDate, Date updateDate) {
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

    public String getTeleType() {
        return teleType;
    }

    public void setTeleType(String teleType) {
        this.teleType = teleType;
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
    public Collection<PhoneData> getPhoneDataCollection() {
        return phoneDataCollection;
    }

    public void setPhoneDataCollection(Collection<PhoneData> phoneDataCollection) {
        this.phoneDataCollection = phoneDataCollection;
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
        if (!(object instanceof PhoneTypes)) {
            return false;
        }
        PhoneTypes other = (PhoneTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PhoneTypes[ id=" + id + " ]";
    }
    
}
