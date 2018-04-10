/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
@Table(name = "birth_data", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BirthData.findAll", query = "SELECT b FROM BirthData b")
    , @NamedQuery(name = "BirthData.findById", query = "SELECT b FROM BirthData b WHERE b.id = :id")
    , @NamedQuery(name = "BirthData.findByBirthDate", query = "SELECT b FROM BirthData b WHERE b.birthDate = :birthDate")
    , @NamedQuery(name = "BirthData.findByBirthCert", query = "SELECT b FROM BirthData b WHERE b.birthCert = :birthCert")
    , @NamedQuery(name = "BirthData.findByBirthplace", query = "SELECT b FROM BirthData b WHERE b.birthplace = :birthplace")})
public class BirthData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Birth_Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Size(max = 500)
    @Column(name = "Birth_Cert", length = 500)
    private String birthCert;
    @Size(max = 500)
    @Column(name = "Birth_place", length = 500)
    private String birthplace;
    @JoinColumn(name = "City_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private City cityID;
    @JoinColumn(name = "Country_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Country countryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "birthDataID")
    private Collection<User> userCollection;

    public BirthData() {
    }

    public BirthData(Integer id) {
        this.id = id;
    }

    public BirthData(Integer id, Date birthDate) {
        this.id = id;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCert() {
        return birthCert;
    }

    public void setBirthCert(String birthCert) {
        this.birthCert = birthCert;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    public Country getCountryID() {
        return countryID;
    }

    public void setCountryID(Country countryID) {
        this.countryID = countryID;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof BirthData)) {
            return false;
        }
        BirthData other = (BirthData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BirthData[ id=" + id + " ]";
    }
    
}
