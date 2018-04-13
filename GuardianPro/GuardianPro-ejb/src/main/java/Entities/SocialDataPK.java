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
 * @author ahmed.elemam
 */
@Embeddable
public class SocialDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_ID", nullable = false)
    private int userID;

    public SocialDataPK() {
    }

    public SocialDataPK(int id, int userID) {
        this.id = id;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        hash += (int) id;
        hash += (int) userID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocialDataPK)) {
            return false;
        }
        SocialDataPK other = (SocialDataPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SocialDataPK[ id=" + id + ", userID=" + userID + " ]";
    }
    
}
