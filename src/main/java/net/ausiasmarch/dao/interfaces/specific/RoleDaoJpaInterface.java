package net.ausiasmarch.dao.interfaces.specific;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.entity.RoleEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

public interface RoleDaoJpaInterface extends JpaRepository<RoleEntity, Long> {

}
