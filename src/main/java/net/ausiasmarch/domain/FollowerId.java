/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author espar
 */
@Embeddable
public class FollowerId implements Serializable {
    private Integer user_id;
    private Integer friend_id;

    public FollowerId() {
    }

    public FollowerId(Integer user_id, Integer friend_id) {
        this.user_id = user_id;
        this.friend_id = friend_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        this.friend_id = friend_id;
    }
    
    
    
}
