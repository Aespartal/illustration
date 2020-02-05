/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MessageKey implements Serializable {
     @Column(name = "to_id")
    private Integer to_id;

    @Column(name = "from_id")
    private Integer from_id;

    public MessageKey() {
    }
    
    public Integer getTo_id() {
        return to_id;
    }

    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }

    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.to_id);
        hash = 83 * hash + Objects.hashCode(this.from_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MessageKey other = (MessageKey) obj;
        if (!Objects.equals(this.to_id, other.to_id)) {
            return false;
        }
        if (!Objects.equals(this.from_id, other.from_id)) {
            return false;
        }
        return true;
    }
    
    
    
}
