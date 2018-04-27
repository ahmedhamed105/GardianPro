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
public class NationalIdHasMaritalStatusHasAddressPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "National_ID_has_Marital_status_National_ID_ID", nullable = false)
    private int nationalIDhasMaritalstatusNationalIDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "National_ID_has_Marital_status_Marital_status_ID", nullable = false)
    private int nationalIDhasMaritalstatusMaritalstatusID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Address_ID", nullable = false)
    private int addressID;

    public NationalIdHasMaritalStatusHasAddressPK() {
    }

    public NationalIdHasMaritalStatusHasAddressPK(int nationalIDhasMaritalstatusNationalIDID, int nationalIDhasMaritalstatusMaritalstatusID, int addressID) {
        this.nationalIDhasMaritalstatusNationalIDID = nationalIDhasMaritalstatusNationalIDID;
        this.nationalIDhasMaritalstatusMaritalstatusID = nationalIDhasMaritalstatusMaritalstatusID;
        this.addressID = addressID;
    }

    public int getNationalIDhasMaritalstatusNationalIDID() {
        return nationalIDhasMaritalstatusNationalIDID;
    }

    public void setNationalIDhasMaritalstatusNationalIDID(int nationalIDhasMaritalstatusNationalIDID) {
        this.nationalIDhasMaritalstatusNationalIDID = nationalIDhasMaritalstatusNationalIDID;
    }

    public int getNationalIDhasMaritalstatusMaritalstatusID() {
        return nationalIDhasMaritalstatusMaritalstatusID;
    }

    public void setNationalIDhasMaritalstatusMaritalstatusID(int nationalIDhasMaritalstatusMaritalstatusID) {
        this.nationalIDhasMaritalstatusMaritalstatusID = nationalIDhasMaritalstatusMaritalstatusID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nationalIDhasMaritalstatusNationalIDID;
        hash += (int) nationalIDhasMaritalstatusMaritalstatusID;
        hash += (int) addressID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NationalIdHasMaritalStatusHasAddressPK)) {
            return false;
        }
        NationalIdHasMaritalStatusHasAddressPK other = (NationalIdHasMaritalStatusHasAddressPK) object;
        if (this.nationalIDhasMaritalstatusNationalIDID != other.nationalIDhasMaritalstatusNationalIDID) {
            return false;
        }
        if (this.nationalIDhasMaritalstatusMaritalstatusID != other.nationalIDhasMaritalstatusMaritalstatusID) {
            return false;
        }
        if (this.addressID != other.addressID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NationalIdHasMaritalStatusHasAddressPK[ nationalIDhasMaritalstatusNationalIDID=" + nationalIDhasMaritalstatusNationalIDID + ", nationalIDhasMaritalstatusMaritalstatusID=" + nationalIDhasMaritalstatusMaritalstatusID + ", addressID=" + addressID + " ]";
    }
    
}
