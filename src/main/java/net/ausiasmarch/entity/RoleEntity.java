package net.ausiasmarch.entity;

import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author espar
 */
@Entity
@Table(name = "role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RoleEntity implements Serializable, GenericEntityInterface {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // si tiene el mismo nombre no cale
	private Integer id;
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role_id", cascade = { CascadeType.ALL })
	private List<UserEntity> users;

	public RoleEntity() {

	}

	public RoleEntity(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public RoleEntity(String description) {
		this.description = description;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", description=" + description + "]";
	}

}
