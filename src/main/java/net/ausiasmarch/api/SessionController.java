package net.ausiasmarch.api;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.specific.UserService;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    HttpSession oSession;

    @Autowired
    UserService oUserService;

    @GetMapping("/") // check
    public ResponseEntity<UserEntity> check() {
        System.out.println(oSession.getAttribute("username"));
        return new ResponseEntity<UserEntity>((UserEntity) oSession.getAttribute("username"), HttpStatus.OK);
    }

    @DeleteMapping("/") // logout
    public ResponseEntity<Boolean> logout() {
        oSession.invalidate();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/") // login
    public ResponseEntity<UserEntity> login(@RequestBody Map<String, String> mParametros) {
        oSession.setAttribute("username", oUserService.login(mParametros));
        return new ResponseEntity<UserEntity>((UserEntity) oSession.getAttribute("username"), HttpStatus.OK);
    }

}
