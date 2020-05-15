/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;

@Entity
@Table(name = "image")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ImageEntity implements Serializable, GenericEntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String title;
    private String description;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    private String tags;
    private Boolean is_private;
    private Boolean is_reported;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    //------------------------------------

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    //------------------------------------

    @ManyToMany(
            mappedBy = "image",
            cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<ImageEntity> likes = new ArrayList<>(); //MANY TO MENY con ImageEntity
    //-----------------------------------
    @OneToMany(
            mappedBy = "image",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<CommentEntity> comments = new ArrayList<CommentEntity>();

    public ImageEntity() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ImageEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<ImageEntity> likes) {
        this.likes = likes;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public String getField(String filter) {
        return filter.matches("id|title|description|date|tags") ? filter : null;
    }

}
