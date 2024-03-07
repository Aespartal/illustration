/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.repository;

import java.util.List;
import java.util.Optional;

import net.ausiasmarch.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author espar
 */
@SuppressWarnings("unused")
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
    
    @Query(value="SELECT * FROM comments c, image i WHERE c.image_id=i.id AND i.id=:id",nativeQuery=true)
    List<Comment> getcomments(Integer id);

    Long countByImageId(int id);

    List<Comment> findAllById(Integer id);
}
