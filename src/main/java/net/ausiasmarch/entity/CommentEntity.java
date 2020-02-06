package net.ausiasmarch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import net.ausiasmarch.entity.interfaces.GenericEntityInterface;

@Entity
@Table(name = "comments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CommentEntity implements Serializable, GenericEntityInterface {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private ImageEntity image;
    private String body;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;

    public CommentEntity() {
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }  

    public UserEntity getUser_id() {
        return user;
    }

    public void setUser_id(UserEntity user) {
        this.user = user;
    }

    public ImageEntity getImage_id() {
        return image;
    }

    public void setImage_id(ImageEntity image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CommentEntity{" + "id=" + id + ", user=" + user + ", image=" + image + ", body=" + body + ", date=" + date + '}';
    }
 
    
    

}
