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
@Table(name = "application_has_group", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationHasGroup.findAll", query = "SELECT a FROM ApplicationHasGroup a"),
    @NamedQuery(name = "ApplicationHasGroup.findById", query = "SELECT a FROM ApplicationHasGroup a WHERE a.id = :id"),
    @NamedQuery(name = "ApplicationHasGroup.findByCreateDate", query = "SELECT a FROM ApplicationHasGroup a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "ApplicationHasGroup.findByUpdateDate", query = "SELECT a FROM ApplicationHasGroup a WHERE a.updateDate = :updateDate")})
public class ApplicationHasGroup implements Serializable {

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
    @JoinColumn(name = "Application_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Application applicationID;
    @JoinColumn(name = "Application_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ApplicationGroup applicationGroupID;

    public ApplicationHasGroup() {
    }

    public ApplicationHasGroup(Integer id) {
        this.id = id;
    }

    public ApplicationHasGroup(Integer id, Date createDate, Date updateDate) {
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

    public Application getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Application applicationID) {
        this.applicationID = applicationID;
    }

    public ApplicationGroup getApplicationGroupID() {
        return applicationGroupID;
    }

    public void setApplicationGroupID(ApplicationGroup applicationGroupID) {
        this.applicationGroupID = applicationGroupID;
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
        if (!(object instanceof ApplicationHasGroup)) {
            return false;
        }
        ApplicationHasGroup other = (ApplicationHasGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ApplicationHasGroup[ id=" + id + " ]";
    }
    
}
