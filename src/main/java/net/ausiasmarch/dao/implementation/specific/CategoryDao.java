package net.ausiasmarch.dao.implementation.specific;

import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.dao.interfaces.specific.CategoryDaoJpaInterface;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {

    @Autowired
    protected CategoryDaoJpaInterface oCategoryRepository;

    @Autowired
    public CategoryDao(CategoryDaoJpaInterface oCategoryRepository) {
        super(oCategoryRepository);
    }
}
