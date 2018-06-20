package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohamed.sobhi
 */
@Entity
@Table(name = "action_log",catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActionLog.findAll", query = "SELECT a FROM ActionLog a")
    , @NamedQuery(name = "ActionLog.findById", query = "SELECT a FROM ActionLog a WHERE a.id = :id")
    , @NamedQuery(name = "ActionLog.findByPagename", query = "SELECT a FROM ActionLog a WHERE a.pagename = :pagename")
    , @NamedQuery(name = "ActionLog.findByMessage", query = "SELECT a FROM ActionLog a WHERE a.message = :message")
    ,@NamedQuery(name = "ActionLog.findByUserIdandPageName", query = "SELECT a FROM ActionLog a WHERE a.pagename = :pagename AND a.userID=:userID ORDER BY a.actionDate DESC ")
    , @NamedQuery(name = "ActionLog.findByActionDate", query = "SELECT a FROM ActionLog a WHERE a.actionDate = :actionDate")})
public class ActionLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Page_name")
    private String pagename;
    @Size(max = 3000)
    @Column(name = "message")
    private String message;
    @Column(name = "action_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userID;
    
    @Transient
    private String dateFormate ; 

    public void setDateFormate(String DateFormate) {
        this.dateFormate = DateFormate;
    }

    public String getDateFormate() {
        if(getActionDate() != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String date = sdf.format(getActionDate());
            return date;
        }
        else {return "" ; }
    }
    

    public ActionLog() {
    }

    public ActionLog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
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
        if (!(object instanceof ActionLog)) {
            return false;
        }
        ActionLog other = (ActionLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ActionLog[ id=" + id + " ]";
    }
    
}