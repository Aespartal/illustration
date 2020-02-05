package net.ausiasmarch.api;

import java.util.List;
import net.ausiasmarch.entity.AlbumEntity;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import net.ausiasmarch.service.implementation.specific.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService oAlbumService;

    @GetMapping("/{id}")
    public ResponseEntity<AlbumEntity> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((AlbumEntity) oAlbumService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<AlbumEntity>> get() {
        return new ResponseEntity<>(oAlbumService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oAlbumService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<AlbumEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oAlbumService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oAlbumService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<AlbumEntity> create(@RequestBody GenericEntityInterface oAlbumEntity) {
        return new ResponseEntity<>((AlbumEntity) oAlbumService.create(oAlbumEntity), HttpStatus.OK);
    }

    @PutMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<AlbumEntity> update(@RequestBody GenericEntityInterface oAlbumEntity) {
        return new ResponseEntity<>((AlbumEntity) oAlbumService.update(oAlbumEntity), HttpStatus.OK);
    }

    @PostMapping("/fill/{number}")
    public ResponseEntity<String>
            fill(@PathVariable(value = "number") int number) {
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
        for (int i = 0; number > i; i++) {
            AlbumEntity oAlbumEntity = new AlbumEntity();
            UserEntity oUserEntity = new UserEntity();
            oUserEntity.setId((int) Math.floor(Math.random() * 13) + 4);

            String tituloAlbum = title[(int) (Math.random() * title.length) + 0];
            oAlbumEntity.setTitle(tituloAlbum);
            oAlbumEntity.setDate(new java.sql.Date(new java.util.Date().getTime()));
            oAlbumEntity.setIs_private(false);
            oAlbumEntity.setUser_id(oUserEntity);
            
            oAlbumService.create(oAlbumEntity);
        }

        return new ResponseEntity<>("Se han añadido correctamente", HttpStatus.OK);
    }
}
