package net.ausiasmarch.service.implementation.specific;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ausiasmarch.dao.implementation.specific.UserDao;
import net.ausiasmarch.entity.FollowerEntity;
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

    public FollowerEntity follow(Integer user_id, Integer friend_id) {

        if (oUserDao.findFollower(user_id, friend_id) != null) {
            oUserDao.unFollow(user_id, friend_id);
        } else {
            oUserDao.follow(user_id, friend_id);
        }
        return oUserDao.findFollower(user_id, friend_id);

    }

    public Boolean findFollow(Integer user_id, Integer friend_id) {
        Boolean f = false;
        
        if (oUserDao.findFollower(user_id, friend_id) != null) {
            f = true;
        } else {
            f = false;
        }

        return f;
    }

    public Integer countFolloweds(Integer user_id) {
        return oUserDao.countFolloweds(user_id);
    }

    public Integer countFollowers(Integer user_id) {
        return oUserDao.countFollowers(user_id);
    }

    public List<UserEntity> getUsersChat(Integer user_id) {
        return oUserDao.getUsersChat(user_id);
    }
}
