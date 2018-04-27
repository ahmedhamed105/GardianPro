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
@Table(name = "national_id_has_marital_status", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NationalIdHasMaritalStatus.findAll", query = "SELECT n FROM NationalIdHasMaritalStatus n"),
    @NamedQuery(name = "NationalIdHasMaritalStatus.findById", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.id = :id"),
    @NamedQuery(name = "NationalIdHasMaritalStatus.findByCreateDate", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.createDate = :createDate"),
    @NamedQuery(name = "NationalIdHasMaritalStatus.findByUpdateDate", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.updateDate = :updateDate"),
    @NamedQuery(name = "NationalIdHasMaritalStatus.findByNoChildern", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.noChildern = :noChildern"),
    @NamedQuery(name = "NationalIdHasMaritalStatus.findByWifename", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.wifename = :wifename")})
public class NationalIdHasMaritalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    @Size(max = 45)
    @Column(name = "no_Childern", length = 45)
    private String noChildern;
    @Size(max = 45)
    @Column(name = "Wife_name", length = 45)
    private String wifename;
    @JoinColumn(name = "Marital_status_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private MaritalStatus maritalstatusID;
    @JoinColumn(name = "National_ID_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private NationalId nationalIDID;

    public NationalIdHasMaritalStatus() {
    }

    public NationalIdHasMaritalStatus(Integer id) {
        this.id = id;
    }

    public NationalIdHasMaritalStatus(Integer id, Date createDate, Date updateDate) {
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

    public MaritalStatus getMaritalstatusID() {
        return maritalstatusID;
    }

    public void setMaritalstatusID(MaritalStatus maritalstatusID) {
        this.maritalstatusID = maritalstatusID;
    }

    public NationalId getNationalIDID() {
        return nationalIDID;
    }

    public void setNationalIDID(NationalId nationalIDID) {
        this.nationalIDID = nationalIDID;
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
        if (!(object instanceof NationalIdHasMaritalStatus)) {
            return false;
        }
        NationalIdHasMaritalStatus other = (NationalIdHasMaritalStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NationalIdHasMaritalStatus[ id=" + id + " ]";
    }
    
}
