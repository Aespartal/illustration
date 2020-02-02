package net.ausiasmarch.service.implementation.specific;

import java.util.Map;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ausiasmarch.dao.implementation.specific.UserDao;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import net.ausiasmarch.service.interfaces.specific.UserServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class UserService extends GenericServiceImplementation implements UserServiceInterface {

	protected UserDao oUserDao;

	@Autowired
	public UserService(UserDao oUserDao) {
		super(oUserDao);
	}

	@Override
	public UserEntity login(Map<String, String> mParametros) {
		UserEntity oUserEntity = new UserEntity();
		oUserEntity.setUsername(mParametros.get("username"));
		oUserEntity.setPassword(mParametros.get("password"));
		return (UserEntity) oUserDao.login(oUserEntity);
	}
}
