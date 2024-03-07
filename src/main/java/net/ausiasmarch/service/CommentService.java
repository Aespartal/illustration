/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service;

import java.util.List;

import net.ausiasmarch.service.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author espar
 */
public interface CommentService {
    
	CommentDTO get(int id);

	List<CommentDTO> findAll();

	Long count();

	Page<CommentDTO> getPage(Pageable oPageable);

	Boolean delete(int id);

	CommentDTO save(CommentDTO commentDTO);

	Long countByImageId(int id);

	List<CommentDTO> findAllById(Integer id);
}
