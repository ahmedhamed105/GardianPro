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
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "profile_data", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfileData.findAll", query = "SELECT p FROM ProfileData p")
    , @NamedQuery(name = "ProfileData.findById", query = "SELECT p FROM ProfileData p WHERE p.profileDataPK.id = :id")
    , @NamedQuery(name = "ProfileData.findByPicturepath", query = "SELECT p FROM ProfileData p WHERE p.picturepath = :picturepath")
    , @NamedQuery(name = "ProfileData.findByCoverimage", query = "SELECT p FROM ProfileData p WHERE p.coverimage = :coverimage")
    , @NamedQuery(name = "ProfileData.findByNickname", query = "SELECT p FROM ProfileData p WHERE p.nickname = :nickname")
    , @NamedQuery(name = "ProfileData.findByCreateDate", query = "SELECT p FROM ProfileData p WHERE p.createDate = :createDate")
    , @NamedQuery(name = "ProfileData.findByUpdateDate", query = "SELECT p FROM ProfileData p WHERE p.updateDate = :updateDate")
    , @NamedQuery(name = "ProfileData.findByUserID", query = "SELECT p FROM ProfileData p WHERE p.profileDataPK.userID = :userID")})
public class ProfileData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfileDataPK profileDataPK;
    @Size(max = 300)
    @Column(name = "Picture_path", length = 300)
    private String picturepath;
    @Size(max = 45)
    @Column(name = "Cover_image", length = 45)
    private String coverimage;
    @Size(max = 45)
    @Column(name = "Nick_name", length = 45)
    private String nickname;
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
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public ProfileData() {
    }

    public ProfileData(ProfileDataPK profileDataPK) {
        this.profileDataPK = profileDataPK;
    }

    public ProfileData(ProfileDataPK profileDataPK, Date createDate, Date updateDate) {
        this.profileDataPK = profileDataPK;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public ProfileData(int id, int userID) {
        this.profileDataPK = new ProfileDataPK(id, userID);
    }

    public ProfileDataPK getProfileDataPK() {
        return profileDataPK;
    }

    public void setProfileDataPK(ProfileDataPK profileDataPK) {
        this.profileDataPK = profileDataPK;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileDataPK != null ? profileDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileData)) {
            return false;
        }
        ProfileData other = (ProfileData) object;
        if ((this.profileDataPK == null && other.profileDataPK != null) || (this.profileDataPK != null && !this.profileDataPK.equals(other.profileDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ProfileData[ profileDataPK=" + profileDataPK + " ]";
    }
    
}
