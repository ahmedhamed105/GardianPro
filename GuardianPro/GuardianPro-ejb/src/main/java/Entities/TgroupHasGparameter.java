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
@Table(name = "tgroup_has_gparameter", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TgroupHasGparameter.findAll", query = "SELECT t FROM TgroupHasGparameter t"),
    @NamedQuery(name = "TgroupHasGparameter.findById", query = "SELECT t FROM TgroupHasGparameter t WHERE t.id = :id"),
    @NamedQuery(name = "TgroupHasGparameter.findBytgroup", query = "SELECT t FROM TgroupHasGparameter t WHERE t.terminalGroupID = :id"),
      @NamedQuery(name = "TgroupHasGparameter.findBytgroupterm", query = "SELECT t FROM TgroupHasGparameter t WHERE t.terminalGroupID = :id and t.parameterGroupID = :id1"),
    @NamedQuery(name = "TgroupHasGparameter.findByCreateDate", query = "SELECT t FROM TgroupHasGparameter t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TgroupHasGparameter.findByUpdateDate", query = "SELECT t FROM TgroupHasGparameter t WHERE t.updateDate = :updateDate")})
public class TgroupHasGparameter implements Serializable {

    @Column(name = "file_length")
    private Integer fileLength;

    @Size(max = 450)
    @Column(name = "filename", length = 450)
    private String filename;

    @Basic(optional = false)
    @NotNull
    @Column(name = "XML_update", nullable = false)
    private int xMLupdate;

    @Column(name = "terminal_id")
    private Integer terminalId;
    @Column(name = "ACC_id")
    private Integer aCCid;
    @Column(name = "ISS_id")
    private Integer iSSid;
    @Column(name = "Card_id")
    private Integer cardid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tgrouphasGparameterID")
    private Collection<ParameterValues> parameterValuesCollection;

  

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
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
    @JoinColumn(name = "Parameter_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ParameterGroup parameterGroupID;
    @JoinColumn(name = "Terminal_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TerminalGroup terminalGroupID;

    public TgroupHasGparameter() {
    }

    public TgroupHasGparameter(Integer id) {
        this.id = id;
    }

    public TgroupHasGparameter(Integer id, Date createDate, Date updateDate) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ParameterGroup getParameterGroupID() {
        return parameterGroupID;
    }

    public void setParameterGroupID(ParameterGroup parameterGroupID) {
        this.parameterGroupID = parameterGroupID;
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
        if (!(object instanceof TgroupHasGparameter)) {
            return false;
        }
        TgroupHasGparameter other = (TgroupHasGparameter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TgroupHasGparameter[ id=" + id + " ]";
    }

   

    @XmlTransient
    public Collection<ParameterValues> getParameterValuesCollection() {
        return parameterValuesCollection;
    }

    public void setParameterValuesCollection(Collection<ParameterValues> parameterValuesCollection) {
        this.parameterValuesCollection = parameterValuesCollection;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getACCid() {
        return aCCid;
    }

    public void setACCid(Integer aCCid) {
        this.aCCid = aCCid;
    }

    public Integer getISSid() {
        return iSSid;
    }

    public void setISSid(Integer iSSid) {
        this.iSSid = iSSid;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public int getXMLupdate() {
        return xMLupdate;
    }

    public void setXMLupdate(int xMLupdate) {
        this.xMLupdate = xMLupdate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getFileLength() {
        return fileLength;
    }

    public void setFileLength(Integer fileLength) {
        this.fileLength = fileLength;
    }
    
}
