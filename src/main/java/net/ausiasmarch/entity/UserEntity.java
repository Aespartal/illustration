package net.ausiasmarch.entity;

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
import static java.sql.Types.BIT;
import java.util.Date;
import javax.persistence.Temporal;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserEntity implements Serializable, GenericEntityInterface {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String username;
	private String password;
	private String email;
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean is_private;
	private String description;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date_register;
	private String img_profile;
	private String img_cover;
	private String token;
	private Integer level;
	private Integer exp;
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean is_validate;
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean is_banned;
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean is_reported;
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "role_id")
	private RoleEntity role_id;

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

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
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

	public Boolean getIs_reported() {
		return is_reported;
	}

	public void setIs_reported(Boolean is_reported) {
		this.is_reported = is_reported;
	}

	public RoleEntity getRole_id() {
		return role_id;
	}

	public void setRole_id(RoleEntity role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "UserEntity{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", is_private=" + is_private + ", description=" + description + ", date_register=" + date_register
				+ ", img_profile=" + img_profile + ", img_cover=" + img_cover + ", token=" + token + ", level=" + level
				+ ", exp=" + exp + ", is_validate=" + is_validate + ", is_banned=" + is_banned + ", is_reported="
				+ is_reported + ", role_id=" + role_id + '}';
	}

}
