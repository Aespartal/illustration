/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.dao.interfaces.specific;

import java.util.List;
import net.ausiasmarch.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author espar
 */
public interface CommentDaoJpaInterface extends JpaRepository<CommentEntity, Integer> {
    
    @Query(value="SELECT * FROM comments c, image i WHERE c.image_id=i.id AND i.id=:id",nativeQuery=true)
    List<CommentEntity> getcomments(Integer id);
}
