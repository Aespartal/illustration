/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.repository;

import javax.transaction.Transactional;
import net.ausiasmarch.domain.Like;
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
public interface LikeRepository extends JpaRepository<Like, String>, JpaSpecificationExecutor<Like> {
    //BUSCA EN LA TABLA LIKE_IMAGE SI HA DADO LIKE
    @Query(value="SELECT user_id,image_id FROM like_image WHERE user_id=:user_id AND image_id=:image_id",nativeQuery=true)
    Like findlike(@Param("user_id")Integer user_id, @Param("image_id")Integer image_id);
    
    @Transactional
    @Modifying(clearAutomatically = false)
    @Query(value="DELETE FROM like_image WHERE user_id=:user_id AND image_id=:image_id",nativeQuery=true)
    void removeLike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
    
    @Transactional
    @Modifying(clearAutomatically = false)
    @Query(value="INSERT INTO like_image (user_id, image_id) VALUES (:user_id, :image_id)",nativeQuery=true)
    void saveLike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
    
}
