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
@Table(name = "application_group", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationGroup.findAll", query = "SELECT a FROM ApplicationGroup a"),
    @NamedQuery(name = "ApplicationGroup.findById", query = "SELECT a FROM ApplicationGroup a WHERE a.id = :id"),
    @NamedQuery(name = "ApplicationGroup.findByGroupname", query = "SELECT a FROM ApplicationGroup a WHERE a.groupname = :groupname"),
    @NamedQuery(name = "ApplicationGroup.findByCreateDate", query = "SELECT a FROM ApplicationGroup a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "ApplicationGroup.findByUpdateDate", query = "SELECT a FROM ApplicationGroup a WHERE a.updateDate = :updateDate")})
public class ApplicationGroup implements Serializable {

    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Group_name", nullable = false, length = 45)
    private String groupname;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationGroupID")
    private Collection<ApplicationHasGroup> applicationHasGroupCollection;

    public ApplicationGroup() {
    }

    public ApplicationGroup(Integer id) {
        this.id = id;
    }

    public ApplicationGroup(Integer id, String groupname, Date createDate, Date updateDate) {
        this.id = id;
        this.groupname = groupname;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
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
    public Collection<ApplicationHasGroup> getApplicationHasGroupCollection() {
        return applicationHasGroupCollection;
    }

    public void setApplicationHasGroupCollection(Collection<ApplicationHasGroup> applicationHasGroupCollection) {
        this.applicationHasGroupCollection = applicationHasGroupCollection;
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
        if (!(object instanceof ApplicationGroup)) {
            return false;
        }
        ApplicationGroup other = (ApplicationGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ApplicationGroup[ id=" + id + " ]";
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
    
}
