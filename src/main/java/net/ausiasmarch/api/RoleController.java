package net.ausiasmarch.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.entity.RolEntity;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.specific.RoleService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService oRoleService;

    @Autowired
    HttpSession oSession;

    @GetMapping("/{id}")
    public ResponseEntity<RolEntity> get(@PathVariable(value = "id") int id) { 
        return new ResponseEntity<>((RolEntity) oRoleService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<RolEntity>> get() {
        return new ResponseEntity<>(oRoleService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oRoleService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<RolEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oRoleService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oRoleService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RolEntity> create(@RequestBody RolEntity oRoleEntity) {
        return new ResponseEntity<>((RolEntity) oRoleService.create(oRoleEntity), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<RolEntity> update(@RequestBody RolEntity oRoleEntity) {
        return new ResponseEntity<>((RolEntity) oRoleService.update(oRoleEntity), HttpStatus.OK);
    }

}
