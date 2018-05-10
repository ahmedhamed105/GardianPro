/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "parts", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parts.findAll", query = "SELECT p FROM Parts p"),
    @NamedQuery(name = "Parts.findById", query = "SELECT p FROM Parts p WHERE p.id = :id"),
    @NamedQuery(name = "Parts.findByPName", query = "SELECT p FROM Parts p WHERE p.pName = :pName"),
    @NamedQuery(name = "Parts.findByPdesc", query = "SELECT p FROM Parts p WHERE p.pdesc = :pdesc")})
public class Parts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "PName", nullable = false, length = 150)
    private String pName;
    @Size(max = 150)
    @Column(name = "Pdesc", length = 150)
    private String pdesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partsID")
    private Collection<TerminalHasParts> terminalHasPartsCollection;

    public Parts() {
    }

    public Parts(Integer id) {
        this.id = id;
    }

    public Parts(Integer id, String pName) {
        this.id = id;
        this.pName = pName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @XmlTransient
    public Collection<TerminalHasParts> getTerminalHasPartsCollection() {
        return terminalHasPartsCollection;
    }

    public void setTerminalHasPartsCollection(Collection<TerminalHasParts> terminalHasPartsCollection) {
        this.terminalHasPartsCollection = terminalHasPartsCollection;
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
        if (!(object instanceof Parts)) {
            return false;
        }
        Parts other = (Parts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Parts[ id=" + id + " ]";
    }
    
}
