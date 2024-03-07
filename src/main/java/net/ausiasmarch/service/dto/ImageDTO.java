package net.ausiasmarch.service.dto;

import net.ausiasmarch.domain.Category;
import net.ausiasmarch.domain.User;

import java.io.Serializable;
import java.util.Date;


public class ImageDTO implements Serializable {

    private Integer id;
    private String image;
    private String title;
    private String description;
    private Date date;
    private String tags;
    private Boolean is_private;
    private Boolean is_reported;
    private Category category;
    private User user;

    public ImageDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getIs_private() {
        return is_private;
    }

    public void setIs_private(Boolean is_private) {
        this.is_private = is_private;
    }

    public Boolean getIs_reported() {
        return is_reported;
    }

    public void setIs_reported(Boolean is_reported) {
        this.is_reported = is_reported;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getField(String filter) {
        return filter.matches("id|title|description|date|tags") ? filter : null;
    }

}
