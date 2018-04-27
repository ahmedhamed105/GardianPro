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
@Table(name = "marital_status", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaritalStatus.findAll", query = "SELECT m FROM MaritalStatus m"),
    @NamedQuery(name = "MaritalStatus.findById", query = "SELECT m FROM MaritalStatus m WHERE m.id = :id"),
    @NamedQuery(name = "MaritalStatus.findByMaritaltype", query = "SELECT m FROM MaritalStatus m WHERE m.maritaltype = :maritaltype"),
    @NamedQuery(name = "MaritalStatus.findByCreateDate", query = "SELECT m FROM MaritalStatus m WHERE m.createDate = :createDate"),
    @NamedQuery(name = "MaritalStatus.findByUpdateDate", query = "SELECT m FROM MaritalStatus m WHERE m.updateDate = :updateDate")})
public class MaritalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Marital_type", nullable = false, length = 45)
    private String maritaltype;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maritalstatusID")
    private Collection<NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;

    public MaritalStatus() {
    }

    public MaritalStatus(Integer id) {
        this.id = id;
    }

    public MaritalStatus(Integer id, String maritaltype, Date createDate, Date updateDate) {
        this.id = id;
        this.maritaltype = maritaltype;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaritaltype() {
        return maritaltype;
    }

    public void setMaritaltype(String maritaltype) {
        this.maritaltype = maritaltype;
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
    public Collection<NationalIdHasMaritalStatus> getNationalIdHasMaritalStatusCollection() {
        return nationalIdHasMaritalStatusCollection;
    }

    public void setNationalIdHasMaritalStatusCollection(Collection<NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection) {
        this.nationalIdHasMaritalStatusCollection = nationalIdHasMaritalStatusCollection;
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
        if (!(object instanceof MaritalStatus)) {
            return false;
        }
        MaritalStatus other = (MaritalStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MaritalStatus[ id=" + id + " ]";
    }
    
}
