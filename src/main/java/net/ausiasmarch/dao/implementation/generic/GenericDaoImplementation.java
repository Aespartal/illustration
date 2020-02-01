package net.ausiasmarch.dao.implementation.generic;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public abstract class GenericDaoImplementation<T extends GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {

    @Autowired
    protected JpaRepository oJpaRepository;

    @Autowired
    public GenericDaoImplementation(JpaRepository oJpaRepository) {
        this.oJpaRepository = oJpaRepository;
    }

    @Override
    public GenericEntityInterface get(int id) {
        return (GenericEntityInterface) oJpaRepository.getOne(id);
    }

    @Override
    public List<GenericEntityInterface> getall() {
        return oJpaRepository.findAll();
    }

    @Override
    public Long count() {
        return oJpaRepository.count();
    }

    @Override
    public Page<GenericEntityInterface> getPage(Pageable oPageable) {
        return oJpaRepository.findAll(oPageable);
    }

    @Override
    public Boolean delete(int id) {
        oJpaRepository.deleteById(id);
        return !oJpaRepository.existsById(id);
    }

    @Override
    public GenericEntityInterface create(GenericEntityInterface oBean) {
        return (GenericEntityInterface) oJpaRepository.save(oBean);
    }

    @Override
    public GenericEntityInterface update(GenericEntityInterface oBean) {
        if (oJpaRepository.existsById(oBean.getId())) {
            return (GenericEntityInterface) oJpaRepository.save(oBean);
        } else {
            return null; // throw new Exception("mensaje")
        }
    }

}
