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
@Table(name = "download_method", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DownloadMethod.findAll", query = "SELECT d FROM DownloadMethod d"),
    @NamedQuery(name = "DownloadMethod.findById", query = "SELECT d FROM DownloadMethod d WHERE d.id = :id"),
    @NamedQuery(name = "DownloadMethod.findByDName", query = "SELECT d FROM DownloadMethod d WHERE d.dName = :dName")})
public class DownloadMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DName", nullable = false, length = 150)
    private String dName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "downloadmethodID")
    private Collection<TerminalHasParts> terminalHasPartsCollection;

    public DownloadMethod() {
    }

    public DownloadMethod(Integer id) {
        this.id = id;
    }

    public DownloadMethod(Integer id, String dName) {
        this.id = id;
        this.dName = dName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
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
        if (!(object instanceof DownloadMethod)) {
            return false;
        }
        DownloadMethod other = (DownloadMethod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DownloadMethod[ id=" + id + " ]";
    }
    
}
