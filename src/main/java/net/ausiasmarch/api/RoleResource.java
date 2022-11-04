package net.ausiasmarch.api;

import java.util.List;

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
import net.ausiasmarch.service.implementation.specific.RoleService;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class RoleResource {

    private final RoleService oRoleService;

    public RoleResource(RoleService oRoleService) {
        this.oRoleService = oRoleService;
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<RolEntity> get(@PathVariable(value = "id") int id) { 
        return new ResponseEntity<>((RolEntity) oRoleService.get(id), HttpStatus.OK);
    }

    @GetMapping("/role/getall")
    public ResponseEntity<List<RolEntity>> get() {
        return new ResponseEntity<>(oRoleService.getall(), HttpStatus.OK);
    }

    @GetMapping("/role/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oRoleService.count(), HttpStatus.OK);
    }

    @GetMapping("/role/getpage/{page}/{rpp}")
    public ResponseEntity<Page<RolEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oRoleService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oRoleService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/role")
    public ResponseEntity<RolEntity> create(@RequestBody RolEntity oRoleEntity) {
        return new ResponseEntity<>((RolEntity) oRoleService.create(oRoleEntity), HttpStatus.OK);
    }

    @PutMapping("/role")
    public ResponseEntity<RolEntity> update(@RequestBody RolEntity oRoleEntity) {
        return new ResponseEntity<>((RolEntity) oRoleService.update(oRoleEntity), HttpStatus.OK);
    }

}
