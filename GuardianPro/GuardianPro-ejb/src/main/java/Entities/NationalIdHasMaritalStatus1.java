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
@Table(name = "national_id_has_marital_status1", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NationalIdHasMaritalStatus1.findAll", query = "SELECT n FROM NationalIdHasMaritalStatus1 n"),
    @NamedQuery(name = "NationalIdHasMaritalStatus1.findByNationalIDID", query = "SELECT n FROM NationalIdHasMaritalStatus1 n WHERE n.nationalIdHasMaritalStatus1PK.nationalIDID = :nationalIDID"),
    @NamedQuery(name = "NationalIdHasMaritalStatus1.findByMaritalstatusID", query = "SELECT n FROM NationalIdHasMaritalStatus1 n WHERE n.nationalIdHasMaritalStatus1PK.maritalstatusID = :maritalstatusID"),
    @NamedQuery(name = "NationalIdHasMaritalStatus1.findByNoChildern", query = "SELECT n FROM NationalIdHasMaritalStatus1 n WHERE n.noChildern = :noChildern"),
    @NamedQuery(name = "NationalIdHasMaritalStatus1.findByWifename", query = "SELECT n FROM NationalIdHasMaritalStatus1 n WHERE n.wifename = :wifename"),
    @NamedQuery(name = "NationalIdHasMaritalStatus1.findByCreateDate", query = "SELECT n FROM NationalIdHasMaritalStatus1 n WHERE n.createDate = :createDate"),
    @NamedQuery(name = "NationalIdHasMaritalStatus1.findByUpdateDate", query = "SELECT n FROM NationalIdHasMaritalStatus1 n WHERE n.updateDate = :updateDate")})
public class NationalIdHasMaritalStatus1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NationalIdHasMaritalStatus1PK nationalIdHasMaritalStatus1PK;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nationalIdHasMaritalStatus1")
    private Collection<NationalIdHasMaritalStatusHasAddress> nationalIdHasMaritalStatusHasAddressCollection;

    public NationalIdHasMaritalStatus1() {
    }

    public NationalIdHasMaritalStatus1(NationalIdHasMaritalStatus1PK nationalIdHasMaritalStatus1PK) {
        this.nationalIdHasMaritalStatus1PK = nationalIdHasMaritalStatus1PK;
    }

    public NationalIdHasMaritalStatus1(NationalIdHasMaritalStatus1PK nationalIdHasMaritalStatus1PK, Date createDate, Date updateDate) {
        this.nationalIdHasMaritalStatus1PK = nationalIdHasMaritalStatus1PK;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public NationalIdHasMaritalStatus1(int nationalIDID, int maritalstatusID) {
        this.nationalIdHasMaritalStatus1PK = new NationalIdHasMaritalStatus1PK(nationalIDID, maritalstatusID);
    }

    public NationalIdHasMaritalStatus1PK getNationalIdHasMaritalStatus1PK() {
        return nationalIdHasMaritalStatus1PK;
    }

    public void setNationalIdHasMaritalStatus1PK(NationalIdHasMaritalStatus1PK nationalIdHasMaritalStatus1PK) {
        this.nationalIdHasMaritalStatus1PK = nationalIdHasMaritalStatus1PK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nationalIdHasMaritalStatus1PK != null ? nationalIdHasMaritalStatus1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NationalIdHasMaritalStatus1)) {
            return false;
        }
        NationalIdHasMaritalStatus1 other = (NationalIdHasMaritalStatus1) object;
        if ((this.nationalIdHasMaritalStatus1PK == null && other.nationalIdHasMaritalStatus1PK != null) || (this.nationalIdHasMaritalStatus1PK != null && !this.nationalIdHasMaritalStatus1PK.equals(other.nationalIdHasMaritalStatus1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NationalIdHasMaritalStatus1[ nationalIdHasMaritalStatus1PK=" + nationalIdHasMaritalStatus1PK + " ]";
    }
    
}
