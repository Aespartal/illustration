package net.ausiasmarch.dao.interfaces.generic;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.entity.interfaces.GenericEntityInterface;

public interface GenericDaoInterface<T extends GenericEntityInterface> {

	T get(int id);

	List<T> getall();

	Long count();

	Page<T> getPage(Pageable oPageable);

	Boolean delete(int id);

	T create(T oBean);

	T update(T oBean);

}