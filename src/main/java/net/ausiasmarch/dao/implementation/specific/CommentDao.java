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
}
