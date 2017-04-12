/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModels;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "o_auth_access_tokens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OAuthAccessTokens.findAll", query = "SELECT o FROM OAuthAccessTokens o")
    , @NamedQuery(name = "OAuthAccessTokens.findById", query = "SELECT o FROM OAuthAccessTokens o WHERE o.id = :id")
    , @NamedQuery(name = "OAuthAccessTokens.findByToken", query = "SELECT o FROM OAuthAccessTokens o WHERE o.token = :token")
    , @NamedQuery(name = "OAuthAccessTokens.findByExpiresAt", query = "SELECT o FROM OAuthAccessTokens o WHERE o.expiresAt = :expiresAt")
    , @NamedQuery(name = "OAuthAccessTokens.findByCreatedAt", query = "SELECT o FROM OAuthAccessTokens o WHERE o.createdAt = :createdAt")
    , @NamedQuery(name = "OAuthAccessTokens.findByUpdatedAt", query = "SELECT o FROM OAuthAccessTokens o WHERE o.updatedAt = :updatedAt")})
public class OAuthAccessTokens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "token")
    private String token;
    @Column(name = "expires_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresAt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "authorizations_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Authorizations authorizationsId;

    public OAuthAccessTokens() {
    }

    public OAuthAccessTokens(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Authorizations getAuthorizationsId() {
        return authorizationsId;
    }

    public void setAuthorizationsId(Authorizations authorizationsId) {
        this.authorizationsId = authorizationsId;
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
        if (!(object instanceof OAuthAccessTokens)) {
            return false;
        }
        OAuthAccessTokens other = (OAuthAccessTokens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.OAuthAccessTokens[ id=" + id + " ]";
    }
    
}
