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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "street", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Street.findAll", query = "SELECT s FROM Street s")
    , @NamedQuery(name = "Street.findById", query = "SELECT s FROM Street s WHERE s.id = :id")
    , @NamedQuery(name = "Street.findByStreetname", query = "SELECT s FROM Street s WHERE s.streetname = :streetname")})
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Street_name", nullable = false, length = 150)
    private String streetname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "streetID")
    private Collection<Address> addressCollection;
    @JoinColumn(name = "Distinct_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private District distinctID;

    public Street() {
    }

    public Street(Integer id) {
        this.id = id;
    }

    public Street(Integer id, String streetname) {
        this.id = id;
        this.streetname = streetname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    public District getDistinctID() {
        return distinctID;
    }

    public void setDistinctID(District distinctID) {
        this.distinctID = distinctID;
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
        if (!(object instanceof Street)) {
            return false;
        }
        Street other = (Street) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Street[ id=" + id + " ]";
    }
    
}
