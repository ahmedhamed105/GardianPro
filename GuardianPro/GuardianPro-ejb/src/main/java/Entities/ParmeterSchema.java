/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "parmeter_schema", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParmeterSchema.findAll", query = "SELECT p FROM ParmeterSchema p"),
    @NamedQuery(name = "ParmeterSchema.findById", query = "SELECT p FROM ParmeterSchema p WHERE p.id = :id"),
    @NamedQuery(name = "ParmeterSchema.findByTerminalID", query = "SELECT p FROM ParmeterSchema p WHERE p.terminalID = :terminalID"),
    @NamedQuery(name = "ParmeterSchema.findByAcquirerID", query = "SELECT p FROM ParmeterSchema p WHERE p.acquirerID = :acquirerID"),
    @NamedQuery(name = "ParmeterSchema.findByIssuerID", query = "SELECT p FROM ParmeterSchema p WHERE p.issuerID = :issuerID"),
    @NamedQuery(name = "ParmeterSchema.findByCardRangeID", query = "SELECT p FROM ParmeterSchema p WHERE p.cardRangeID = :cardRangeID")})
public class ParmeterSchema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Terminal_ID", nullable = false, length = 45)
    private String terminalID;
    @Size(max = 45)
    @Column(name = "Acquirer_ID", length = 45)
    private String acquirerID;
    @Size(max = 45)
    @Column(name = "Issuer_ID", length = 45)
    private String issuerID;
    @Size(max = 45)
    @Column(name = "CardRange_ID", length = 45)
    private String cardRangeID;

    public ParmeterSchema() {
    }

    public ParmeterSchema(Integer id) {
        this.id = id;
    }

    public ParmeterSchema(Integer id, String terminalID) {
        this.id = id;
        this.terminalID = terminalID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getAcquirerID() {
        return acquirerID;
    }

    public void setAcquirerID(String acquirerID) {
        this.acquirerID = acquirerID;
    }

    public String getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(String issuerID) {
        this.issuerID = issuerID;
    }

    public String getCardRangeID() {
        return cardRangeID;
    }

    public void setCardRangeID(String cardRangeID) {
        this.cardRangeID = cardRangeID;
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
        if (!(object instanceof ParmeterSchema)) {
            return false;
        }
        ParmeterSchema other = (ParmeterSchema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ParmeterSchema[ id=" + id + " ]";
    }
    
}
