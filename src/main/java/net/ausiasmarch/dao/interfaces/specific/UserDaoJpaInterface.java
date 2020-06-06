package net.ausiasmarch.dao.interfaces.specific;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import net.ausiasmarch.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDaoJpaInterface extends JpaRepository<UserEntity, Integer> {
	@Query(value = "SELECT u FROM UserEntity u WHERE u.username = :username AND u.password = :password")
	UserEntity findByLogin(@Param("username")String username,@Param("password")String password);
        
        @Query(value = "SELECT * FROM user u, image i WHERE i.id =:image_id AND u.id = i.user_id", nativeQuery=true)
        UserEntity findUserByImage(@Param("image_id")Integer image_id);
        
        @Query(value = "SELECT u FROM UserEntity u WHERE u.username = :username")
        UserEntity getUsername(@Param("username")String username);
        
        @Query(value = "SELECT u.* FROM user u, chat c WHERE u.id = c.to_user AND c.from_user = :user_id  group by c.to_user", nativeQuery=true)
        List<UserEntity> getUsersChat(@Param("user_id")Integer user_id);
        
         //A los que sigo
        @Query(value="SELECT * FROM User u, follower f WHERE u.id = f.user_id AND f.friend_id = :user_id limit :offset, :pageSize",nativeQuery=true)
        List<UserEntity> getFolloweds(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("user_id") Integer user_id);
        
         //mis seguigores
        @Query(value="SELECT * FROM User u, follower f WHERE u.id = f.friend_id AND f.user_id = :user_id limit :offset, :pageSize",nativeQuery=true)
        List<UserEntity> getFollowers(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("user_id") Integer user_id);
}
