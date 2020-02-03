/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service.implementation.generic;

import java.util.List;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImplementation<T extends GenericEntityInterface>
		implements GenericServiceInterface<GenericEntityInterface> {

	protected GenericDaoInterface<GenericEntityInterface> oDao;

	public GenericServiceImplementation(GenericDaoImplementation<GenericEntityInterface> oDao) {
		this.oDao = oDao;
	}

	@Override
	public GenericEntityInterface get(int id) {
		return (GenericEntityInterface) oDao.get(id);
	}

	@Override
	public List<GenericEntityInterface> getall() {
		return oDao.getall();
	}

	@Override
	public Long count() {
		return oDao.count();
	}

	@Override
	public Page<GenericEntityInterface> getPage(Pageable oPageable) {
		return oDao.getPage(oPageable);
	}

	@Override
	public Boolean delete(int id) {
		return oDao.delete(id);
	}

	@Override
	public GenericEntityInterface create(GenericEntityInterface oEntity) {
		return (GenericEntityInterface) oDao.create(oEntity);
	}

	@Override
	public GenericEntityInterface update(GenericEntityInterface oEntity) {
		return (GenericEntityInterface) oDao.update(oEntity);
	}

}
