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
    @Query("SELECT i.id FROM ImageEntity i inner join like_image l on l.image_id=i.id WHERE l.user_id=:user_id AND i.image_id=:image_id")
    List<String> existLike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
    
    @Query("DELETE FROM ImageEntity i inner join like_image l on l.image_id=i.id WHERE l.user_id=:user_id AND i.image_id=:image_id")
    void removetLike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
    
    @Query("INSERT INTO like_image (user_id, image_id) VALUES (:user_id, :image_id)")
    void saveLike(@Param("user_id")Integer user_id,@Param("image_id")Integer image_id);
}
