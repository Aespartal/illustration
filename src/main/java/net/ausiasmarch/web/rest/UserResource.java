package net.ausiasmarch.web.rest;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import net.ausiasmarch.domain.Authority;
import net.ausiasmarch.domain.Follower;
import net.ausiasmarch.domain.FollowerId;
import net.ausiasmarch.domain.User;
import net.ausiasmarch.domain.mapper.UserMapper;
import net.ausiasmarch.service.UserService;
import net.ausiasmarch.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.ausiasmarch.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class UserResource {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserResource(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/user/me")
    public ResponseEntity<UserDTO> getCurrentUser() {
        Optional<UserDTO> userDTO = userService.getCurrentUserAsDTO();
        return userDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable(value = "id") int id) {
        Optional<UserDTO> userDTOOptional = userService.findOne(id);
        return userDTOOptional.map(userDTO -> ResponseEntity.ok().body(userDTO)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/name/{username}")
    public ResponseEntity<UserDTO> getUsername(@PathVariable(value = "username") String username) {
        Optional<UserDTO> userDTO = userService.getUsername(username);
        return userDTO.map(userDTO1 -> ResponseEntity.ok().body(userDTO1)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/getall")
    public ResponseEntity<List<UserDTO>> get() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/user/count")
    public ResponseEntity<Long> count() {
        return  ResponseEntity.ok().body(userService.count());
    }
    
    @GetMapping("/user/countfolloweds/{user_id}")
    public ResponseEntity<Integer> countFolloweds(@PathVariable(value = "user_id") int userId) {
        return ResponseEntity.ok().body(userService.countFolloweds(userId));
    }

    @GetMapping("/user/countfollowers/{user_id}")
    public ResponseEntity<Integer> countFollowers(@PathVariable(value = "user_id") int userId) {
        return  ResponseEntity.ok().body(userService.countFollowers(userId));
    }

    @GetMapping("/user/getpage/{page}/{rpp}")
    public ResponseEntity<Page<UserDTO>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return ResponseEntity.ok().body(userService.getPage(oPageable));
    }
    //Los que sigue al usuario
    @GetMapping("/user/getfollowers/{page}/{rpp}/{id}")
    public ResponseEntity<List<UserDTO>> getFolloweds(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp,
            @PathVariable(value = "id") int userId) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return ResponseEntity.ok().body(userService.getFolloweds(oPageable, userId));
    }

    @GetMapping("/user/getfolloweds/{page}/{rpp}/{id}")
    public ResponseEntity<List<UserDTO>> getfollowers(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp,
            @PathVariable(value = "id") int userId) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp); 
        return ResponseEntity.ok().body(userService.getFollowers(oPageable, userId));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok().body(userService.delete(id));
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.save(userDTO));
    }

    @PutMapping("/user")
    public ResponseEntity<UserDTO> update(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body( userService.save(userDTO));
    }

    @PostMapping("/user/follow")
    public ResponseEntity<Follower> follow(@RequestBody FollowerId mParametros) {
        Integer userId = mParametros.getUser_id();
        Integer friendId = mParametros.getFriend_id();
        return ResponseEntity.ok().body(userService.follow(userId, friendId));
    }
    
    @GetMapping("/user/findfollow/{user_id}/{friend_id}")
    public ResponseEntity<Boolean> findfollow(@PathVariable(value = "user_id") Integer userId,
            @PathVariable(value = "friend_id") Integer friendId) {
        return ResponseEntity.ok().body(userService.findFollow(userId, friendId));
    }
}
