package net.ausiasmarch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;

/**
 *
 * @author espar
 */
@Entity
@Table(name = "role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RolEntity implements Serializable, GenericEntityInterface {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = { CascadeType.ALL }, orphanRemoval = true)
        @JsonIgnore
	private List<UserEntity> users = new ArrayList<>();

	public RolEntity() {

	}

	public RolEntity(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public RolEntity(String description) {
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


}
