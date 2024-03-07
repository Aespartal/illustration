/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service;

import net.ausiasmarch.service.dto.CategoryDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author espar
 */
public interface CategoryService {
    
	CategoryDTO get(int id);

	List<CategoryDTO> findAll();

	Long count();

	Page<CategoryDTO> getPage(Pageable oPageable);

	Boolean delete(int id);

	CategoryDTO save(CategoryDTO categoryDTO);

	Optional<CategoryDTO> findOne(Integer id);
}
