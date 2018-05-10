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
@Table(name = "terminal_has_parts", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerminalHasParts.findAll", query = "SELECT t FROM TerminalHasParts t"),
    @NamedQuery(name = "TerminalHasParts.findById", query = "SELECT t FROM TerminalHasParts t WHERE t.id = :id")})
public class TerminalHasParts implements Serializable {

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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @JoinColumn(name = "Download_method_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private DownloadMethod downloadmethodID;
    @JoinColumn(name = "Terminal_template_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TerminalTemplate terminaltemplateID;
    @JoinColumn(name = "Parts_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Parts partsID;

    public TerminalHasParts() {
    }

    public TerminalHasParts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DownloadMethod getDownloadmethodID() {
        return downloadmethodID;
    }

    public void setDownloadmethodID(DownloadMethod downloadmethodID) {
        this.downloadmethodID = downloadmethodID;
    }

    public TerminalTemplate getTerminaltemplateID() {
        return terminaltemplateID;
    }

    public void setTerminaltemplateID(TerminalTemplate terminaltemplateID) {
        this.terminaltemplateID = terminaltemplateID;
    }

    public Parts getPartsID() {
        return partsID;
    }

    public void setPartsID(Parts partsID) {
        this.partsID = partsID;
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
        if (!(object instanceof TerminalHasParts)) {
            return false;
        }
        TerminalHasParts other = (TerminalHasParts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TerminalHasParts[ id=" + id + " ]";
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
    
}
