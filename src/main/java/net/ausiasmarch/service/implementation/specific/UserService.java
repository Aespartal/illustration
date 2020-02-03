package net.ausiasmarch.service.implementation.specific;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ausiasmarch.dao.implementation.specific.UserDao;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;

@Service
public class UserService extends GenericServiceImplementation implements GenericServiceInterface {
        @Autowired
        protected UserDao oUserDao;
        
	@Autowired
	public UserService(UserDao oUserDao) {
		super(oUserDao);
	}

        
        public UserEntity login(Map<String, String> mParametros) {
		return oUserDao.login(mParametros.get("username"), mParametros.get("password"));
	}

}
