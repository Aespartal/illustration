/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service.implementation.generic;

import java.util.List;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImplementation<T extends GenericEntityInterface>
		implements GenericServiceInterface<GenericEntityInterface> {

	@Autowired
	protected GenericDaoImplementation<?> oGenericDaoImplementation;

	@Autowired
	public GenericServiceImplementation(GenericDaoImplementation<?> oGenericDaoImplementation) {
		this.oGenericDaoImplementation = oGenericDaoImplementation;
	}

	@Override
	public GenericEntityInterface get(int id) {
		return (GenericEntityInterface) oGenericDaoImplementation.get(id);
	}

	@Override
	public List<GenericEntityInterface> getall() {
		return oGenericDaoImplementation.getall();
	}

	@Override
	public Long count() {
		return oGenericDaoImplementation.count();
	}

	@Override
	public Page<GenericEntityInterface> getPage(Pageable oPageable) {
		return oGenericDaoImplementation.getPage(oPageable);
	}

	@Override
	public Boolean delete(int id) {
		return oGenericDaoImplementation.delete(id);
	}

	@Override
	public GenericEntityInterface create(GenericEntityInterface oEntity) {
		return (GenericEntityInterface) oGenericDaoImplementation.create(oEntity);
	}

	@Override
	public GenericEntityInterface update(GenericEntityInterface oEntity) {
		return (GenericEntityInterface) oGenericDaoImplementation.update(oEntity);
	}

}
