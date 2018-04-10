/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    , @NamedQuery(name = "NationalIdHasMaritalStatus.findByNationalIDhasMaritalstatuscol", query = "SELECT n FROM NationalIdHasMaritalStatus n WHERE n.nationalIDhasMaritalstatuscol = :nationalIDhasMaritalstatuscol")})
public class NationalIdHasMaritalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NationalIdHasMaritalStatusPK nationalIdHasMaritalStatusPK;
    @Size(max = 45)
    @Column(name = "no_Childern", length = 45)
    private String noChildern;
    @Size(max = 300)
    @Column(name = "Wife_name", length = 300)
    private String wifename;
    @Size(max = 300)
    @Column(name = "National_ID_has_Marital_statuscol", length = 300)
    private String nationalIDhasMaritalstatuscol;
    @ManyToMany(mappedBy = "nationalIdHasMaritalStatusCollection")
    private Collection<Address> addressCollection;
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

    public String getNationalIDhasMaritalstatuscol() {
        return nationalIDhasMaritalstatuscol;
    }

    public void setNationalIDhasMaritalstatuscol(String nationalIDhasMaritalstatuscol) {
        this.nationalIDhasMaritalstatuscol = nationalIDhasMaritalstatuscol;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
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
        return "Entity.NationalIdHasMaritalStatus[ nationalIdHasMaritalStatusPK=" + nationalIdHasMaritalStatusPK + " ]";
    }
    
}
