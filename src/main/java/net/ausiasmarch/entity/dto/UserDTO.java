package net.ausiasmarch.entity.dto;

import net.ausiasmarch.entity.RolEntity;

import java.util.Objects;

public class UserDTO {
    private Integer userId;
    private String name;
    private String surname1;
    private String surname2;
    private String username;
    private String fullName;
    private String email;
    private Boolean is_private;
    private String description;
    private String img_profile;
    private String img_cover;
    private Boolean is_validate;
    private Boolean is_banned;
    private RolEntity role;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String surname1, String surname2,
                   String username, String email, Boolean is_private, String description,
                   String img_profile, String img_cover, Boolean is_validate, Boolean is_banned, RolEntity role, String fullName) {
        this.userId = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.username = username;
        this.email = email;
        this.is_private = is_private;
        this.description = description;
        this.img_profile = img_profile;
        this.img_cover = img_cover;
        this.is_validate = is_validate;
        this.is_banned = is_banned;
        this.role = role;
        this.fullName = fullName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public RolEntity getRole() {
        return role;
    }

    public void setRole(RolEntity role) {
        this.role = role;
    }

    public String getFullName() {
        return username + " " + surname1 + " " + surname2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(userId, userDTO.userId) && Objects.equals(name, userDTO.name) && Objects.equals(surname1, userDTO.surname1) && Objects.equals(surname2, userDTO.surname2) && Objects.equals(username, userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname1, surname2, username);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", is_private=" + is_private +
                ", description='" + description + '\'' +
                ", img_profile='" + img_profile + '\'' +
                ", img_cover='" + img_cover + '\'' +
                ", is_validate=" + is_validate +
                ", is_banned=" + is_banned +
                ", role=" + role +
                '}';
    }
}
