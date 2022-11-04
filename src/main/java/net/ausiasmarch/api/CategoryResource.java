/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.api;

import java.util.List;

import net.ausiasmarch.entity.CategoryEntity;
import net.ausiasmarch.service.implementation.specific.CategoryService;
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
@RequestMapping("/api")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((CategoryEntity) categoryService.get(id), HttpStatus.OK);
    }

    @GetMapping("/category/getall")
    public ResponseEntity<List<CategoryEntity>> get() {
        return new ResponseEntity<>(categoryService.getall(), HttpStatus.OK);
    }

    @GetMapping("/category/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(categoryService.count(), HttpStatus.OK);
    }

    @GetMapping("/category/getpage/{page}/{rpp}")
    public ResponseEntity<Page<CategoryEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(categoryService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/category") // @RequestParam para uso parametro a parametro
    public ResponseEntity<?> create(@RequestBody CategoryEntity oCategoryEntity) {
        return new ResponseEntity<>((CategoryEntity) categoryService.create(oCategoryEntity), HttpStatus.OK);
    }

    @PutMapping("/category") // @RequestParam para uso parametro a parametro
    public ResponseEntity<?> update(@RequestBody CategoryEntity oCategoryEntity) {
        return new ResponseEntity<>((CategoryEntity) categoryService.update(oCategoryEntity), HttpStatus.OK);
    }
}
