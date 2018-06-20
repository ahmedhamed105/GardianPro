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
@Table(name = "log_screen", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogScreen.findAll", query = "SELECT l FROM LogScreen l"),
    @NamedQuery(name = "LogScreen.findById", query = "SELECT l FROM LogScreen l WHERE l.id = :id"),
    @NamedQuery(name = "LogScreen.findBypageuser", query = "SELECT l FROM LogScreen l WHERE l.pageId = :id and l.userID = :id1"),
    @NamedQuery(name = "LogScreen.findByTable1", query = "SELECT l FROM LogScreen l WHERE l.table1 = :table1"),
    @NamedQuery(name = "LogScreen.findByTRXdesc", query = "SELECT l FROM LogScreen l WHERE l.tRXdesc = :tRXdesc"),
    @NamedQuery(name = "LogScreen.findByT2val", query = "SELECT l FROM LogScreen l WHERE l.t2val = :t2val"),
    @NamedQuery(name = "LogScreen.findByT1val", query = "SELECT l FROM LogScreen l WHERE l.t1val = :t1val"),
    @NamedQuery(name = "LogScreen.findByT2Col", query = "SELECT l FROM LogScreen l WHERE l.t2Col = :t2Col"),
    @NamedQuery(name = "LogScreen.findByT1Col", query = "SELECT l FROM LogScreen l WHERE l.t1Col = :t1Col"),
    @NamedQuery(name = "LogScreen.findByTable2", query = "SELECT l FROM LogScreen l WHERE l.table2 = :table2"),
    @NamedQuery(name = "LogScreen.findByCreateDate", query = "SELECT l FROM LogScreen l WHERE l.createDate = :createDate"),
    @NamedQuery(name = "LogScreen.findByUpdateDate", query = "SELECT l FROM LogScreen l WHERE l.updateDate = :updateDate"),
    @NamedQuery(name = "LogScreen.findBySeqno", query = "SELECT l FROM LogScreen l WHERE l.seqno = :seqno")})
public class LogScreen implements Serializable {

    @Column(name = "Seq_no")
    private Integer seqno;
    @JoinColumn(name = "page_id", referencedColumnName = "page_id")
    @ManyToOne(optional = false)
    private Pages pageId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "table1", length = 45)
    private String table1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TRX_desc", nullable = false, length = 45)
    private String tRXdesc;
    @Size(max = 45)
    @Column(name = "T2_val", length = 45)
    private String t2val;
    @Size(max = 45)
    @Column(name = "T1_val", length = 45)
    private String t1val;
    @Size(max = 45)
    @Column(name = "T2_Col", length = 45)
    private String t2Col;
    @Size(max = 45)
    @Column(name = "T1_Col", length = 45)
    private String t1Col;
    @Size(max = 45)
    @Column(name = "table2", length = 45)
    private String table2;
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
    @JoinColumn(name = "TRX_Type_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TrxType tRXTypeID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;

    public LogScreen() {
    }

    public LogScreen(Integer id) {
        this.id = id;
    }

    public LogScreen(Integer id, String tRXdesc, Date createDate, Date updateDate, int seqno) {
        this.id = id;
        this.tRXdesc = tRXdesc;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.seqno = seqno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTable1() {
        return table1;
    }

    public void setTable1(String table1) {
        this.table1 = table1;
    }

    public String getTRXdesc() {
        return tRXdesc;
    }

    public void setTRXdesc(String tRXdesc) {
        this.tRXdesc = tRXdesc;
    }

    public String getT2val() {
        return t2val;
    }

    public void setT2val(String t2val) {
        this.t2val = t2val;
    }

    public String getT1val() {
        return t1val;
    }

    public void setT1val(String t1val) {
        this.t1val = t1val;
    }

    public String getT2Col() {
        return t2Col;
    }

    public void setT2Col(String t2Col) {
        this.t2Col = t2Col;
    }

    public String getT1Col() {
        return t1Col;
    }

    public void setT1Col(String t1Col) {
        this.t1Col = t1Col;
    }

    public String getTable2() {
        return table2;
    }

    public void setTable2(String table2) {
        this.table2 = table2;
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

    public int getSeqno() {
        return seqno;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }

    public TrxType getTRXTypeID() {
        return tRXTypeID;
    }

    public void setTRXTypeID(TrxType tRXTypeID) {
        this.tRXTypeID = tRXTypeID;
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
        if (!(object instanceof LogScreen)) {
            return false;
        }
        LogScreen other = (LogScreen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.LogScreen[ id=" + id + " ]";
    }

    public Pages getPageId() {
        return pageId;
    }

    public void setPageId(Pages pageId) {
        this.pageId = pageId;
    }
    
}
