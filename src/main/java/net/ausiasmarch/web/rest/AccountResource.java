package net.ausiasmarch.web.rest;

import net.ausiasmarch.errors.CurrentUserNotFoundException;
import net.ausiasmarch.service.UserService;
import net.ausiasmarch.service.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping()
public class AccountResource {

    private final UserService userService;

    public AccountResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    @GetMapping("/account")
    public UserDTO getAccount() throws CurrentUserNotFoundException {
        return userService
                .getUserWithAuthorities()
                .map(UserDTO::new)
                .orElseThrow(CurrentUserNotFoundException::new);
    }
}
