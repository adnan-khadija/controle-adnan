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

import ma.controle.adnan.main.entities.Article;
import ma.controle.adnan.main.services.ArticleService;


@Controller
@RequestMapping("/api/articles")
public class ArticleController {
	@Autowired
	private ArticleService arts;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllArticles() {
        List<Article> batiments = arts.findAll();
        if (batiments.isEmpty()) {
            return new ResponseEntity<>("Aucun article est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(batiments);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Article> saveArticlee(@RequestBody Article batiment){
		return new  ResponseEntity<Article>(arts.create(batiment),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Article bat = arts.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Article avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateArticle(@PathVariable int id, @RequestBody Article newArticle) {
		Article oldArticle = arts.findById(id);
		if (oldArticle == null) {
			return new ResponseEntity<Object>("Article avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newArticle.setId(id);
			return ResponseEntity.ok(arts.update(newArticle));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteArticle(@PathVariable int id) {
		Article bat = arts.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Article avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			arts.delete(bat);
			return ResponseEntity.ok("Article est  supprimée");
		}
	}


}

