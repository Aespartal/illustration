package net.ausiasmarch.service.implementation.specific;

import java.util.List;
import net.ausiasmarch.dao.implementation.specific.CommentDao;
import net.ausiasmarch.entity.CommentEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends GenericServiceImplementation implements GenericServiceInterface {
    @Autowired
    protected CommentDao oCommentDao;
    
    @Autowired
    public CommentService(CommentDao oCommentDao) {
        super(oCommentDao);
    }

    public List<CommentEntity> getcomments(Integer id){
        return oCommentDao.getcomments(id);
    }
}
