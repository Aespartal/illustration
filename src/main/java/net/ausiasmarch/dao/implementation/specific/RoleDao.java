package net.ausiasmarch.dao.implementation.specific;

import org.springframework.beans.factory.annotation.Autowired;

import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import net.ausiasmarch.dao.interfaces.specific.RoleDaoJpaInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@Qualifier("roledao")
public class RoleDao extends GenericDaoImplementation implements GenericDaoInterface {

	protected RoleDaoJpaInterface oRoleRepository;

	@Autowired
	public RoleDao(RoleDaoJpaInterface oRoleRepository) {
		super(oRoleRepository);
	}

}
