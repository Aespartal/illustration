package net.ausiasmarch.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import net.ausiasmarch.domain.User;
import net.ausiasmarch.repository.FollowerRepository;
import net.ausiasmarch.repository.UserRepository;
import net.ausiasmarch.security.SecurityUtils;
import net.ausiasmarch.service.dto.UserDTO;
import net.ausiasmarch.domain.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.ausiasmarch.domain.Follower;
import net.ausiasmarch.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FollowerRepository followerRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, FollowerRepository followerRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.followerRepository = followerRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(userDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUsername(String username) {
        return userRepository.findOneByUsername(username)
                .map(userMapper::userToUserDTO);
    }

    @Override
    public Follower follow(Integer userId, Integer friendId) {
        Follower oFollower = followerRepository.findFollower(userId, friendId);
        if (oFollower != null) {
            followerRepository.unFollow(userId, friendId);
        } else {
            followerRepository.follow(userId, friendId);
        }
        return oFollower;

    }

    @Override
    @Transactional(readOnly = true)
    public Boolean findFollow(Integer userId, Integer friendId) {
        return followerRepository.findFollower(userId, friendId) != null;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countFolloweds(Integer userId) {
        return followerRepository.countFolloweds(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countFollowers(Integer userId) {
        return followerRepository.countFollowers(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getFolloweds(Pageable oPageable, int userId) {
        return userRepository.getFolloweds(oPageable.getOffset(), oPageable.getPageSize(), userId).stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getFollowers(Pageable oPageable, int userId) {
        return userRepository.getFollowers(oPageable.getOffset(), oPageable.getPageSize(), userId).stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<UserDTO> getPage(Pageable oPageable) {
        return userRepository.findAll(oPageable).map(userMapper::userToUserDTO);
    }

    @Override
    public Boolean delete(int id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Long count() {
        return userRepository.count();
    }



    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findOne(Integer id) {
        Optional<User> oUserEntity = userRepository.findById(id);
        return oUserEntity.map(userMapper::userToUserDTO);
    }
    @Override
    public Optional<UserDTO> findOneByUsername(String username) {
        return userRepository.findOneByUsername(username).map(userMapper::userToUserDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getCurrentUserAsDTO() {
        return getCurrentUser().map(userMapper::userToUserDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        Optional<String> login = SecurityUtils.getCurrentUserLogin();
        return login.flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }

    @Override
    public Optional<User> findOneWithAuthoritiesByUsername(String lowercaseLogin) {
        return userRepository.findOneWithAuthoritiesByUsername(lowercaseLogin);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getCurrentUser() {
        return getUserWithAuthorities().flatMap(user -> userRepository.findById(user.getId()));
    }
}
