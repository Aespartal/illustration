/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.dao.interfaces.specific;
import java.util.List;
import net.ausiasmarch.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ImageDaoJpaInterface extends JpaRepository<ImageEntity, String> {
  
     @Query("SELECT i FROM ImageEntity i WHERE id LIKE %?1% OR title LIKE %?1% OR description LIKE %?1% OR date LIKE %?1% OR tags LIKE %?1%")
    List<ImageEntity> findFilter(String title);
    
    @Query("SELECT i FROM ImageEntity i WHERE i.category.id = ?1")
    List<ImageEntity> getAllByCategory(Integer category_id);
    
    @Query(value="SELECT * FROM image i, like_image u WHERE i.id = u.image_id AND u.user_id=:user_id",nativeQuery=true)
    List<ImageEntity> favourite(Integer user_id);
    
    //TREAER LAS IMAGENES Y LUEGO VER LOS ME GUSTAS
    //IMAGENES ME GUSTAS 
    @Query(value="SELECT i.*, COUNT(l.user_id) as count FROM image i LEFT JOIN like_image l ON i.id = l.image_id GROUP BY i.id ORDER BY count DESC limit :offset, :pageSize",nativeQuery=true)
    List<ImageEntity> popular(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
    
    //IMAGENES ME GUSTAS 
    @Query(value="SELECT * FROM image i, like_image u WHERE i.id = u.image_id AND u.user_id=:user_id",nativeQuery=true)
    List<ImageEntity> imageslikes(Integer user_id);
    
    @Query(value="SELECT i.* FROM image i, user u WHERE i.user_id = :user_id GROUP BY i.id",nativeQuery=true)
    List<ImageEntity> myimages(Integer user_id);
    
    //IMAGENES DE LOS SEGUIDORES
    @Query(value="SELECT i.* FROM image i, user u, follower f WHERE i.user_id = f.friend_id AND f.user_id = :user_id GROUP BY i.id limit :offset, :pageSize",nativeQuery=true)
    List<ImageEntity> getPageImgFollows(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, Integer user_id);
    
    //Likes de una imagen
    @Query(value="SELECT count(*) FROM like_image u WHERE u.image_id = :image_id",nativeQuery=true)
    Integer countLikes(Integer image_id);
    
}
