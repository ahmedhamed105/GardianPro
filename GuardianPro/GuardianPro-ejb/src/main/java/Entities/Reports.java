/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "reports", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reports.findAll", query = "SELECT r FROM Reports r"),
    @NamedQuery(name = "Reports.findById", query = "SELECT r FROM Reports r WHERE r.id = :id"),
    @NamedQuery(name = "Reports.findByReportDIR", query = "SELECT r FROM Reports r WHERE r.reportDIR = :reportDIR"),
    @NamedQuery(name = "Reports.findByReportname", query = "SELECT r FROM Reports r WHERE r.reportname = :reportname"),
    @NamedQuery(name = "Reports.findByReportSQL", query = "SELECT r FROM Reports r WHERE r.reportSQL = :reportSQL"),
    @NamedQuery(name = "Reports.findByCreateDate", query = "SELECT r FROM Reports r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "Reports.findByUpdateDate", query = "SELECT r FROM Reports r WHERE r.updateDate = :updateDate")})
public class Reports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Report_DIR", nullable = false, length = 500)
    private String reportDIR;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Report_name", nullable = false, length = 45)
    private String reportname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "Report_SQL", nullable = false, length = 10000)
    private String reportSQL;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportsID")
    private Collection<RParameter> rParameterCollection;

    public Reports() {
    }

    public Reports(Integer id) {
        this.id = id;
    }

    public Reports(Integer id, String reportDIR, String reportname, String reportSQL, Date createDate, Date updateDate) {
        this.id = id;
        this.reportDIR = reportDIR;
        this.reportname = reportname;
        this.reportSQL = reportSQL;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportDIR() {
        return reportDIR;
    }

    public void setReportDIR(String reportDIR) {
        this.reportDIR = reportDIR;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public String getReportSQL() {
        return reportSQL;
    }

    public void setReportSQL(String reportSQL) {
        this.reportSQL = reportSQL;
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

    @XmlTransient
    public Collection<RParameter> getRParameterCollection() {
        return rParameterCollection;
    }

    public void setRParameterCollection(Collection<RParameter> rParameterCollection) {
        this.rParameterCollection = rParameterCollection;
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
        if (!(object instanceof Reports)) {
            return false;
        }
        Reports other = (Reports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Reports[ id=" + id + " ]";
    }
    
}
