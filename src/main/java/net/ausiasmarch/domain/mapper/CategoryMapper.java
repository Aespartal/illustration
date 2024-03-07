package net.ausiasmarch.domain.mapper;

import net.ausiasmarch.domain.Category;
import net.ausiasmarch.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
    CategoryDTO toDto(Category category);

    Category toEntity(CategoryDTO categoryDTO);

    default Category fromId(Integer id) {
        if (id == null) {
            return null;
        }
        Category category = new Category();
        category.setId(id);
        return category;
    }
}
