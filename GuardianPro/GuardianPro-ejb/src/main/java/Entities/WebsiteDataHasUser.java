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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "WebsiteDataHasUser.findById", query = "SELECT w FROM WebsiteDataHasUser w WHERE w.id = :id"),
    @NamedQuery(name = "WebsiteDataHasUser.findByCreateDate", query = "SELECT w FROM WebsiteDataHasUser w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "WebsiteDataHasUser.findByUpdateDate", query = "SELECT w FROM WebsiteDataHasUser w WHERE w.updateDate = :updateDate")})
public class WebsiteDataHasUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
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
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;
    @JoinColumn(name = "Website_Data_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private WebsiteData websiteDataID;

    public WebsiteDataHasUser() {
    }

    public WebsiteDataHasUser(Integer id) {
        this.id = id;
    }

    public WebsiteDataHasUser(Integer id, Date createDate, Date updateDate) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public WebsiteData getWebsiteDataID() {
        return websiteDataID;
    }

    public void setWebsiteDataID(WebsiteData websiteDataID) {
        this.websiteDataID = websiteDataID;
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
        if (!(object instanceof WebsiteDataHasUser)) {
            return false;
        }
        WebsiteDataHasUser other = (WebsiteDataHasUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.WebsiteDataHasUser[ id=" + id + " ]";
    }
    
}
