/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.api;

import java.util.Calendar;
import java.util.List;

import net.ausiasmarch.entity.CommentEntity;
import net.ausiasmarch.entity.ImageEntity;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.specific.CommentService;
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
public class CommentResource {

    private final CommentService commentService;

    public CommentResource(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentEntity> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((CommentEntity) commentService.get(id), HttpStatus.OK);
    }

    @GetMapping("/comment/getall")
    public ResponseEntity<List<CommentEntity>> get() {
        return new ResponseEntity<>(commentService.getall(), HttpStatus.OK);
    }

    @GetMapping("/comment/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(commentService.count(), HttpStatus.OK);
    }
    
     @GetMapping("/comment/count/{id}")
    public ResponseEntity<Integer> count(@PathVariable(value = "id") int image_id) {
        return new ResponseEntity<>(commentService.countComments(image_id), HttpStatus.OK);
    }

    @GetMapping("/comment/getpage/{page}/{rpp}")
    public ResponseEntity<Page<CommentEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(commentService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(commentService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/comment/")
    public ResponseEntity<?> create(@RequestBody CommentEntity oCommentEntity) {
        return new ResponseEntity<>((CommentEntity) commentService.create(oCommentEntity), HttpStatus.OK);
    }

    @PutMapping("/comment")
    public ResponseEntity<CommentEntity> update(@RequestBody CommentEntity oCommentEntity) {
        return new ResponseEntity<>((CommentEntity) commentService.update(oCommentEntity), HttpStatus.OK);
    }

    @GetMapping("/comment/getall/{id}")
    public ResponseEntity<List<CommentEntity>> getcomments(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(commentService.getcomments(id), HttpStatus.OK);
    }

    @PostMapping("/comment/fill/{number}")
    public ResponseEntity<String>
            fill(@PathVariable(value = "number") int number) {
        String[] comentarios = {
            "Increible!!",
            "Me gusta mucho",
            "Mis dieses",
            "Le falta un retoque pero bien",
            "Buaah impresionante!!",
            "Vendo opel corsa",
            "Like si estas leyendo esto en 2020",
            "Le falta vanila a tu dibujo",
            "Me encantaria contratar a tus manos",
            "Un fenomeno",
            "Es lo mejor que he visto hasta hace 2 segundos ",
            "Podrías dibujarme a mi???",
            "Te dibujo si me sigues",
            "¿Es foto o dibujo?", "Yo dibujo mejor", "El de arriba no sabe dibujar", "No está nada mal", "Sigue así!!", "M encanta tu dibujo y está página en general", "Holaa!! Tengo dibujos en rebajas, me los quitan de las manos!!"
        };
        for (int i = 0; number > i; i++) {
            UserEntity oUserEntity = new UserEntity();
            ImageEntity oImageEntity = new ImageEntity();
            CommentEntity oCommentEntity = new CommentEntity();
            oUserEntity.setId((int) Math.floor(Math.random() * 10) + 2);
            oImageEntity.setId((int) Math.floor(Math.random() * 10) + 1);

            String body = comentarios[(int) (Math.random() * comentarios.length) + 0];
            oCommentEntity.setDate(Calendar.getInstance().getTime());
            oCommentEntity.setUser_id(oUserEntity);
            oCommentEntity.setImage_id(oImageEntity);
            oCommentEntity.setBody(body);

            commentService.create(oCommentEntity);
        }
        return new ResponseEntity<>("Se han añadido correctamente", HttpStatus.OK);
    }
}
