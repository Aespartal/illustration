package net.ausiasmarch.service.implementation.specific;

import java.util.Map;
import net.ausiasmarch.dao.implementation.specific.ImageDao;
import net.ausiasmarch.entity.ImageEntity;
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

    public Boolean like(Map<Integer, Integer> mParametros) {
        Integer user_id = mParametros.get("user_id");
        Integer image_id = mParametros.get("image_id");
        return oImageDao.existLike(user_id,image_id);
    }
}
