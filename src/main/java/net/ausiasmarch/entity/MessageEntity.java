/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;

@Entity
@Table(name = "chat")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MessageEntity implements Serializable, GenericEntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_user", referencedColumnName = "id")
    private UserEntity to;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_user", referencedColumnName = "id")
    private UserEntity from;

    private String body;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;

    public MessageEntity() {
    }

    public MessageEntity(UserEntity to, UserEntity from, String body, Date date) {
        this.to = to;
        this.from = from;
        this.body = body;
        this.date = date;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getTo() {
        return to;
    }

    public void setTo(UserEntity to) {
        this.to = to;
    }

    public UserEntity getFrom() {
        return from;
    }

    public void setFrom(UserEntity from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
