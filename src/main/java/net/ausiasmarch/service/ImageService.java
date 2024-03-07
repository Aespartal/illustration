/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service;

import net.ausiasmarch.domain.Like;
import net.ausiasmarch.service.dto.ImageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 * @author espar
 */
public interface ImageService {
    
	ImageDTO findOne(Integer id);
	List<ImageDTO> findAll();
	Long count();
	Page<ImageDTO> getPage(Pageable oPageable);
	Boolean delete(Integer id);
	ImageDTO save(ImageDTO imageDTO);
	List<ImageDTO> findFilter(String title);
	Like like(Integer usuario_id, Integer image_id);
	List<ImageDTO> popular(Pageable oPageable);
	List<ImageDTO> imageslikes(Integer userId);
	List<ImageDTO> favourite(Integer userId);
	List<ImageDTO> myimages(Integer userId);
	List<ImageDTO> getAllByCategory(Integer categoryId);
	List<ImageDTO> getPageImgFollows(Pageable oPageable, Integer userId);
	Integer countLikes(Integer imageId);
}
