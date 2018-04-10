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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "user", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "User.findByMiddlename", query = "SELECT u FROM User u WHERE u.middlename = :middlename")
    , @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "First_Name", nullable = false, length = 45)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Middle_name", nullable = false, length = 45)
    private String middlename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Last_name", nullable = false, length = 45)
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Username", nullable = false, length = 45)
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 300)
    @Column(name = "Email", length = 300)
    private String email;
    @JoinTable(name = "website_data_has_user", joinColumns = {
        @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "Website_Data_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
    private Collection<WebsiteData> websiteDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<SocialData> socialDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<LoginWay> loginWayCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<PhoneData> phoneDataCollection;
    @JoinColumn(name = "Birth_Data_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private BirthData birthDataID;
    @JoinColumn(name = "National_ID_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private NationalId nationalIDID;
    @JoinColumn(name = "Profile_Data_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ProfileData profileDataID;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstName, String middlename, String lastname, String username) {
        this.id = id;
        this.firstName = firstName;
        this.middlename = middlename;
        this.lastname = lastname;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<WebsiteData> getWebsiteDataCollection() {
        return websiteDataCollection;
    }

    public void setWebsiteDataCollection(Collection<WebsiteData> websiteDataCollection) {
        this.websiteDataCollection = websiteDataCollection;
    }

    @XmlTransient
    public Collection<SocialData> getSocialDataCollection() {
        return socialDataCollection;
    }

    public void setSocialDataCollection(Collection<SocialData> socialDataCollection) {
        this.socialDataCollection = socialDataCollection;
    }

    @XmlTransient
    public Collection<LoginWay> getLoginWayCollection() {
        return loginWayCollection;
    }

    public void setLoginWayCollection(Collection<LoginWay> loginWayCollection) {
        this.loginWayCollection = loginWayCollection;
    }

    @XmlTransient
    public Collection<PhoneData> getPhoneDataCollection() {
        return phoneDataCollection;
    }

    public void setPhoneDataCollection(Collection<PhoneData> phoneDataCollection) {
        this.phoneDataCollection = phoneDataCollection;
    }

    public BirthData getBirthDataID() {
        return birthDataID;
    }

    public void setBirthDataID(BirthData birthDataID) {
        this.birthDataID = birthDataID;
    }

    public NationalId getNationalIDID() {
        return nationalIDID;
    }

    public void setNationalIDID(NationalId nationalIDID) {
        this.nationalIDID = nationalIDID;
    }

    public ProfileData getProfileDataID() {
        return profileDataID;
    }

    public void setProfileDataID(ProfileData profileDataID) {
        this.profileDataID = profileDataID;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.User[ id=" + id + " ]";
    }
    
}
