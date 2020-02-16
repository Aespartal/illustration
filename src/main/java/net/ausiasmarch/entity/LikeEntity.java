/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="like_image")
public class LikeEntity implements Serializable {
    
    @EmbeddedId LikeId id;

    public LikeEntity() {
    }

    public LikeEntity(LikeId id) {
        this.id = id;
    }
    
    public LikeId getId() {
        return id;
    }

    public void setId(LikeId id) {
        this.id = id;
    }


    
    
    
}
