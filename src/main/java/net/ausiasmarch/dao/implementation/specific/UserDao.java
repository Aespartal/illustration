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
@Qualifier("UserDao")
public class UserDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {

	protected UserDaoJpaInterface oUserRepository;

	@Autowired
	public UserDao(UserDaoJpaInterface oUserRepository) {
		super(oUserRepository);
	}

	public UserEntity login(UserEntity oUserEntity) {
            System.out.print("Ha pasado por aqui");
            UserEntity oUserEntity2 = oUserRepository.findByLogin(oUserEntity.getUsername(),
                    oUserEntity.getPassword());
            
		return oUserEntity2;
                
	}

}
