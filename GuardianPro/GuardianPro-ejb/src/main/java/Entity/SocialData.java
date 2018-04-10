/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "social_data", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialData.findAll", query = "SELECT s FROM SocialData s")
    , @NamedQuery(name = "SocialData.findById", query = "SELECT s FROM SocialData s WHERE s.socialDataPK.id = :id")
    , @NamedQuery(name = "SocialData.findByFacebookURL", query = "SELECT s FROM SocialData s WHERE s.facebookURL = :facebookURL")
    , @NamedQuery(name = "SocialData.findByUserID", query = "SELECT s FROM SocialData s WHERE s.socialDataPK.userID = :userID")})
public class SocialData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SocialDataPK socialDataPK;
    @Size(max = 300)
    @Column(name = "facebook_URL", length = 300)
    private String facebookURL;
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
        return "Entity.SocialData[ socialDataPK=" + socialDataPK + " ]";
    }
    
}
