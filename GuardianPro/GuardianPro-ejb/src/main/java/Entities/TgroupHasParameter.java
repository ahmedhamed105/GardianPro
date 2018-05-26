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
@Table(name = "tgroup_has_parameter", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TgroupHasParameter.findAll", query = "SELECT t FROM TgroupHasParameter t"),
    @NamedQuery(name = "TgroupHasParameter.findById", query = "SELECT t FROM TgroupHasParameter t WHERE t.id = :id"),
    @NamedQuery(name = "TgroupHasParameter.findByGroup", query = "SELECT t FROM TgroupHasParameter t WHERE t.terminalGroupID = :id"),
    @NamedQuery(name = "TgroupHasParameter.findByParmetervalue", query = "SELECT t FROM TgroupHasParameter t WHERE t.parmetervalue = :parmetervalue"),
    @NamedQuery(name = "TgroupHasParameter.findByParmeterdesc", query = "SELECT t FROM TgroupHasParameter t WHERE t.parmeterdesc = :parmeterdesc"),
    @NamedQuery(name = "TgroupHasParameter.findByCreateDate", query = "SELECT t FROM TgroupHasParameter t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TgroupHasParameter.findByUpdateDate", query = "SELECT t FROM TgroupHasParameter t WHERE t.updateDate = :updateDate")})
public class TgroupHasParameter implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tgrouphasparameterID")
    private Collection<Pgchildparent> pgchildparentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tgrouphasparameterID1")
    private Collection<Pgchildparent> pgchildparentCollection1;
    @JoinColumn(name = "Parmeter_schema_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ParmeterSchema parmeterschemaID;



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Parmeter_value", nullable = false, length = 500)
    private String parmetervalue;
    @Size(max = 500)
    @Column(name = "Parmeter_desc", length = 500)
    private String parmeterdesc;
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
    @JoinColumn(name = "Parameter_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Parameter parameterID;
    @JoinColumn(name = "Terminal_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TerminalGroup terminalGroupID;

    public TgroupHasParameter() {
    }

    public TgroupHasParameter(Integer id) {
        this.id = id;
    }

    public TgroupHasParameter(Integer id, String parmetervalue, Date createDate, Date updateDate) {
        this.id = id;
        this.parmetervalue = parmetervalue;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParmetervalue() {
        return parmetervalue;
    }

    public void setParmetervalue(String parmetervalue) {
        this.parmetervalue = parmetervalue;
    }

    public String getParmeterdesc() {
        return parmeterdesc;
    }

    public void setParmeterdesc(String parmeterdesc) {
        this.parmeterdesc = parmeterdesc;
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

    public Parameter getParameterID() {
        return parameterID;
    }

    public void setParameterID(Parameter parameterID) {
        this.parameterID = parameterID;
    }

    public TerminalGroup getTerminalGroupID() {
        return terminalGroupID;
    }

    public void setTerminalGroupID(TerminalGroup terminalGroupID) {
        this.terminalGroupID = terminalGroupID;
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
        if (!(object instanceof TgroupHasParameter)) {
            return false;
        }
        TgroupHasParameter other = (TgroupHasParameter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TgroupHasParameter[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Pgchildparent> getPgchildparentCollection() {
        return pgchildparentCollection;
    }

    public void setPgchildparentCollection(Collection<Pgchildparent> pgchildparentCollection) {
        this.pgchildparentCollection = pgchildparentCollection;
    }

    @XmlTransient
    public Collection<Pgchildparent> getPgchildparentCollection1() {
        return pgchildparentCollection1;
    }

    public void setPgchildparentCollection1(Collection<Pgchildparent> pgchildparentCollection1) {
        this.pgchildparentCollection1 = pgchildparentCollection1;
    }

    public ParmeterSchema getParmeterschemaID() {
        return parmeterschemaID;
    }

    public void setParmeterschemaID(ParmeterSchema parmeterschemaID) {
        this.parmeterschemaID = parmeterschemaID;
    }

   
    
}
