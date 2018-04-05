/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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
    , @NamedQuery(name = "PhoneTypes.findByTeleType", query = "SELECT p FROM PhoneTypes p WHERE p.teleType = :teleType")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phonetypesID")
    private Collection<PhoneData> phoneDataCollection;

    public PhoneTypes() {
    }

    public PhoneTypes(Integer id) {
        this.id = id;
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
        return "Entity.PhoneTypes[ id=" + id + " ]";
    }
    
}
