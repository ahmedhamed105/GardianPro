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
 * @author ahmed.elemam
 */
@Entity
@Table(name = "social_data", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialData.findAll", query = "SELECT s FROM SocialData s"),
    @NamedQuery(name = "SocialData.findById", query = "SELECT s FROM SocialData s WHERE s.socialDataPK.id = :id"),
    @NamedQuery(name = "SocialData.findByFacebookURL", query = "SELECT s FROM SocialData s WHERE s.facebookURL = :facebookURL"),
    @NamedQuery(name = "SocialData.findByUserID", query = "SELECT s FROM SocialData s WHERE s.socialDataPK.userID = :userID"),
    @NamedQuery(name = "SocialData.findByCreateDate", query = "SELECT s FROM SocialData s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SocialData.findByUpdateDate", query = "SELECT s FROM SocialData s WHERE s.updateDate = :updateDate")})
public class SocialData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SocialDataPK socialDataPK;
    @Size(max = 45)
    @Column(name = "facebook_URL", length = 45)
    private String facebookURL;
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
    @JoinColumn(name = "Social_type_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private SocialType socialtypeID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public SocialData() {
    }

    public SocialData(SocialDataPK socialDataPK) {
        this.socialDataPK = socialDataPK;
    }

    public SocialData(SocialDataPK socialDataPK, Date createDate, Date updateDate) {
        this.socialDataPK = socialDataPK;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public SocialData(int id, int userID) {
        this.socialDataPK = new SocialDataPK(id, userID);
    }

    public SocialDataPK getSocialDataPK() {
        return socialDataPK;
    }

    public void setSocialDataPK(SocialDataPK socialDataPK) {
        this.socialDataPK = socialDataPK;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
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

    public SocialType getSocialtypeID() {
        return socialtypeID;
    }

    public void setSocialtypeID(SocialType socialtypeID) {
        this.socialtypeID = socialtypeID;
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
        hash += (socialDataPK != null ? socialDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocialData)) {
            return false;
        }
        SocialData other = (SocialData) object;
        if ((this.socialDataPK == null && other.socialDataPK != null) || (this.socialDataPK != null && !this.socialDataPK.equals(other.socialDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SocialData[ socialDataPK=" + socialDataPK + " ]";
    }
    
}
