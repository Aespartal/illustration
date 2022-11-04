/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.api;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.entity.CategoryEntity;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.specific.CategoryService;
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

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService oCategoryService;

    @Autowired
    HttpSession oSession;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((CategoryEntity) oCategoryService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CategoryEntity>> get() {
        return new ResponseEntity<>(oCategoryService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oCategoryService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<CategoryEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oCategoryService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
        if (!user().isPresent() || user().get().getId().equals(1)) {
            return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(oCategoryService.delete(id), HttpStatus.OK);
        }
    }

    @PostMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<?> create(@RequestBody CategoryEntity oCategoryEntity) {
        if (!user().isPresent() || user().get().getId().equals(1)) {
            return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>((CategoryEntity) oCategoryService.create(oCategoryEntity), HttpStatus.OK);
        }
    }

    @PutMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<?> update(@RequestBody CategoryEntity oCategoryEntity) {
        if (!user().isPresent() || !user().get().getRole().getId().equals(1)) {
            return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>((CategoryEntity) oCategoryService.update(oCategoryEntity), HttpStatus.OK);
        }
    }

    public Optional<UserEntity> user() {
        return (Optional<UserEntity>) oSession.getAttribute("username");
    }
}
