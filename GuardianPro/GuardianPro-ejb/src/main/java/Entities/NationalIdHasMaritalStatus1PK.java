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
public class NationalIdHasMaritalStatus1PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "National_ID_ID", nullable = false)
    private int nationalIDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marital_status_ID", nullable = false)
    private int maritalstatusID;

    public NationalIdHasMaritalStatus1PK() {
    }

    public NationalIdHasMaritalStatus1PK(int nationalIDID, int maritalstatusID) {
        this.nationalIDID = nationalIDID;
        this.maritalstatusID = maritalstatusID;
    }

    public int getNationalIDID() {
        return nationalIDID;
    }

    public void setNationalIDID(int nationalIDID) {
        this.nationalIDID = nationalIDID;
    }

    public int getMaritalstatusID() {
        return maritalstatusID;
    }

    public void setMaritalstatusID(int maritalstatusID) {
        this.maritalstatusID = maritalstatusID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nationalIDID;
        hash += (int) maritalstatusID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NationalIdHasMaritalStatus1PK)) {
            return false;
        }
        NationalIdHasMaritalStatus1PK other = (NationalIdHasMaritalStatus1PK) object;
        if (this.nationalIDID != other.nationalIDID) {
            return false;
        }
        if (this.maritalstatusID != other.maritalstatusID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NationalIdHasMaritalStatus1PK[ nationalIDID=" + nationalIDID + ", maritalstatusID=" + maritalstatusID + " ]";
    }
    
}
