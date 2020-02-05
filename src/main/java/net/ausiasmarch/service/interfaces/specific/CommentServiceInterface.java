/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service.interfaces.specific;

import java.util.List;
import net.ausiasmarch.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author espar
 * @param <T>
 */
public interface CommentServiceInterface<T extends CommentEntity> {
    
    	T get(int id);

	List<T> getall();

	Long count();

	Page<T> getPage(Pageable oPageable);

	Boolean delete(int id);

	T create(T oEntity);

	T update(T oEntity);
}
