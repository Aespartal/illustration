package net.ausiasmarch.service.dto;

import net.ausiasmarch.domain.Authority;
import net.ausiasmarch.domain.User;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
    private Boolean activated;
    private Boolean is_banned;

    private Set<String> authorities;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.surname1 = user.getSurname1();
        this.surname2 = user.getSurname2();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.is_private = user.getIs_private();
        this.description = user.getDescription();
        this.img_profile = user.getImg_profile();
        this.img_cover = user.getImg_cover();
        this.activated = user.isActivated();
        this.is_banned = user.getIs_banned();
        this.authorities = user.getAuthorities().stream()
                .map(Authority::getName)
                .collect(Collectors.toSet());
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

    public Boolean getIs_banned() {
        return is_banned;
    }

    public void setIs_banned(Boolean is_banned) {
        this.is_banned = is_banned;
    }

    public String getFullName() {
        return username + " " + surname1 + " " + surname2;
    }

    public Boolean isActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
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
                ", activated=" + activated +
                ", is_banned=" + is_banned +
                ", authorities=" + authorities +
                '}';
    }
}
