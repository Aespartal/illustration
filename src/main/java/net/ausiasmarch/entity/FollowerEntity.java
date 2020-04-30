/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="follower")
public class FollowerEntity implements Serializable {
    
    @EmbeddedId FollowerId id;

    public FollowerEntity() {
       
    }
    
    public FollowerEntity(FollowerId id) {
        this.id = id;
    }

    public FollowerId getId() {
        return id;
    }

    public void setId(FollowerId id) {
        this.id = id;
    }
    
    

}
