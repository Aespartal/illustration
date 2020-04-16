package net.ausiasmarch.service.implementation.specific;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ausiasmarch.dao.implementation.specific.UserDao;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import net.ausiasmarch.service.interfaces.specific.UserServiceInterface;

@Service
public class UserService extends GenericServiceImplementation implements GenericServiceInterface, UserServiceInterface {

    @Autowired
    protected UserDao oUserDao;

    @Autowired
    public UserService(UserDao oUserDao) {
        super(oUserDao);
    }

    @Override
    public UserEntity login(Map<String, String> mParametros) {
        return oUserDao.login(mParametros.get("username"), mParametros.get("password"));
    }

     public UserEntity getUsername(String username) {
        return oUserDao.getUsername(username);
    }
    
    public UserEntity findUserByImage(Integer image_id) {
        return oUserDao.findUserByImage(image_id);
    }
    
    
}
