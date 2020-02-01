package net.ausiasmarch.constroller;

import java.util.List;

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

import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import net.ausiasmarch.entity.RoleEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.implementation.specific.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    @Qualifier("oRoleService")
    GenericServiceImplementation oRoleService;

    @GetMapping("/{id}")
    public ResponseEntity<RoleEntity> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((RoleEntity) oRoleService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<RoleEntity>> get() {
        return new ResponseEntity<>(oRoleService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oRoleService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<RoleEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oRoleService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oRoleService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/") //@RequestParam para uso parametro a parametro
    public ResponseEntity<RoleEntity> create(@RequestBody GenericEntityInterface oRoleEntity) {
        return new ResponseEntity<>((RoleEntity) oRoleService.create(oRoleEntity), HttpStatus.OK);
    }

    @PutMapping("/") //@RequestParam para uso parametro a parametro
    public ResponseEntity<RoleEntity> update(@RequestBody GenericEntityInterface oRoleEntity) {
        return new ResponseEntity<>((RoleEntity) oRoleService.update(oRoleEntity), HttpStatus.OK);
    }

}
