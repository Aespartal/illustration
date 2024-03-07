/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.web.rest;

import java.util.List;
import java.util.Optional;

import net.ausiasmarch.service.dto.CategoryDTO;
import net.ausiasmarch.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO result = categoryService.save(categoryDTO);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping("/category")
    public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO result = categoryService.save(categoryDTO);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> get(@PathVariable Integer id) {
        Optional<CategoryDTO> categoryDTO = categoryService.findOne(id);
        return categoryDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> categoryDTOs = categoryService.findAll();
        return ResponseEntity
                .ok()
                .body(categoryDTOs);
    }

    @GetMapping("/category/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(categoryService.count(), HttpStatus.OK);
    }

    @GetMapping("/category/getpage/{page}/{rpp}")
    public ResponseEntity<List<CategoryDTO>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        Page<CategoryDTO> oPage = categoryService.getPage(oPageable);
        return ResponseEntity.ok()
                .body(oPage.getContent());
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id) {
        categoryService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
