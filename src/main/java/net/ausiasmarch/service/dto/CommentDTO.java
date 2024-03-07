package net.ausiasmarch.service.dto;

import net.ausiasmarch.domain.Image;
import net.ausiasmarch.domain.User;

import java.io.Serializable;
import java.util.Date;


public class CommentDTO implements Serializable {
    private Integer id;
    private String body;
    private User user;
    private Image image;

    private Date date;

    public CommentDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user) {
        this.user = user;
    }

    public Image getImage_id() {
        return image;
    }

    public void setImage_id(Image image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
