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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "national_id_has_marital_status", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NationalIdHasMaritalStatus.findAll", query = "SELECT n FROM NationalIdHasMaritalStatus n")
    , @NamedQuery(name = "NationalIdHasMaritalStatus.findByNationalIDID", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.nationalIdHasMaritalStatusPK.nationalIDID = :nationalIDID")
    , @NamedQuery(name = "NationalIdHasMaritalStatus.findByMaritalstatusID", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.nationalIdHasMaritalStatusPK.maritalstatusID = :maritalstatusID")
    , @NamedQuery(name = "NationalIdHasMaritalStatus.findByNoChildern", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.noChildern = :noChildern")
    , @NamedQuery(name = "NationalIdHasMaritalStatus.findByWifename", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.wifename = :wifename")
    , @NamedQuery(name = "NationalIdHasMaritalStatus.findByCreateDate", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.createDate = :createDate")
    , @NamedQuery(name = "NationalIdHasMaritalStatus.findByUpdateDate", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.updateDate = :updateDate")})
public class NationalIdHasMaritalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NationalIdHasMaritalStatusPK nationalIdHasMaritalStatusPK;
    @Size(max = 45)
    @Column(name = "no_Childern", length = 45)
    private String noChildern;
    @Size(max = 45)
    @Column(name = "Wife_name", length = 45)
    private String wifename;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nationalIdHasMaritalStatus")
    private Collection<NationalIdHasMaritalStatusHasAddress> nationalIdHasMaritalStatusHasAddressCollection;
    @JoinColumn(name = "Marital_status_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MaritalStatus maritalStatus;
    @JoinColumn(name = "National_ID_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NationalId nationalId;

    public NationalIdHasMaritalStatus() {
    }

    public NationalIdHasMaritalStatus(NationalIdHasMaritalStatusPK nationalIdHasMaritalStatusPK) {
        this.nationalIdHasMaritalStatusPK = nationalIdHasMaritalStatusPK;
    }

    public NationalIdHasMaritalStatus(NationalIdHasMaritalStatusPK nationalIdHasMaritalStatusPK, Date createDate, Date updateDate) {
        this.nationalIdHasMaritalStatusPK = nationalIdHasMaritalStatusPK;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public NationalIdHasMaritalStatus(int nationalIDID, int maritalstatusID) {
        this.nationalIdHasMaritalStatusPK = new NationalIdHasMaritalStatusPK(nationalIDID, maritalstatusID);
    }

    public NationalIdHasMaritalStatusPK getNationalIdHasMaritalStatusPK() {
        return nationalIdHasMaritalStatusPK;
    }

    public void setNationalIdHasMaritalStatusPK(NationalIdHasMaritalStatusPK nationalIdHasMaritalStatusPK) {
        this.nationalIdHasMaritalStatusPK = nationalIdHasMaritalStatusPK;
    }

    public String getNoChildern() {
        return noChildern;
    }

    public void setNoChildern(String noChildern) {
        this.noChildern = noChildern;
    }

    public String getWifename() {
        return wifename;
    }

    public void setWifename(String wifename) {
        this.wifename = wifename;
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
    public Collection<NationalIdHasMaritalStatusHasAddress> getNationalIdHasMaritalStatusHasAddressCollection() {
        return nationalIdHasMaritalStatusHasAddressCollection;
    }

    public void setNationalIdHasMaritalStatusHasAddressCollection(Collection<NationalIdHasMaritalStatusHasAddress> nationalIdHasMaritalStatusHasAddressCollection) {
        this.nationalIdHasMaritalStatusHasAddressCollection = nationalIdHasMaritalStatusHasAddressCollection;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public NationalId getNationalId() {
        return nationalId;
    }

    public void setNationalId(NationalId nationalId) {
        this.nationalId = nationalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nationalIdHasMaritalStatusPK != null ? nationalIdHasMaritalStatusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NationalIdHasMaritalStatus)) {
            return false;
        }
        NationalIdHasMaritalStatus other = (NationalIdHasMaritalStatus) object;
        if ((this.nationalIdHasMaritalStatusPK == null && other.nationalIdHasMaritalStatusPK != null) || (this.nationalIdHasMaritalStatusPK != null && !this.nationalIdHasMaritalStatusPK.equals(other.nationalIdHasMaritalStatusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NationalIdHasMaritalStatus[ nationalIdHasMaritalStatusPK=" + nationalIdHasMaritalStatusPK + " ]";
    }
    
}
