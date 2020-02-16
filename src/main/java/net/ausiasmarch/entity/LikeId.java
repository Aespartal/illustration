/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 *
 * @author espar
 */
@Embeddable
public class LikeId implements Serializable {
    private Integer user_id;
    private Integer image_id;

    public LikeId() {
    }
    
    public LikeId(Integer user_id, Integer image_id) {
        this.user_id = user_id;
        this.image_id = image_id;
    }
    
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }
    
}
