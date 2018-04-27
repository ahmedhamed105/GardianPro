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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "national_id_has_marital_status_has_address", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NationalIdHasMaritalStatusHasAddress.findAll", query = "SELECT n FROM NationalIdHasMaritalStatusHasAddress n"),
    @NamedQuery(name = "NationalIdHasMaritalStatusHasAddress.findByNationalIDhasMaritalstatusNationalIDID", query = "SELECT n FROM NationalIdHasMaritalStatusHasAddress n WHERE n.nationalIdHasMaritalStatusHasAddressPK.nationalIDhasMaritalstatusNationalIDID = :nationalIDhasMaritalstatusNationalIDID"),
    @NamedQuery(name = "NationalIdHasMaritalStatusHasAddress.findByNationalIDhasMaritalstatusMaritalstatusID", query = "SELECT n FROM NationalIdHasMaritalStatusHasAddress n WHERE n.nationalIdHasMaritalStatusHasAddressPK.nationalIDhasMaritalstatusMaritalstatusID = :nationalIDhasMaritalstatusMaritalstatusID"),
    @NamedQuery(name = "NationalIdHasMaritalStatusHasAddress.findByAddressID", query = "SELECT n FROM NationalIdHasMaritalStatusHasAddress n WHERE n.nationalIdHasMaritalStatusHasAddressPK.addressID = :addressID"),
    @NamedQuery(name = "NationalIdHasMaritalStatusHasAddress.findByCreateDate", query = "SELECT n FROM NationalIdHasMaritalStatusHasAddress n WHERE n.createDate = :createDate"),
    @NamedQuery(name = "NationalIdHasMaritalStatusHasAddress.findByUpdateDate", query = "SELECT n FROM NationalIdHasMaritalStatusHasAddress n WHERE n.updateDate = :updateDate")})
public class NationalIdHasMaritalStatusHasAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NationalIdHasMaritalStatusHasAddressPK nationalIdHasMaritalStatusHasAddressPK;
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
    @JoinColumns({
        @JoinColumn(name = "National_ID_has_Marital_status_National_ID_ID", referencedColumnName = "National_ID_ID", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "National_ID_has_Marital_status_Marital_status_ID", referencedColumnName = "Marital_status_ID", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private NationalIdHasMaritalStatus1 nationalIdHasMaritalStatus1;

    public NationalIdHasMaritalStatusHasAddress() {
    }

    public NationalIdHasMaritalStatusHasAddress(NationalIdHasMaritalStatusHasAddressPK nationalIdHasMaritalStatusHasAddressPK) {
        this.nationalIdHasMaritalStatusHasAddressPK = nationalIdHasMaritalStatusHasAddressPK;
    }

    public NationalIdHasMaritalStatusHasAddress(NationalIdHasMaritalStatusHasAddressPK nationalIdHasMaritalStatusHasAddressPK, Date createDate, Date updateDate) {
        this.nationalIdHasMaritalStatusHasAddressPK = nationalIdHasMaritalStatusHasAddressPK;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public NationalIdHasMaritalStatusHasAddress(int nationalIDhasMaritalstatusNationalIDID, int nationalIDhasMaritalstatusMaritalstatusID, int addressID) {
        this.nationalIdHasMaritalStatusHasAddressPK = new NationalIdHasMaritalStatusHasAddressPK(nationalIDhasMaritalstatusNationalIDID, nationalIDhasMaritalstatusMaritalstatusID, addressID);
    }

    public NationalIdHasMaritalStatusHasAddressPK getNationalIdHasMaritalStatusHasAddressPK() {
        return nationalIdHasMaritalStatusHasAddressPK;
    }

    public void setNationalIdHasMaritalStatusHasAddressPK(NationalIdHasMaritalStatusHasAddressPK nationalIdHasMaritalStatusHasAddressPK) {
        this.nationalIdHasMaritalStatusHasAddressPK = nationalIdHasMaritalStatusHasAddressPK;
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

    public NationalIdHasMaritalStatus1 getNationalIdHasMaritalStatus1() {
        return nationalIdHasMaritalStatus1;
    }

    public void setNationalIdHasMaritalStatus1(NationalIdHasMaritalStatus1 nationalIdHasMaritalStatus1) {
        this.nationalIdHasMaritalStatus1 = nationalIdHasMaritalStatus1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nationalIdHasMaritalStatusHasAddressPK != null ? nationalIdHasMaritalStatusHasAddressPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NationalIdHasMaritalStatusHasAddress)) {
            return false;
        }
        NationalIdHasMaritalStatusHasAddress other = (NationalIdHasMaritalStatusHasAddress) object;
        if ((this.nationalIdHasMaritalStatusHasAddressPK == null && other.nationalIdHasMaritalStatusHasAddressPK != null) || (this.nationalIdHasMaritalStatusHasAddressPK != null && !this.nationalIdHasMaritalStatusHasAddressPK.equals(other.nationalIdHasMaritalStatusHasAddressPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NationalIdHasMaritalStatusHasAddress[ nationalIdHasMaritalStatusHasAddressPK=" + nationalIdHasMaritalStatusHasAddressPK + " ]";
    }
    
}
