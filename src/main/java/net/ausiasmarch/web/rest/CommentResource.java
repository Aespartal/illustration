/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.web.rest;

import java.util.Calendar;
import java.util.List;

import net.ausiasmarch.domain.Comment;
import net.ausiasmarch.domain.Image;
import net.ausiasmarch.domain.User;
import net.ausiasmarch.service.dto.CommentDTO;
import net.ausiasmarch.domain.mapper.CommentMapper;
import net.ausiasmarch.service.CommentService;
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

import javax.validation.Valid;

@RestController
@RequestMapping()
public class CommentResource {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentResource(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentDTO> create(@Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO result = commentService.save(commentDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/comment")
    public ResponseEntity<CommentDTO> update(@Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO result = commentService.save(commentDTO);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable(value = "id") int id) {
        return new ResponseEntity(commentService.get(id), HttpStatus.OK);
    }

    @GetMapping("/comment/getall")
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        return new ResponseEntity(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/comment/count")
    public ResponseEntity<Long> countComments() {
        return new ResponseEntity(commentService.count(), HttpStatus.OK);
    }
    
     @GetMapping("/comment/count/{id}")
    public ResponseEntity<Integer> countCommentsById(@PathVariable(value = "id") int image_id) {
        return new ResponseEntity(commentService.countByImageId(image_id), HttpStatus.OK);
    }

    @GetMapping("/comment/getpage/{page}/{rpp}")
    public ResponseEntity<Page<CommentDTO>> getPage(@PathVariable(value = "page") int page,
                                                       @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity(commentService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity(commentService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/comment/getall/{id}")
    public ResponseEntity<List<CommentDTO>> getcomments(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity(commentService.findAllById(id), HttpStatus.OK);
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
            User oUser = new User();
            Image oImage = new Image();
            Comment oComment = new Comment();
            oUser.setId((int) Math.floor(Math.random() * 10) + 2);
            oImage.setId((int) Math.floor(Math.random() * 10) + 1);

            String body = comentarios[(int) (Math.random() * comentarios.length) + 0];
            oComment.setDate(Calendar.getInstance().getTime());
            oComment.setUser_id(oUser);
            oComment.setImage_id(oImage);
            oComment.setBody(body);
            CommentDTO commentDTO = commentMapper.toDto(oComment);
            commentService.save(commentDTO);
        }
        return new ResponseEntity<>("Se han añadido correctamente", HttpStatus.OK);
    }
}
