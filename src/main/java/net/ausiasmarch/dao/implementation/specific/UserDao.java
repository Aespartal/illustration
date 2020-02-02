package net.ausiasmarch.dao.implementation.specific;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.dao.interfaces.specific.UserDaoJpaInterface;

@Repository
@Qualifier("userdao")
public class UserDao extends GenericDaoImplementation implements GenericDaoInterface {

	protected UserDaoJpaInterface oUserRepository;

	@Autowired
	public UserDao(UserDaoJpaInterface oUserRepository) {
		super(oUserRepository);
	}

	public UserEntity login(UserEntity oUsuarioEntity) {
		return oUserRepository.findByLogin(oUsuarioEntity.getUsername(), oUsuarioEntity.getPassword());
	}

}
