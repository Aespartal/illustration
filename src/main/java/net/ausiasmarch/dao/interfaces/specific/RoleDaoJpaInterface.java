package net.ausiasmarch.dao.interfaces.specific;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.entity.RoleEntity;

@Qualifier("RoleDaoJpaInterface")
public interface RoleDaoJpaInterface extends JpaRepository<RoleEntity, Long> {

}
