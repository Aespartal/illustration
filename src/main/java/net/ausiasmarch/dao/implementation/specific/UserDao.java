package net.ausiasmarch.dao.implementation.specific;

import java.util.List;
import java.util.Optional;

import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.entity.dto.UserDTO;
import net.ausiasmarch.entity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.dao.interfaces.specific.FollowerDaoJpaInterface;
import net.ausiasmarch.dao.interfaces.specific.UserDaoJpaInterface;
import net.ausiasmarch.entity.FollowerEntity;
import net.ausiasmarch.entity.FollowerId;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.springframework.data.domain.Pageable;

@Repository
public class UserDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {
    
    @Autowired
    protected UserDaoJpaInterface oUserRepository;
    @Autowired
    protected FollowerDaoJpaInterface oFollowRepository;
    
    @Autowired
    public UserDao(
            UserDaoJpaInterface oUserRepository) {
        super(oUserRepository);
    }

    public Optional<UserEntity> login(String login, String password) {
        return oUserRepository.findByLogin(login, password);
    }
    
     public Optional<UserEntity> getUsername(String username) {
        return oUserRepository.getUsername(username);
    }

    public Optional<UserEntity> findUserByImage(Integer image_id) {
        return oUserRepository.findUserByImage(image_id);
    }

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

    public Integer countFolloweds(Integer user_id){
      return oFollowRepository.countFolloweds(user_id);
    }

     public Integer countFollowers(Integer user_id){
      return oFollowRepository.countFollowers(user_id);
    }

    public List<UserEntity> getUsersChat(Integer user_id) {
        return oUserRepository.getUsersChat(user_id);
    }

     public List<UserEntity> getFolloweds(Pageable oPageable, Integer user_id){
        return oUserRepository.getFolloweds(oPageable.getPageNumber(), oPageable.getPageSize(), user_id);
    }
     public List<UserEntity> getFollowers(Pageable oPageable, Integer user_id){
        return oUserRepository.getFollowers(oPageable.getPageNumber(), oPageable.getPageSize(), user_id);
    }

    public List<UserEntity> findAll() {
        return oUserRepository.findAll();
    }

    public Optional<UserEntity> findOneByUsername(String username) {
        return oUserRepository.findOneByUsername(username);
    }
}
