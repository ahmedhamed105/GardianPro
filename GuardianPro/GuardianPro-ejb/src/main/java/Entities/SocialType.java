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
@Table(name = "social_type", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialType.findAll", query = "SELECT s FROM SocialType s"),
    @NamedQuery(name = "SocialType.findById", query = "SELECT s FROM SocialType s WHERE s.id = :id"),
    @NamedQuery(name = "SocialType.findBySoctype", query = "SELECT s FROM SocialType s WHERE s.soctype = :soctype"),
    @NamedQuery(name = "SocialType.findByCreateDate", query = "SELECT s FROM SocialType s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SocialType.findByUpdateDate", query = "SELECT s FROM SocialType s WHERE s.updateDate = :updateDate")})
public class SocialType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Soc_type", nullable = false, length = 45)
    private String soctype;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialtypeID")
    private Collection<SocialData> socialDataCollection;

    public SocialType() {
    }

    public SocialType(Integer id) {
        this.id = id;
    }

    public SocialType(Integer id, String soctype, Date createDate, Date updateDate) {
        this.id = id;
        this.soctype = soctype;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoctype() {
        return soctype;
    }

    public void setSoctype(String soctype) {
        this.soctype = soctype;
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
    public Collection<SocialData> getSocialDataCollection() {
        return socialDataCollection;
    }

    public void setSocialDataCollection(Collection<SocialData> socialDataCollection) {
        this.socialDataCollection = socialDataCollection;
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
        if (!(object instanceof SocialType)) {
            return false;
        }
        SocialType other = (SocialType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SocialType[ id=" + id + " ]";
    }
    
}
