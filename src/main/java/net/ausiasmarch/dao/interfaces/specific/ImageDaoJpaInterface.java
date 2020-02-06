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

/**
 *
 * @author espar
 */
public interface ImageDaoJpaInterface extends JpaRepository<ImageEntity, String> {
    //BUSCA EN LA TABLA LIKE_IMAGE SI HA DADO LIKE
    @Query(value="SELECT i FROM like_image i WHERE user_id=:user_id AND image_id=:image_id",nativeQuery=true)
    List<String> findlike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
    
     //ELIMINA EL LIKE DE LA TABLA
    @Query(value="DELETE FROM like_image i WHERE user_id=:user_id AND image_id=:image_id",nativeQuery=true)
    boolean removeLike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
    
    //GUARDA EL LIKE EN LA TABLA
    @Query(value="INSERT INTO like_image (user_id, image_id) VALUES (:user_id, :image_id)",nativeQuery=true)
    boolean saveLike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
    
}
