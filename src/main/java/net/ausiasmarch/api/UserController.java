
package net.ausiasmarch.api;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ausiasmarch.entity.RoleEntity;

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

import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.implementation.specific.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService oUserService;

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> get(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>((UserEntity) oUserService.get(id), HttpStatus.OK);
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

	@GetMapping("/getpage/{page}/{rpp}/{sortBy}/{order}")
	public ResponseEntity<Page<UserEntity>> getPageUser(@PathVariable(value = "page") int page,
			@PathVariable(value = "rpp") int rpp, @PathVariable(value = "sortBy") String sortBy,
			@PathVariable(value = "order") String order) {
		Pageable oPageable;
		if (order.equalsIgnoreCase("asc")) {
			oPageable = PageRequest.of(page, rpp, Sort.by(sortBy).ascending());
		} else {
			oPageable = PageRequest.of(page, rpp, Sort.by(sortBy).descending());
		}
		return new ResponseEntity<>(oUserService.getPage(oPageable), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(oUserService.delete(id), HttpStatus.OK);
	}

	@PostMapping("/") // @RequestParam para uso parametro a parametro
	public ResponseEntity<UserEntity> create(@RequestBody GenericEntityInterface oTipousuarioBean) {
		return new ResponseEntity<>((UserEntity) oUserService.create(oTipousuarioBean), HttpStatus.OK);
	}

	@PutMapping("/") // @RequestParam para uso parametro a parametro
	public ResponseEntity<UserEntity> update(@RequestBody GenericEntityInterface oTipousuarioBean) {
		return new ResponseEntity<>((UserEntity) oUserService.update(oTipousuarioBean), HttpStatus.OK);
	}

	// FILL DE USUARIO
	/*
	 * @PostMapping("/fill/{number}") public ResponseEntity<String>
	 * fill(@PathVariable(value = "number") int number) {
	 * 
	 * FakeValuesService fakeValuesService = new FakeValuesService( new
	 * Locale("es-ES"), new RandomService());
	 * 
	 * for (int i = 0; number > i; i++) { String username =
	 * fakeValuesService.letterify("??????##"); String password = "illustration";
	 * String email = fakeValuesService.bothify("????##@gmail.com"); Matcher
	 * emailMatcher = Pattern.compile("\\w{4}\\d{2}@gmail.com").matcher(email); Date
	 * date_register = Calendar.getInstance().getTime(); Date date_birth =
	 * Calendar.getInstance().getTime(); String image_profile =
	 * fakeValuesService.bothify("?#?#?#?##??#.jpg"); String image_front =
	 * fakeValuesService.bothify("?#?#?#?##??#.jpg"); String token =
	 * fakeValuesService.bothify("??###??##??#??#?#?##?##"); boolean validate =
	 * true; boolean reported = false; boolean blocked = false; boolean pri = false;
	 * RoleEntity oRole = new RoleEntity(); oRole.setId(3); RoleEntity role_link =
	 * oRole; UserEntity oUsuarioEntity = new UserEntity();
	 * oUserService.create(oUsuarioEntity);
	 * 
	 * } return new ResponseEntity<>("Se han añadido correctamente", HttpStatus.OK);
	 * }
	 */
}
