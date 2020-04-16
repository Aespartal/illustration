package net.ausiasmarch.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "album")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AlbumEntity implements Serializable, GenericEntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // si tiene el mismo nombre no cale
    private Integer id;
    private String title;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private Boolean is_private;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    @JsonIgnore //@JsonManagedReference(value="user-album")
    private UserEntity user;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album", cascade = {CascadeType.ALL})
    @JsonIgnore //@JsonBackReference(value="image-album")
    private List<ImageEntity> images = new ArrayList<>();

    public AlbumEntity() {
    }

    public AlbumEntity(Integer id) {
        this.id = id;
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIs_private() {
        return is_private;
    }

    public void setIs_private(Boolean is_private) {
        this.is_private = is_private;
    }
    @JsonIgnore
    public UserEntity getUser_id() {
        return user;
    }

    public void setUser_id(UserEntity user) {
        this.user = user;
    }

    @JsonIgnore
    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    
}
