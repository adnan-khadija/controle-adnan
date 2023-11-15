package ma.controle.adnan.main.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.controle.adnan.main.entities.Categorie;
import ma.controle.adnan.main.idao.IDao;
import ma.controle.adnan.main.repositories.CategorieRepository;



@Service
public class CategorieService  implements IDao<Categorie>{
	
	@Autowired
	private CategorieRepository catRep;

	@Override
	public Categorie create(Categorie o) {
		// TODO Auto-generated method stub
		return catRep.save(o);
	}

	@Override
	public boolean delete(Categorie o) {
		try {
			catRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Categorie update(Categorie o) {
		return catRep.save(o);
	}

	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return catRep.findAll();
	}

	@Override
	public Categorie findById(long id) {
		// TODO Auto-generated method stub
		return catRep.findById(id).orElse(null);
	}

	/*public List<Categorie> souCategories(Categorie c){
		return catRep.sousCategories(c);
	}*/
}

