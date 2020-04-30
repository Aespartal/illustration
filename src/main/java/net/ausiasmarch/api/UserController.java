package net.ausiasmarch.api;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import net.ausiasmarch.entity.FollowerEntity;
import net.ausiasmarch.entity.FollowerId;
import net.ausiasmarch.entity.RolEntity;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.specific.UserService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService oUserService;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>((UserEntity) oUserService.get(id), HttpStatus.OK);
    }

    @GetMapping("/name/{username}")
    public ResponseEntity<UserEntity> getUsername(@PathVariable(value = "username") String username) {
        return new ResponseEntity<>((UserEntity) oUserService.getUsername(username), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UserEntity>> get() {
        return new ResponseEntity<>(oUserService.getall(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(oUserService.count(), HttpStatus.OK);
    }

    @GetMapping("/getpage/{page}/{rpp}")
    public ResponseEntity<Page<UserEntity>> getPage(@PathVariable(value = "page") int page,
            @PathVariable(value = "rpp") int rpp) {
        Pageable oPageable;
        oPageable = PageRequest.of(page, rpp);
        return new ResponseEntity<>(oUserService.getPage(oPageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(oUserService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity oUserBean) {
        return new ResponseEntity<>((UserEntity) oUserService.create(oUserBean), HttpStatus.OK);
    }

    @PutMapping("/") // @RequestParam para uso parametro a parametro
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity oUserBean) {
        return new ResponseEntity<>((UserEntity) oUserService.update(oUserBean), HttpStatus.OK);
    }

    @GetMapping("/userbyimage/{image_id}")
    public ResponseEntity<UserEntity> findUserByImage(@PathVariable(value = "image_id") Integer image_id) {
        return new ResponseEntity<>((UserEntity) oUserService.findUserByImage(image_id), HttpStatus.OK);
    }

    @PostMapping("/follow")
    public ResponseEntity<FollowerEntity> follow(@RequestBody FollowerId mParametros) {
        Integer user_id = mParametros.getUser_id();
        Integer friend_id = mParametros.getFriend_id();
        return new ResponseEntity<>(oUserService.follow(user_id, friend_id), HttpStatus.OK);
    }
    
    @GetMapping("/findfollow/{user_id}/{friend_id}")
    public ResponseEntity<Boolean> findfollow(@PathVariable(value = "user_id") Integer user_id,
            @PathVariable(value = "friend_id") Integer friend_id) {
        return new ResponseEntity<>(oUserService.findFollow(user_id, friend_id), HttpStatus.OK);
    }

    @PostMapping("/fill/{number}")
    public ResponseEntity<String>
            fill(@PathVariable(value = "number") int number) {
        String img = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
        String img_cover = "https://blogthinkbig.com/wp-content/uploads/2018/07/V%C3%ADa-L%C3%A1ctea-portada-espacio-universo.jpg";

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("es-ES"), new RandomService());
        String[] nombre = {"Marcel·li", "Pompeu", "Cirili", "Paco", "Josepa", "Vidal", "Domènec", "Maurici", "Eudald",
            "Miqueleta", "Bernat", "Jaumet", "Pepet"};
        String[] apellido1 = {"de Cal", "el de", "de la", "dels", "de Can", "de les", "Ca la", "Pacoco"};
        String[] apellido2 = {"Pacoco", "Clapés", "Trencapins", "Palla", "Cargols", "Metge", "Murallot", "Porrons",
            "Cigrons", "Llobarro", "Faves", "Cebes", "Freda"};

        String[] descripciones = {"Soy el mejor artista.", " ", "Todos tenemos un artista interior. ", "Vivimos es una sociedad.",
            "Solo programo alarmas. ", "Mi vida es el dibujo", "Abre tu mente y descubriras lo que disfruta la gente de la vida.", "Programo en vanila jaja salu2. "};

        for (int i = 0; number > i; i++) {
            UserEntity oUserEntity = new UserEntity();
            RolEntity oRolEntity = new RolEntity(2, "Artista");

            String name = nombre[(int) (Math.random() * nombre.length) + 0];
            String surname1 = apellido1[(int) (Math.random() * apellido1.length) + 0];
            String surname2 = apellido2[(int) (Math.random() * apellido2.length) + 0];
            String username = name.substring(0, 2).toLowerCase().trim()
                    + surname1.substring(0, 2).toLowerCase().trim()
                    + surname2.substring(0, 2).toLowerCase().trim()
                    + (int) Math.floor(Math.random() * (1000 - 9999) + 9999);

            String email = username + "@illustration.com";
            String description = descripciones[(int) (Math.random() * descripciones.length) + 0];
            String token = fakeValuesService.bothify("??###??##??#??#?#?##?##");

            long aDay = TimeUnit.DAYS.toMillis(1);
            long now = new Date().getTime();
            Date hundredYearsAgo = new Date(now - aDay * 365 * 100);
            Date tenDaysAgo = new Date(now - aDay * 10);
            Date random = between(hundredYearsAgo, tenDaysAgo);

            oUserEntity.setName(name);
            oUserEntity.setSurname1(surname1);
            oUserEntity.setSurname2(surname2);
            oUserEntity.setUsername(username);
            oUserEntity.setPassword("498CC84B29CB560E15B49483A00F11C44405DE576DD4001116C35D85F293F1BF");
            oUserEntity.setEmail(email);
            oUserEntity.setDescription(description);
            oUserEntity.setToken(token);
            oUserEntity.setDate_register(new java.sql.Date(new java.util.Date().getTime()));
            oUserEntity.setBirthdate(random);
            oUserEntity.setImg_profile(img);
            oUserEntity.setImg_cover(img_cover);
            oUserEntity.setIs_private(false);
            oUserEntity.setIs_banned(false);
            oUserEntity.setIs_validate(true);
            oUserEntity.setRole(oRolEntity);

            oUserService.create(oUserEntity);

        }
        return new ResponseEntity<>("Se han añadido correctamente", HttpStatus.OK);
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }

}
