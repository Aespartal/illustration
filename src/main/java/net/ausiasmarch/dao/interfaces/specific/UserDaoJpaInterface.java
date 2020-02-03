package net.ausiasmarch.dao.interfaces.specific;

import org.springframework.data.jpa.repository.JpaRepository;
import net.ausiasmarch.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDaoJpaInterface extends JpaRepository<UserEntity, Integer> {
	@Query(value = "SELECT u FROM UserEntity u WHERE u.username = :username AND u.password = :password")
	UserEntity findByLogin(@Param("username")String username,@Param("password")String password);
}
