package net.ausiasmarch.service.implementation.specific;

import java.util.List;
import net.ausiasmarch.dao.implementation.specific.ImageDao;
import net.ausiasmarch.entity.ImageEntity;
import net.ausiasmarch.entity.LikeEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageService extends GenericServiceImplementation implements GenericServiceInterface {

    @Autowired
    protected ImageDao oImageDao;

    @Autowired
    public ImageService(ImageDao oImageDao) {
        super(oImageDao);
    }

    public List<ImageEntity> popular(Pageable pageable) {
        return oImageDao.popular(pageable);
    }
    
    public List<ImageEntity> imageslikes(int user_id) {
        return oImageDao.imageslikes(user_id);
    }
    
    public List<ImageEntity> favourite(Integer user_id) {
        return oImageDao.favourite(user_id);
    }

    public List<ImageEntity> myimages(Integer user_id) {
        return oImageDao.myimages(user_id);
    }

    public LikeEntity like(Integer user_id, Integer image_id) {
        if (oImageDao.findlike(user_id, image_id) != null) {
            oImageDao.removelike(user_id, image_id);
        } else {
            oImageDao.saveLike(user_id, image_id);
        }
        return oImageDao.findlike(user_id, image_id);
    }

    public List<ImageEntity> findFilter(String filter) {
        return oImageDao.findFilter(filter);
    }

    public List<ImageEntity> getAllByCategory(Integer category_id) {
        return oImageDao.getAllByCategory(category_id);
    }

}
