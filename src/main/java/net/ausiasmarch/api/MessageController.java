/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.api;

import java.util.List;
import net.ausiasmarch.entity.MessageEntity;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import net.ausiasmarch.service.implementation.specific.MessageService;
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
@RequestMapping("/messages")
public class MessageController {
    
    @Autowired
    MessageService oMessageService;

    @GetMapping("/{id}")
    public ResponseEntity<MessageEntity> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((MessageEntity) oMessageService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<MessageEntity>> get() {
        return new ResponseEntity<>(oMessageService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oMessageService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<MessageEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oMessageService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oMessageService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<MessageEntity> create(@RequestBody GenericEntityInterface oMessageEntity) {
        return new ResponseEntity<>((MessageEntity) oMessageService.create(oMessageEntity), HttpStatus.OK);
    }

    @PutMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<MessageEntity> update(@RequestBody GenericEntityInterface oMessageEntity) {
        return new ResponseEntity<>((MessageEntity) oMessageService.update(oMessageEntity), HttpStatus.OK);
    }
}
