package ma.controle.adnan.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.controle.adnan.main.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
