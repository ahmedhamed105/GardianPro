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
@Table(name = "profile_data", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfileData.findAll", query = "SELECT p FROM ProfileData p")
    , @NamedQuery(name = "ProfileData.findById", query = "SELECT p FROM ProfileData p WHERE p.id = :id")
    , @NamedQuery(name = "ProfileData.findByPicturepath", query = "SELECT p FROM ProfileData p WHERE p.picturepath = :picturepath")
    , @NamedQuery(name = "ProfileData.findByCoverimage", query = "SELECT p FROM ProfileData p WHERE p.coverimage = :coverimage")
    , @NamedQuery(name = "ProfileData.findByNickname", query = "SELECT p FROM ProfileData p WHERE p.nickname = :nickname")})
public class ProfileData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 300)
    @Column(name = "Picture_path", length = 300)
    private String picturepath;
    @Size(max = 45)
    @Column(name = "Cover_image", length = 45)
    private String coverimage;
    @Size(max = 45)
    @Column(name = "Nick_name", length = 45)
    private String nickname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileDataID")
    private Collection<User> userCollection;

    public ProfileData() {
    }

    public ProfileData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        if (!(object instanceof ProfileData)) {
            return false;
        }
        ProfileData other = (ProfileData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProfileData[ id=" + id + " ]";
    }
    
}
