package net.ausiasmarch.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity implements Serializable, GenericEntityInterface {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname1;
    private String surname2;
    private String username;
    private String password;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthdate;
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean is_private;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_register;
    private String img_profile;
    private String img_cover;
    private String token;
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean is_validate;
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean is_banned;
 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    //@JsonManagedReference(value="user_role")
    private RolEntity role;
    
//-----------------------
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(
            name = "like_image",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
   @JsonIgnore// @JsonBackReference(value="user_image")
    private Set<UserEntity> likedImage = new HashSet<UserEntity>(); //MANY TO MENY 
//--------------------------
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "follower",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id",referencedColumnName = "id"))
    @JsonIgnore//@JsonBackReference(value="user_friend")
    private Set<UserEntity> friends = new HashSet<UserEntity>();
    
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
   @JsonIgnore//@JsonBackReference
    private Set<CommentEntity> comments = new HashSet<CommentEntity>();
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="to", cascade = {CascadeType.ALL})
    @JsonIgnore//@JsonBackReference
    private Set<MessageEntity> messages = new HashSet<MessageEntity>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.ALL})
    //@JsonIgnore@JsonBackReference(value="image-user")
    private List<ImageEntity> images = new ArrayList<>();
    
    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public RolEntity getRole() {
        return role;
    }

    public void setRole(RolEntity role) {
        this.role = role;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_private() {
        return is_private;
    }

    public void setIs_private(Boolean is_private) {
        this.is_private = is_private;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_register() {
        return date_register;
    }

    public void setDate_register(Date date_register) {
        this.date_register = date_register;
    }

    public String getImg_profile() {
        return img_profile;
    }

    public void setImg_profile(String img_profile) {
        this.img_profile = img_profile;
    }

    public String getImg_cover() {
        return img_cover;
    }

    public void setImg_cover(String img_cover) {
        this.img_cover = img_cover;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIs_validate() {
        return is_validate;
    }

    public void setIs_validate(Boolean is_validate) {
        this.is_validate = is_validate;
    }

    public Boolean getIs_banned() {
        return is_banned;
    }

    public void setIs_banned(Boolean is_banned) {
        this.is_banned = is_banned;
    }

    public Set<UserEntity> getLikedImage() {
        return likedImage;
    }

    public void setLikedImage(Set<UserEntity> likedImage) {
        this.likedImage = likedImage;
    }

    public Set<UserEntity> getFriends() {
        return friends;
    }

    public void setFriends(Set<UserEntity> friends) {
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public Set<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageEntity> messages) {
        this.messages = messages;
    }

    @JsonIgnore
    public List<ImageEntity> getImages() {
        return images;
    }
    @JsonProperty
    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
    
}
