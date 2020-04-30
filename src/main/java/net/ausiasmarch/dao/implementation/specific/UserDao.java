package net.ausiasmarch.dao.implementation.specific;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.dao.interfaces.specific.FollowerDaoJpaInterface;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.dao.interfaces.specific.UserDaoJpaInterface;
import net.ausiasmarch.entity.FollowerEntity;
import net.ausiasmarch.entity.FollowerId;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;

@Repository
public class UserDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {
    
    @Autowired
    protected UserDaoJpaInterface oUserRepository;
    @Autowired
    protected FollowerDaoJpaInterface oFollowRepository;
    
    @Autowired
    public UserDao(UserDaoJpaInterface oUserRepository) {
        super(oUserRepository);
    }

    public UserEntity login(String login, String password) {
        return oUserRepository.findByLogin(login, password);
    }
    
     public UserEntity getUsername(String username) {
        return oUserRepository.getUsername(username);
    }

    public UserEntity findUserByImage(Integer image_id){
        return oUserRepository.findUserByImage(image_id);
    }
    
    //-----FOLLOW
            public FollowerEntity findFollower(Integer user_id, Integer friend_id){
            if(oFollowRepository.findFollower(user_id,friend_id) == null){
                return null;
            } else {
                FollowerId oFollowed = new FollowerId(user_id, friend_id);
                FollowerEntity oFollowerEntity = new FollowerEntity(oFollowed);
                return oFollowerEntity;
            } 
        }
        public void unFollow(Integer user_id, Integer friend_id){
              oFollowRepository.unFollow(user_id,friend_id);
        }
         public void follow(Integer user_id, Integer friend_id){
             oFollowRepository.follow(user_id,friend_id);
         
        }
}
