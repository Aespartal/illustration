package net.ausiasmarch.service.implementation.specific;

import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.implementation.specific.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;

@Service
@Qualifier("oRoleService")
public class RoleService extends GenericServiceImplementation implements GenericServiceInterface {

    @Autowired
    public RoleService(RoleDao oRoleDao) {
        super(oRoleDao);
    }

}
