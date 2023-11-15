
package  ma.controle.adnan.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.controle.adnan.main.entities.Categorie;
import ma.controle.adnan.main.services.CategorieService;



@Controller
@RequestMapping("/api/categories")
public class CategorieController {
	@Autowired
	private CategorieService cats;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllCategories() {
        List<Categorie> batiments = cats.findAll();
        if (batiments.isEmpty()) {
            return new ResponseEntity<>("Aucun categories trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(batiments);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Categorie> saveCategoriee(@RequestBody Categorie batiment){
		return new  ResponseEntity<Categorie>(cats.create(batiment),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Categorie bat = cats.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategorie(@PathVariable int id, @RequestBody Categorie newCategorie) {
		Categorie oldCategorie = cats.findById(id);
		if (oldCategorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newCategorie.setId(id);
			return ResponseEntity.ok(cats.update(newCategorie));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable int id) {
		Categorie bat = cats.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Categorie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			cats.delete(bat);
			return ResponseEntity.ok("Categorie est  supprimée");
		}
	}


}

