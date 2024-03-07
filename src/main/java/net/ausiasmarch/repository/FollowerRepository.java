/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.repository;

import javax.transaction.Transactional;
import net.ausiasmarch.domain.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author espar
 */
@SuppressWarnings("unused")
@Repository
public interface FollowerRepository extends JpaRepository<Follower, String>, JpaSpecificationExecutor<Follower> {
    
    @Query(value="SELECT user_id,friend_id FROM follower WHERE user_id=:user_id AND friend_id=:friend_id",nativeQuery=true)
    Follower findFollower(@Param("user_id")Integer user_id, @Param("friend_id")Integer friend_id);
    
    //Count de las personas a las que sigo
    @Query(value="SELECT COUNT(f.friend_id) FROM follower f WHERE f.user_id=:user_id",nativeQuery=true)
    Integer countFolloweds(@Param("user_id")Integer user_id);
    
    //Count de mis seguigores
    @Query(value="SELECT COUNT(*) FROM follower WHERE friend_id=:user_id",nativeQuery=true)
    Integer countFollowers(@Param("user_id")Integer user_id);
    
    @Transactional
    @Modifying(clearAutomatically = false)
    @Query(value="DELETE FROM follower WHERE user_id=:user_id AND friend_id=:friend_id",nativeQuery=true)
    void unFollow(@Param("user_id")Integer user_id,@Param("friend_id")Integer friend_id);
    
    @Transactional
    @Modifying(clearAutomatically = false)
    @Query(value="INSERT INTO follower (user_id, friend_id) VALUES (:user_id, :friend_id)",nativeQuery=true)
    void follow(@Param("user_id")Integer user_id,@Param("friend_id")Integer friend_id);
    
}
