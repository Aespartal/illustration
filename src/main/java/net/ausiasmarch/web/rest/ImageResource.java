/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.web.rest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.ausiasmarch.domain.*;
import net.ausiasmarch.domain.User;
import net.ausiasmarch.domain.mapper.ImageMapper;
import net.ausiasmarch.service.dto.ImageDTO;
import net.ausiasmarch.service.ImageService;
import net.ausiasmarch.service.impl.StorageServiceImpl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class ImageResource {

    private final ImageService imageService;
    private final ImageMapper imageMapper;
    private final StorageServiceImpl storageServiceImpl;

    public ImageResource(ImageService imageService, ImageMapper imageMapper, StorageServiceImpl storageServiceImpl) {
        this.imageService = imageService;
        this.imageMapper = imageMapper;
        this.storageServiceImpl = storageServiceImpl;
    }

    @PostMapping("/image")
    public ResponseEntity<ImageDTO> create(@Valid @RequestBody ImageDTO imageDTO) {
        return ResponseEntity
                .ok()
                .body(imageService.save(imageDTO));
    }

    @PutMapping("/image")
    public ResponseEntity<ImageDTO> update(@Valid @RequestBody ImageDTO imageDTO) {
        return ResponseEntity
                .ok()
                .body(imageService.save(imageDTO));
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<ImageDTO> get(@PathVariable(value = "id") int id) {
        return ResponseEntity
                .ok()
                .body(imageService.findOne(id));
    }

    @GetMapping("/image")
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        return ResponseEntity
                .ok()
                .body(imageService.findAll());
    }

    @GetMapping("/image/popular/{page}/{rpp}")
    public ResponseEntity<List<ImageDTO>> popular(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable = PageRequest.of(page, rpp);
        return ResponseEntity
                .ok()
                .body(imageService.popular(oPageable));
    }

    @GetMapping("/image/imageslikes/{user}")
    public ResponseEntity<List<ImageDTO>> imageslikes(@PathVariable(value = "user") int userId) {
        return ResponseEntity
                .ok()
                .body(imageService.imageslikes(userId));
    }

    @GetMapping("/image/favourite/{user}")
    public ResponseEntity<List<ImageDTO>> favourite(@PathVariable(value = "user") int userId) {
        return ResponseEntity
                .ok()
                .body(imageService.favourite(userId));
    }

    @GetMapping("/image/myimages/{user}")
    public ResponseEntity<List<ImageDTO>> myimages(@PathVariable(value = "user") int userId) {
        return ResponseEntity
                .ok()
                .body(imageService.myimages(userId));
    }

    @GetMapping("/image/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok().body(imageService.count());
    }
    
    @GetMapping("/image/count/{id}")
    public ResponseEntity<Integer> count(@PathVariable(value = "id") int imageId) {
        return ResponseEntity.ok().body(imageService.countLikes(imageId));
    }

    @GetMapping("/image/getpage/{page}/{rpp}")
    public ResponseEntity<Page<ImageDTO>> getPage(
            @PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp, Sort.by(Order.desc("date")));
        return ResponseEntity.ok().body(imageService.getPage(oPageable));
    }

    @GetMapping("/image/getpage/{page}/{rpp}/{user_id}")
    public ResponseEntity<List<ImageDTO>> getPageImgFollows(
            @PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp,
            @PathVariable(value = "user_id") int userId) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp, Sort.by(Order.desc("date")));
        return ResponseEntity.ok().body(imageService.getPageImgFollows(oPageable, userId));
    }

    @GetMapping("/image/{title}")
    public ResponseEntity<List<ImageDTO>> findFilter(@RequestParam String title) {
        return ResponseEntity
                .ok()
                .body(imageService.findFilter(title));
    }

    @DeleteMapping("/image/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(imageService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/image/like") //LIKES
    public ResponseEntity<Like> like(@RequestBody LikeId mParametros) {
        Integer userId = mParametros.getUser_id();
        Integer imageId = mParametros.getImage_id();
        return ResponseEntity
                .ok()
                .body(imageService.like(userId, imageId));
    }

    @PostMapping("/image/upload") //UPLOAD
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(storageServiceImpl.uploadFile(file), HttpStatus.OK);
    }
    
    @GetMapping("/image/img/{image}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable(value = "image") String image) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("image\\" + image);
        return ResponseEntity
                .ok() 
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    @GetMapping("/image/getall/{category_id}")
    public ResponseEntity<List<ImageDTO>> getAllByCategory(@PathVariable(value = "category_id") Integer categoryId) {
        return ResponseEntity
                .ok()
                .body(imageService.getAllByCategory(categoryId));
    }

    @PostMapping("/image/fill/{number}")
    public ResponseEntity<String>
            fill(@PathVariable(value = "number") int number) {
        String[] imagenes = {
            "FINISH_mini_delgada_417936.jpg",
            "erase_cuento_418092.jpg",
            "esqueleto1_418075.png",
            "RETRATOa_419157.jpg",
            "IlustracionDigital023_1__417268.jpg",
            "VI_418887.jpg",
            "PAG_31_COL_418634.jpg",
            "2A580BB7_5EEE_49D9_8D0B_4BD31C3B63CC_418225.jpeg",
            "JillSD_418077.jpg",
            "girl1_419811.jpg",
            "llllllll_419226.jpg",
            "20200102_417141.jpg",
            "pt2020_01_02_21_22_27_mh1577996576440_417180.jpg",
            "25_417123.jpg",
            "25_417123.jpg",
            "IMG_20200110_417704.jpg",
            "20200114_418128.gif",
            "jrr_talkin_418416.jpg"
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
            Image oImage = new Image();
            Category oCategory = new Category();
            oCategory.setId(1);
            User oUser = new User();
            oUser.setId(1);

            String tituloImage = title[(int) (Math.random() * title.length)]; //image
            String path = imagenes[(int) (Math.random() * imagenes.length)]; //image
            String desc = description[(int) (Math.random() * description.length)]; //image
            String tag = tags[(int) (Math.random() * tags.length)]; //image

            oImage.setImage(path);
            oImage.setTitle(tituloImage);
            oImage.setDescription(desc);
            oImage.setTags(tag);
            oImage.setDate(new Date());
            oImage.setIs_private(false);
            oImage.setIs_reported(false);
            oImage.setCategory(oCategory);
            oImage.setUser(oUser);

            ImageDTO oImageDTO = imageMapper.toDto(oImage);
            imageService.save(oImageDTO);
        }
        return new ResponseEntity<>("Se han añadido correctamente", HttpStatus.OK);
    }

}
