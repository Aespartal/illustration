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

        boolean state;

        if (!oImageDao.findlike(user_id, image_id)) {
            oImageDao.removelike(user_id, image_id);
            System.out.print("Ha quitado el like");
            state = true;                                           //Devuelve true si ya ha dado like a esa imagen y lo quita
        } else {
            oImageDao.saveLike(user_id, image_id);
            System.out.print("Ha dado a like");
            state = false;                                           //Devuelve false si no ha dado like a esa imagen y le da like
        }

        return state;

    }
}
