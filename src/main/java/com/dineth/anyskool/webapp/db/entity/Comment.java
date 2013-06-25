/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dineth.anyskool.webapp.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dewmalpc
 */
@Entity
@Table(name = "comment", catalog = "anyskooldb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByQid", query = "SELECT c FROM Comment c WHERE c.commentPK.qid = :qid"),
    @NamedQuery(name = "Comment.findByUid", query = "SELECT c FROM Comment c WHERE c.commentPK.uid = :uid"),
    @NamedQuery(name = "Comment.findByPosttime", query = "SELECT c FROM Comment c WHERE c.commentPK.posttime = :posttime")})
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommentPK commentPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "qid", referencedColumnName = "qid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;

    public Comment() {
    }

    public Comment(CommentPK commentPK) {
        this.commentPK = commentPK;
    }

    public Comment(CommentPK commentPK, String comment) {
        this.commentPK = commentPK;
        this.comment = comment;
    }

    public Comment(String qid, String uid, Date posttime) {
        this.commentPK = new CommentPK(qid, uid, posttime);
    }

    public CommentPK getCommentPK() {
        return commentPK;
    }

    public void setCommentPK(CommentPK commentPK) {
        this.commentPK = commentPK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentPK != null ? commentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentPK == null && other.commentPK != null) || (this.commentPK != null && !this.commentPK.equals(other.commentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dineth.anyskool.webapp.entity.Comment[ commentPK=" + commentPK + " ]";
    }
    
}
