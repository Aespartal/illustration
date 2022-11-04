/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service.interfaces.specific;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.ausiasmarch.entity.FollowerEntity;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.entity.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author espar
 */
public interface UserServiceInterface {
	Optional<UserDTO> login(Map<String, String> mParametros);

	@Transactional(readOnly = true)
	Optional<UserDTO> getUsername(String username);

	@Transactional(readOnly = true)
	Optional<UserDTO> findUserByImage(Integer image_id);

	FollowerEntity follow(Integer user_id, Integer friend_id);

	@Transactional(readOnly = true)
	Boolean findFollow(Integer user_id, Integer friend_id);

	@Transactional(readOnly = true)
	Integer countFolloweds(Integer user_id);

	@Transactional(readOnly = true)
	Integer countFollowers(Integer user_id);

	@Transactional(readOnly = true)
	List<UserDTO> getUsersChat(Integer user_id);

	@Transactional(readOnly = true)
	List<UserDTO> getFolloweds(Pageable oPageable, int user_id);

	@Transactional(readOnly = true)
	List<UserDTO> getFollowers(Pageable oPageable, int user_id);
}
