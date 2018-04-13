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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "website_data_has_user", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebsiteDataHasUser.findAll", query = "SELECT w FROM WebsiteDataHasUser w"),
    @NamedQuery(name = "WebsiteDataHasUser.findByWebsiteDataID", query = "SELECT w FROM WebsiteDataHasUser w WHERE w.websiteDataHasUserPK.websiteDataID = :websiteDataID"),
    @NamedQuery(name = "WebsiteDataHasUser.findByUserID", query = "SELECT w FROM WebsiteDataHasUser w WHERE w.websiteDataHasUserPK.userID = :userID"),
    @NamedQuery(name = "WebsiteDataHasUser.findByCreateDate", query = "SELECT w FROM WebsiteDataHasUser w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WebsiteDataHasUser.findByUpdateDate", query = "SELECT w FROM WebsiteDataHasUser w WHERE w.updateDate = :updateDate")})
public class WebsiteDataHasUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WebsiteDataHasUserPK websiteDataHasUserPK;
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
    @JoinColumn(name = "Website_Data_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebsiteData websiteData;

    public WebsiteDataHasUser() {
    }

    public WebsiteDataHasUser(WebsiteDataHasUserPK websiteDataHasUserPK) {
        this.websiteDataHasUserPK = websiteDataHasUserPK;
    }

    public WebsiteDataHasUser(WebsiteDataHasUserPK websiteDataHasUserPK, Date createDate, Date updateDate) {
        this.websiteDataHasUserPK = websiteDataHasUserPK;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public WebsiteDataHasUser(int websiteDataID, int userID) {
        this.websiteDataHasUserPK = new WebsiteDataHasUserPK(websiteDataID, userID);
    }

    public WebsiteDataHasUserPK getWebsiteDataHasUserPK() {
        return websiteDataHasUserPK;
    }

    public void setWebsiteDataHasUserPK(WebsiteDataHasUserPK websiteDataHasUserPK) {
        this.websiteDataHasUserPK = websiteDataHasUserPK;
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

    public WebsiteData getWebsiteData() {
        return websiteData;
    }

    public void setWebsiteData(WebsiteData websiteData) {
        this.websiteData = websiteData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (websiteDataHasUserPK != null ? websiteDataHasUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebsiteDataHasUser)) {
            return false;
        }
        WebsiteDataHasUser other = (WebsiteDataHasUser) object;
        if ((this.websiteDataHasUserPK == null && other.websiteDataHasUserPK != null) || (this.websiteDataHasUserPK != null && !this.websiteDataHasUserPK.equals(other.websiteDataHasUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.WebsiteDataHasUser[ websiteDataHasUserPK=" + websiteDataHasUserPK + " ]";
    }
    
}
