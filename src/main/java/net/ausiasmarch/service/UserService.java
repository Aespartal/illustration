/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service;

import java.util.List;
import java.util.Optional;

import net.ausiasmarch.domain.Follower;
import net.ausiasmarch.domain.User;
import net.ausiasmarch.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author espar
 */
public interface UserService {

	UserDTO save(UserDTO userDTO);

	Optional<UserDTO> findOne(Integer id);
	List<UserDTO> findAll();
	Long count();
	@Transactional(readOnly = true)
	Optional<UserDTO> getUsername(String username);
	Follower follow(Integer userId, Integer imageId);
	@Transactional(readOnly = true)
	Boolean findFollow(Integer userId, Integer friendId);
	@Transactional(readOnly = true)
	Integer countFolloweds(Integer userId);
	@Transactional(readOnly = true)
	Integer countFollowers(Integer userId);
	@Transactional(readOnly = true)
	List<UserDTO> getFolloweds(Pageable oPageable, int userId);
	@Transactional(readOnly = true)
	List<UserDTO> getFollowers(Pageable oPageable, int userId);
	@Transactional(readOnly = true)
	Page<UserDTO> getPage(Pageable oPageable);
	Boolean delete(int id);
	Optional<UserDTO> findOneByUsername(String username);

	Optional<UserDTO> getCurrentUserAsDTO();

	Optional<User> getCurrentUser();

	Optional<User> getUserWithAuthorities();

	@Transactional(readOnly = true)
    Optional<User> findOneWithAuthoritiesByUsername(String lowercaseLogin);
}
