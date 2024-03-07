
package net.ausiasmarch.service.impl;
import net.ausiasmarch.service.dto.CategoryDTO;
import net.ausiasmarch.domain.mapper.CategoryMapper;
import net.ausiasmarch.repository.CategoryRepository;
import net.ausiasmarch.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private  CategoryRepository categoryRepository;
	@Autowired
	private  CategoryMapper categoryMapper;

	@Override
	public CategoryDTO get(int id) {
		return null;
	}

	@Override
	public List<CategoryDTO> findAll() {
		return categoryRepository.findAll()
				.stream()
				.map(categoryMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public Long count() {
		return categoryRepository.count();
	}

	@Override
	public Page<CategoryDTO> getPage(Pageable oPageable) {
		return categoryRepository.findAll(oPageable)
				.map(categoryMapper::toDto);
	}

	@Override
	public Boolean delete(int id) {
		return categoryRepository.findById(id)
				.map(category -> {
					categoryRepository.delete(category);
					return true;
				})
				.orElse(false);
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDTO)));
	}

	@Override
	public Optional<CategoryDTO> findOne(Integer id) {
		return categoryRepository.findById(id)
				.map(categoryMapper::toDto);
	}

}
