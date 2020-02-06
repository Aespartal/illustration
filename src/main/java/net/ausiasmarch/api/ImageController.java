/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.ausiasmarch.entity.AlbumEntity;
import net.ausiasmarch.entity.CategoryEntity;
import net.ausiasmarch.entity.ImageEntity;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import net.ausiasmarch.service.implementation.specific.ImageService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService oImageService;

    @GetMapping("/{id}")
    public ResponseEntity<ImageEntity> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((ImageEntity) oImageService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ImageEntity>> get() {
        return new ResponseEntity<>(oImageService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oImageService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<ImageEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oImageService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oImageService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<ImageEntity> create(@RequestBody GenericEntityInterface oImageEntity) {
        return new ResponseEntity<>((ImageEntity) oImageService.create(oImageEntity), HttpStatus.OK);
    }

    @PutMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<ImageEntity> update(@RequestBody GenericEntityInterface oImageEntity) {
        return new ResponseEntity<>((ImageEntity) oImageService.update(oImageEntity), HttpStatus.OK);
    }

    @PostMapping("/like") // login
    public ResponseEntity<Boolean> like(@RequestParam(name = "user_id") Integer user_id,@RequestParam(name = "image_id") Integer image_id) {
        return new ResponseEntity<>(oImageService.like(user_id,image_id), HttpStatus.OK);
    }

    @PostMapping("/fill/{number}")
    public ResponseEntity<String>
            fill(@PathVariable(value = "number") int number) {
        String[] imagenes = {
            "https://dibujando.net/files/fs/p/c/900x1000/2020/11/FINISH_mini_delgada_417936.jpg",
            "https://dibujando.net/files/fs/p/i/2020/13/erase_cuento_418092.jpg",
            "https://dibujando.net/files/fs/p/i/2020/12/esqueleto1_418075.png",
            "https://dibujando.net/files/fs/p/c/2000x2000/2020/23/RETRATOa_419157.jpg",
            "https://dibujando.net/files/fs/p/c/2000x2000/2020/3/IlustracionDigital023_1__417268.jpg",
            "https://dibujando.net/files/fs/p/c/900x1000/2020/19/VI_418887.jpg",
            "https://dibujando.net/files/fs/p/i/2020/17/PAG_31_COL_418634.jpg",
            "https://dibujando.net/files/fs/p/c/900x1000/2020/14/2A580BB7_5EEE_49D9_8D0B_4BD31C3B63CC_418225.jpeg",
            "https://dibujando.net/files/fs/p/i/2020/12/JillSD_418077.jpg",
            "https://dibujando.net/files/fs/p/c/2000x2000/2020/28/girl1_419811.jpg",
            "https://dibujando.net/files/fs/p/c/900x1000/2020/23/llllllll_419226.jpg",
            "https://dibujando.net/files/fs/p/c/2000x2000/2020/1/20200102_417141.jpg",
            "https://dibujando.net/files/fs/p/i/2020/2/pt2020_01_02_21_22_27_mh1577996576440_417180.jpg",
            "https://dibujando.net/files/fs/p/c/2000x2000/2020/1/25_417123.jpg",
            "https://dibujando.net/files/fs/p/c/2000x2000/2020/1/25_417123.jpg",
            "https://dibujando.net/files/fs/p/c/2000x2000/2020/9/IMG_20200110_417704.jpg",
            "https://dibujando.net/files/fs/p/i/2020/13/20200114_418128.gif",
            "https://dibujando.net/files/fs/p/i/2020/16/jrr_talkin_418416.jpg"
        };
        String[] title = {
            "La rosalia",
            "Paisaje",
            "Dibujo sin mirar",
            "Posturas",
            "Titanic",
            "Bostezo",
            "Pimpinela",
            "Vanila",
            "Lost",
            "La soledad",
            "Apruebame",
            "Vinilo",
            "Tomb raider",
            "Lola",
            "Pirindola",
            "Loco de atar",
            "Bocata", "Risis", "La pose perfecta", "Lunatico", "Puesta de sol", "Monster", "De Valencia al cielo", "Road to aprobar", "Los caracoles"
        };
        String[] description = {
            "Dibujo acuarela sobre papel fabriano 22,9 cm X 30,5 cm",
            "esto lo pinte hace mucho , pero quedo mal ...asi que le volvi a dar una pasada ..y bueno ..eso .\n"
            + "\n"
            + "asi que aqui lo comparto .\n"
            + "\n"
            + "saludos a todos !",
            "Empecé a hacer retratos en mi tiempo libre ",
            "Hola de nuevo practicando....\n"
            + "Como estamos en febrero,  quise dibujar a esta chica... Nada más romántico",
            "Ciudad desnivelada",
            "Primer Dibujo del año, Jill  del Resident Evil 3, espero que les guste, ah si, disculpen la tardanza, prometo que no volverá a pasar",};
        String[] tags = {
            "dibujo,3d,animacion", "ciudad,personaje,cielo", "juego", "monster,bebida,energetica", "saladitos,acuarela", "a mano,pintura", "foto"
        };

        for (int i = 0; number > i; i++) {
            ImageEntity oImageEntity = new ImageEntity();
            CategoryEntity oCategoryEntity = new CategoryEntity();
            oCategoryEntity.setId((int) Math.floor(Math.random() * 5) + 1);
            AlbumEntity oAlbumEntity = new AlbumEntity();
            oAlbumEntity.setId((int) Math.floor(Math.random() * 5) + 1);
            String tituloImage = title[(int) (Math.random() * title.length) + 0]; //image
            String path = imagenes[(int) (Math.random() * imagenes.length) + 0]; //image
            String desc = description[(int) (Math.random() * description.length) + 0]; //image
            String tag = tags[(int) (Math.random() * tags.length) + 0]; //image

            oImageEntity.setImage(path);
            oImageEntity.setTitle(tituloImage);
            oImageEntity.setDescription(desc);
            oImageEntity.setTags(tag);
            oImageEntity.setDate(new java.sql.Date(new java.util.Date().getTime()));
            oImageEntity.setIs_private(false);
            oImageEntity.setIs_reported(false);
            oImageEntity.setAlbum(oAlbumEntity);
            oImageEntity.setCategory(oCategoryEntity);

            oImageService.create(oImageEntity);
        }
        return new ResponseEntity<>("Se han añadido correctamente", HttpStatus.OK);
    }

}
