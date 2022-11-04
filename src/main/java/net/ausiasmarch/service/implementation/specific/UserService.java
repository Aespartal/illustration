package net.ausiasmarch.service.implementation.specific;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.entity.dto.UserDTO;
import net.ausiasmarch.entity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.ausiasmarch.dao.implementation.specific.UserDao;
import net.ausiasmarch.entity.FollowerEntity;
import net.ausiasmarch.service.interfaces.specific.UserServiceInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserServiceInterface {
    @Autowired
    private final UserDao oUserDao;

    private final UserMapper userMapper;

    public UserService(UserDao oUserDao, UserMapper userMapper) {
        this.oUserDao = oUserDao;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> login(Map<String, String> mParametros) {
        return oUserDao.login(mParametros.get("username"), mParametros.get("password"))
                .map(userMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUsername(String username) {
        return oUserDao.getUsername(username)
                .map(userMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> findUserByImage(Integer image_id) {
        return oUserDao.findUserByImage(image_id)
                .map(userMapper::toDto);
    }

    @Override
    public FollowerEntity follow(Integer user_id, Integer friend_id) {
        FollowerEntity oFollowerEntity = oUserDao.findFollower(user_id, friend_id);
        if (oFollowerEntity != null) {
            oUserDao.unFollow(user_id, friend_id);
        } else {
            oUserDao.follow(user_id, friend_id);
        }
        return oFollowerEntity;

    }

    @Override
    @Transactional(readOnly = true)
    public Boolean findFollow(Integer user_id, Integer friend_id) {
        return oUserDao.findFollower(user_id, friend_id) != null;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countFolloweds(Integer user_id) {
        return oUserDao.countFolloweds(user_id);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countFollowers(Integer user_id) {
        return oUserDao.countFollowers(user_id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getUsersChat(Integer user_id) {
        return oUserDao.getUsersChat(user_id).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getFolloweds(Pageable oPageable, int user_id) {
        return oUserDao.getFolloweds(oPageable, user_id).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getFollowers(Pageable oPageable, int user_id) {
        return oUserDao.getFollowers(oPageable, user_id).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<UserDTO> getPage(Pageable oPageable) {
        return oUserDao.getPage(oPageable)
                .map(userMapper::toGenericDTO);
    }

    public Boolean delete(int id) {
        return oUserDao.delete(id);
    }

    public UserDTO create(UserEntity oUserBean) {
        return userMapper.toDto((UserEntity) oUserDao.create(oUserBean));
    }

    public UserDTO update(UserEntity oUserBean) {
        return userMapper.toDto((UserEntity) oUserDao.update(oUserBean));
    }

    public Long count() {
        return oUserDao.count();
    }

    public List<UserDTO> findAll() {
        return oUserDao.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO findOne(int id) {
        return userMapper.toDto((UserEntity) oUserDao.get(id));
    }

    public Optional<UserEntity> findOneByUsername(String username) {
        return oUserDao.findOneByUsername(username);
    }
}
