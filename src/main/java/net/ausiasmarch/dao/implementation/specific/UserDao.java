package net.ausiasmarch.dao.implementation.specific;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.dao.interfaces.specific.UserDaoJpaInterface;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;

@Repository
public class UserDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {
    
    @Autowired
    protected UserDaoJpaInterface oUserRepository;

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
}
