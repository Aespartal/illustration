package net.ausiasmarch.dao.implementation.specific;

import org.springframework.beans.factory.annotation.Autowired;

import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import net.ausiasmarch.dao.interfaces.specific.RoleDaoJpaInterface;

@Repository
@Qualifier("RoleDao")
public class RoleDao extends GenericDaoImplementation implements GenericDaoInterface {

    @Autowired
    public RoleDao(@Qualifier("RoleDaoJpaInterface")RoleDaoJpaInterface oRoleRepository) {
        super(oRoleRepository);
    }

}
