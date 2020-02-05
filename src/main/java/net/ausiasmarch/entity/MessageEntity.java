/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;

@Entity
@Table(name = "message")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MessageEntity implements Serializable {
    
    @EmbeddedId
    private MessageKey id;
    
    @ManyToOne 
    @MapsId("to_id")
    private UserEntity to;
    @ManyToOne 
    @MapsId("from_id")
    private UserEntity from;
    
    private String body;

    public MessageEntity() {
    }

    public MessageKey getId() {
        return id;
    }

    public void setId(MessageKey id) {
        this.id = id;
    }

    public UserEntity getTo_id() {
        return to;
    }

    public void setTo_id(UserEntity to) {
        this.to = to;
    }

    public UserEntity getFrom_id() {
        return from;
    }

    public void setFrom_id(UserEntity from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
}
