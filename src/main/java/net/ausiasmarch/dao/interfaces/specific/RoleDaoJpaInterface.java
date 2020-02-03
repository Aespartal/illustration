package net.ausiasmarch.dao.interfaces.specific;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.entity.RoleEntity;

public interface RoleDaoJpaInterface extends JpaRepository<RoleEntity, Integer> {

}
