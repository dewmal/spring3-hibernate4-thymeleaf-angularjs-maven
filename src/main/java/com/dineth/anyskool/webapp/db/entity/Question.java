/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dineth.anyskool.webapp.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author dewmalpc
 */
@Entity
@Table(name = "question", catalog = "anyskooldb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQid", query = "SELECT q FROM Question q WHERE q.qid = :qid"),
    @NamedQuery(name = "Question.findByTitle", query = "SELECT q FROM Question q WHERE q.title = :title"),
    @NamedQuery(name = "Question.findByPosttime", query = "SELECT q FROM Question q WHERE q.posttime = :posttime")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "qid")
    private String qid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posttime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "user_uid", referencedColumnName = "uid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userUid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.LAZY)
    private List<Comment> commentList;

    public Question() {
    }

    public Question(String qid) {
        this.qid = qid;
    }

    public Question(String qid, String title, Date posttime, String content) {
        this.qid = qid;
        this.title = title;
        this.posttime = posttime;
        this.content = content;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserUid() {
        return userUid;
    }

    public void setUserUid(User userUid) {
        this.userUid = userUid;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qid != null ? qid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dineth.anyskool.webapp.entity.Question[ qid=" + qid + " ]";
    }
    
}
