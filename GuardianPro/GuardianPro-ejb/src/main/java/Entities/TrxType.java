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
import javax.persistence.Id;
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
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "trx_type", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrxType.findAll", query = "SELECT t FROM TrxType t")
    , @NamedQuery(name = "TrxType.findById", query = "SELECT t FROM TrxType t WHERE t.id = :id")
    , @NamedQuery(name = "TrxType.findByTType", query = "SELECT t FROM TrxType t WHERE t.tType = :tType")
    , @NamedQuery(name = "TrxType.findByCreateDate", query = "SELECT t FROM TrxType t WHERE t.createDate = :createDate")
    , @NamedQuery(name = "TrxType.findByUpdateDate", query = "SELECT t FROM TrxType t WHERE t.updateDate = :updateDate")})
public class TrxType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "T_Type", nullable = false, length = 45)
    private String tType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tRXTypeID")
    private Collection<LogScreen> logScreenCollection;

    public TrxType() {
    }

    public TrxType(Integer id) {
        this.id = id;
    }

    public TrxType(Integer id, String tType, Date createDate, Date updateDate) {
        this.id = id;
        this.tType = tType;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTType() {
        return tType;
    }

    public void setTType(String tType) {
        this.tType = tType;
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

    @XmlTransient
    public Collection<LogScreen> getLogScreenCollection() {
        return logScreenCollection;
    }

    public void setLogScreenCollection(Collection<LogScreen> logScreenCollection) {
        this.logScreenCollection = logScreenCollection;
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
        if (!(object instanceof TrxType)) {
            return false;
        }
        TrxType other = (TrxType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TrxType[ id=" + id + " ]";
    }
    
}
