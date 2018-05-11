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
 * @author ahmed.elemam
 */
@Entity
@Table(name = "terminal", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t"),
    @NamedQuery(name = "Terminal.findById", query = "SELECT t FROM Terminal t WHERE t.id = :id"),
    @NamedQuery(name = "Terminal.findByTid", query = "SELECT t FROM Terminal t WHERE t.tid = :tid"),
    @NamedQuery(name = "Terminal.findByOwnerName", query = "SELECT t FROM Terminal t WHERE t.ownerName = :ownerName"),
    @NamedQuery(name = "Terminal.findByMerchantName", query = "SELECT t FROM Terminal t WHERE t.merchantName = :merchantName"),
    @NamedQuery(name = "Terminal.findByShopName", query = "SELECT t FROM Terminal t WHERE t.shopName = :shopName"),
    @NamedQuery(name = "Terminal.findByAddress", query = "SELECT t FROM Terminal t WHERE t.address = :address"),
    @NamedQuery(name = "Terminal.findByContactperson", query = "SELECT t FROM Terminal t WHERE t.contactperson = :contactperson"),
    @NamedQuery(name = "Terminal.findByTelNo", query = "SELECT t FROM Terminal t WHERE t.telNo = :telNo"),
    @NamedQuery(name = "Terminal.findByOfficeContact", query = "SELECT t FROM Terminal t WHERE t.officeContact = :officeContact"),
    @NamedQuery(name = "Terminal.findByOfficeTelNo", query = "SELECT t FROM Terminal t WHERE t.officeTelNo = :officeTelNo"),
    @NamedQuery(name = "Terminal.findByPOSSerialNo", query = "SELECT t FROM Terminal t WHERE t.pOSSerialNo = :pOSSerialNo"),
    @NamedQuery(name = "Terminal.findByCreateDate", query = "SELECT t FROM Terminal t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "Terminal.findByUpdateDate", query = "SELECT t FROM Terminal t WHERE t.updateDate = :updateDate")})
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TID", nullable = false, length = 50)
    private String tid;
    @Size(max = 500)
    @Column(name = "Owner_Name", length = 500)
    private String ownerName;
    @Size(max = 500)
    @Column(name = "Merchant_Name", length = 500)
    private String merchantName;
    @Size(max = 500)
    @Column(name = "Shop_Name", length = 500)
    private String shopName;
    @Size(max = 500)
    @Column(name = "Address", length = 500)
    private String address;
    @Size(max = 500)
    @Column(name = "Contact_person", length = 500)
    private String contactperson;
    @Size(max = 50)
    @Column(name = "Tel_No", length = 50)
    private String telNo;
    @Size(max = 45)
    @Column(name = "officeContact", length = 45)
    private String officeContact;
    @Size(max = 45)
    @Column(name = "officeTelNo", length = 45)
    private String officeTelNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "POS_SerialNo", nullable = false, length = 500)
    private String pOSSerialNo;
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
    @JoinColumn(name = "Terminal_template_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TerminalTemplate terminaltemplateID;

    public Terminal() {
    }

    public Terminal(Integer id) {
        this.id = id;
    }

    public Terminal(Integer id, String tid, String pOSSerialNo, Date createDate, Date updateDate) {
        this.id = id;
        this.tid = tid;
        this.pOSSerialNo = pOSSerialNo;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getOfficeContact() {
        return officeContact;
    }

    public void setOfficeContact(String officeContact) {
        this.officeContact = officeContact;
    }

    public String getOfficeTelNo() {
        return officeTelNo;
    }

    public void setOfficeTelNo(String officeTelNo) {
        this.officeTelNo = officeTelNo;
    }

    public String getPOSSerialNo() {
        return pOSSerialNo;
    }

    public void setPOSSerialNo(String pOSSerialNo) {
        this.pOSSerialNo = pOSSerialNo;
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

    public TerminalTemplate getTerminaltemplateID() {
        return terminaltemplateID;
    }

    public void setTerminaltemplateID(TerminalTemplate terminaltemplateID) {
        this.terminaltemplateID = terminaltemplateID;
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
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Terminal[ id=" + id + " ]";
    }
    
}
