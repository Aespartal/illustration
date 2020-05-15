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

    public List<CommentEntity> getcomments(Integer id) {
        return oCommentDao.getcomments(id);
    }

    public CommentEntity getCommentByUser_id(Integer id, Integer user_id) {
        return oCommentDao.getCommentByUser_id(id, user_id);
    }
    
    public Integer countComments(int image_id) {
        return oCommentDao.countComments(image_id);
    }
}
