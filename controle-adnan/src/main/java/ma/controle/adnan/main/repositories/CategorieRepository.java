package ma.controle.adnan.main.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.controle.adnan.main.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{
// public List<Categorie> sousCategories(Categorie c);
}
