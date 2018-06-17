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
 * @author mohammed.ayad
 */
@Entity
@Table(name = "pages",catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pages.findAll", query = "SELECT p FROM Pages p")
    , @NamedQuery(name = "Pages.findByPageId", query = "SELECT p FROM Pages p WHERE p.pageId = :pageId")
    , @NamedQuery(name = "Pages.findByPageName", query = "SELECT p FROM Pages p WHERE p.pageName = :pageName")})
public class Pages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "page_id")
    private Integer pageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "page_name")
    private String pageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId")
    private Collection<LogScreen> logScreenCollection;

    public Pages() {
    }

    public Pages(Integer pageId) {
        this.pageId = pageId;
    }

    public Pages(Integer pageId, String pageName) {
        this.pageId = pageId;
        this.pageName = pageName;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
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
        hash += (pageId != null ? pageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pages)) {
            return false;
        }
        Pages other = (Pages) object;
        if ((this.pageId == null && other.pageId != null) || (this.pageId != null && !this.pageId.equals(other.pageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Pages[ pageId=" + pageId + " ]";
    }
    
}
