package net.ausiasmarch.repository;

import java.util.List;
import java.util.Optional;

import net.ausiasmarch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @Query(value = "SELECT u.* FROM User u, chat c WHERE u.id = c.to_user AND c.from_user = :user_id  group by c.to_user", nativeQuery = true)
    List<User> getUsersChat(@Param("user_id") Integer user_id);

    //A los que sigo
    @Query(value = "SELECT * FROM User u, follower f WHERE u.id = f.user_id AND f.friend_id = :user_id limit :offset, :pageSize", nativeQuery = true)
    List<User> getFolloweds(@Param("offset") Long offset, @Param("pageSize") Integer pageSize, @Param("user_id") Integer user_id);

    //mis seguigores
    @Query(value = "SELECT * FROM User u, follower f WHERE u.id = f.friend_id AND f.user_id = :user_id limit :offset, :pageSize", nativeQuery = true)
    List<User> getFollowers(@Param("offset") Long offset, @Param("pageSize") Integer pageSize, @Param("user_id") Integer user_id);

    Optional<User> findOneByUsername(String username);

    Optional<User> findOneWithAuthoritiesByUsername(String lowercaseLogin);
}
