/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "website_data", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebsiteData.findAll", query = "SELECT w FROM WebsiteData w")
    , @NamedQuery(name = "WebsiteData.findById", query = "SELECT w FROM WebsiteData w WHERE w.id = :id")
    , @NamedQuery(name = "WebsiteData.findByWebSite", query = "SELECT w FROM WebsiteData w WHERE w.webSite = :webSite")
    , @NamedQuery(name = "WebsiteData.findByWebDesc", query = "SELECT w FROM WebsiteData w WHERE w.webDesc = :webDesc")})
public class WebsiteData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "web_site", nullable = false, length = 45)
    private String webSite;
    @Size(max = 45)
    @Column(name = "Web_Desc", length = 45)
    private String webDesc;
    @ManyToMany(mappedBy = "websiteDataCollection")
    private Collection<User> userCollection;

    public WebsiteData() {
    }

    public WebsiteData(Integer id) {
        this.id = id;
    }

    public WebsiteData(Integer id, String webSite) {
        this.id = id;
        this.webSite = webSite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getWebDesc() {
        return webDesc;
    }

    public void setWebDesc(String webDesc) {
        this.webDesc = webDesc;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof WebsiteData)) {
            return false;
        }
        WebsiteData other = (WebsiteData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WebsiteData[ id=" + id + " ]";
    }
    
}
