/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dineth.anyskool.webapp.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dewmalpc
 */
@Embeddable
public class CommentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "qid")
    private String qid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "uid")
    private String uid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posttime;

    public CommentPK() {
    }

    public CommentPK(String qid, String uid, Date posttime) {
        this.qid = qid;
        this.uid = uid;
        this.posttime = posttime;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qid != null ? qid.hashCode() : 0);
        hash += (uid != null ? uid.hashCode() : 0);
        hash += (posttime != null ? posttime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentPK)) {
            return false;
        }
        CommentPK other = (CommentPK) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        if ((this.posttime == null && other.posttime != null) || (this.posttime != null && !this.posttime.equals(other.posttime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dineth.anyskool.webapp.entity.CommentPK[ qid=" + qid + ", uid=" + uid + ", posttime=" + posttime + " ]";
    }
}
