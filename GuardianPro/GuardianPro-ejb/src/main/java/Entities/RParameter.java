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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "r_parameter", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RParameter.findAll", query = "SELECT r FROM RParameter r"),
    @NamedQuery(name = "RParameter.findById", query = "SELECT r FROM RParameter r WHERE r.id = :id"),
    @NamedQuery(name = "RParameter.findByreport", query = "SELECT r FROM RParameter r WHERE r.reportsID = :id"),
    @NamedQuery(name = "RParameter.findByRpara", query = "SELECT r FROM RParameter r WHERE r.rpara = :rpara"),
    @NamedQuery(name = "RParameter.findByParavalue", query = "SELECT r FROM RParameter r WHERE r.paravalue = :paravalue"),
    @NamedQuery(name = "RParameter.findByCreateDate", query = "SELECT r FROM RParameter r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "RParameter.findByUpdateDate", query = "SELECT r FROM RParameter r WHERE r.updateDate = :updateDate")})
public class RParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "R_para", nullable = false, length = 500)
    private String rpara;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Para_value", nullable = false, length = 500)
    private String paravalue;
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
    @JoinColumn(name = "Reports_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Reports reportsID;

    public RParameter() {
    }

    public RParameter(Integer id) {
        this.id = id;
    }

    public RParameter(Integer id, String rpara, String paravalue, Date createDate, Date updateDate) {
        this.id = id;
        this.rpara = rpara;
        this.paravalue = paravalue;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRpara() {
        return rpara;
    }

    public void setRpara(String rpara) {
        this.rpara = rpara;
    }

    public String getParavalue() {
        return paravalue;
    }

    public void setParavalue(String paravalue) {
        this.paravalue = paravalue;
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

    public Reports getReportsID() {
        return reportsID;
    }

    public void setReportsID(Reports reportsID) {
        this.reportsID = reportsID;
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
        if (!(object instanceof RParameter)) {
            return false;
        }
        RParameter other = (RParameter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RParameter[ id=" + id + " ]";
    }
    
}
