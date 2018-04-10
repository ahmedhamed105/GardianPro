/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ahmed.ibraheem
 */
@Embeddable
public class WebsiteDataHasUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Website_Data_ID", nullable = false)
    private int websiteDataID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_ID", nullable = false)
    private int userID;

    public WebsiteDataHasUserPK() {
    }

    public WebsiteDataHasUserPK(int websiteDataID, int userID) {
        this.websiteDataID = websiteDataID;
        this.userID = userID;
    }

    public int getWebsiteDataID() {
        return websiteDataID;
    }

    public void setWebsiteDataID(int websiteDataID) {
        this.websiteDataID = websiteDataID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) websiteDataID;
        hash += (int) userID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebsiteDataHasUserPK)) {
            return false;
        }
        WebsiteDataHasUserPK other = (WebsiteDataHasUserPK) object;
        if (this.websiteDataID != other.websiteDataID) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.WebsiteDataHasUserPK[ websiteDataID=" + websiteDataID + ", userID=" + userID + " ]";
    }
    
}
