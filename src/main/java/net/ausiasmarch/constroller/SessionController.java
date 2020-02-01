package net.ausiasmarch.constroller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.implementation.specific.UserService;
import org.springframework.beans.factory.annotation.Qualifier;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    HttpSession oSession;

    @Autowired
    @Qualifier("UserService")
    UserService oUserService;

    @GetMapping("/") // check
    public ResponseEntity<UserEntity> check() {
        UserEntity oUserEntity = (UserEntity) oSession.getAttribute("usuario");
        return new ResponseEntity<>(oUserEntity, HttpStatus.OK);
    }

    @DeleteMapping("/") // logout
    public ResponseEntity<Boolean> logout(@PathVariable(value = "id") int id) {
        oSession.invalidate();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/") // login
    public ResponseEntity<UserEntity> login(@RequestParam Map<String, String> mParametros) {
        return new ResponseEntity<>(oUserService.login(mParametros), HttpStatus.OK);
    }

}
