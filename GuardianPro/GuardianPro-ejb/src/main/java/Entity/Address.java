/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "address", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByStreetno", query = "SELECT a FROM Address a WHERE a.streetno = :streetno")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "Street_no")
    private Integer streetno;
    @JoinTable(name = "national_id_has_marital_status_has_address", joinColumns = {
        @JoinColumn(name = "Address_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "National_ID_has_Marital_status_National_ID_ID", referencedColumnName = "National_ID_ID", nullable = false)
        , @JoinColumn(name = "National_ID_has_Marital_status_Marital_status_ID", referencedColumnName = "Marital_status_ID", nullable = false)})
    @ManyToMany
    private Collection<NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;
    @JoinColumn(name = "Near_places_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private NearPlaces nearplacesID;
    @JoinColumn(name = "Street_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Street streetID;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStreetno() {
        return streetno;
    }

    public void setStreetno(Integer streetno) {
        this.streetno = streetno;
    }

    @XmlTransient
    public Collection<NationalIdHasMaritalStatus> getNationalIdHasMaritalStatusCollection() {
        return nationalIdHasMaritalStatusCollection;
    }

    public void setNationalIdHasMaritalStatusCollection(Collection<NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection) {
        this.nationalIdHasMaritalStatusCollection = nationalIdHasMaritalStatusCollection;
    }

    public NearPlaces getNearplacesID() {
        return nearplacesID;
    }

    public void setNearplacesID(NearPlaces nearplacesID) {
        this.nearplacesID = nearplacesID;
    }

    public Street getStreetID() {
        return streetID;
    }

    public void setStreetID(Street streetID) {
        this.streetID = streetID;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Address[ id=" + id + " ]";
    }
    
}
