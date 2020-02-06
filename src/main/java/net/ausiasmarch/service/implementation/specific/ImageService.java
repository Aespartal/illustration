package net.ausiasmarch.service.implementation.specific;

import net.ausiasmarch.dao.implementation.specific.ImageDao;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService extends GenericServiceImplementation implements GenericServiceInterface {

    @Autowired
    protected ImageDao oImageDao;

    @Autowired
    public ImageService(ImageDao oImageDao) {
        super(oImageDao);
    }

    public Boolean like(Integer user_id, Integer image_id) {
        Boolean state;
        if (oImageDao.findlike(user_id, image_id) == false) {
            oImageDao.removelike(user_id, image_id);
            state = false;
        } else {
            oImageDao.saveLike(user_id, image_id);
            state = true;
        }
        return state;
    }
}
