/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="like_image")
public class Like implements Serializable {
    
    @EmbeddedId LikeId id;

    public Like() {
    }

    public Like(LikeId id) {
        this.id = id;
    }
    
    public LikeId getId() {
        return id;
    }

    public void setId(LikeId id) {
        this.id = id;
    }


    
    
    
}
