package net.ausiasmarch.dao.implementation.specific;

import java.util.List;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.dao.interfaces.specific.CommentDaoJpaInterface;
import net.ausiasmarch.entity.CommentEntity;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {
    @Autowired
    protected CommentDaoJpaInterface oCommentDaoJpaInterface;

    @Autowired
    public CommentDao(CommentDaoJpaInterface oCommentDaoInterface) {
        super(oCommentDaoInterface);
    }
    
    public List<CommentEntity> getcomments(Integer id){
        return oCommentDaoJpaInterface.getcomments(id);
    }
    
    public CommentEntity getCommentByUser_id(Integer id,Integer user_id){
        return oCommentDaoJpaInterface.getCommentByUser_id(id,user_id);
    }
    
    public Integer countComments(int image_id){
         return oCommentDaoJpaInterface.countComments(image_id);
    }
}
