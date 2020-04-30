/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.dao.interfaces.specific;

import javax.transaction.Transactional;
import net.ausiasmarch.entity.FollowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author espar
 */
public interface FollowerDaoJpaInterface extends JpaRepository<FollowerEntity, String> {
        @Query(value="SELECT user_id,friend_id FROM follower WHERE user_id=:user_id AND friend_id=:friend_id",nativeQuery=true)
    FollowerEntity findFollower(@Param("user_id")Integer user_id,@Param("friend_id")Integer friend_id);
    
    @Transactional
    @Modifying(clearAutomatically = false)
    @Query(value="DELETE FROM follower WHERE user_id=:user_id AND friend_id=:friend_id",nativeQuery=true)
    void unFollow(@Param("user_id")Integer user_id,@Param("friend_id")Integer friend_id);
    
    @Transactional
    @Modifying(clearAutomatically = false)
    @Query(value="INSERT INTO follower (user_id, friend_id) VALUES (:user_id, :friend_id)",nativeQuery=true)
    void follow(@Param("user_id")Integer user_id,@Param("friend_id")Integer friend_id);
}
