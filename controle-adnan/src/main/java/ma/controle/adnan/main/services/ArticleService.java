package ma.controle.adnan.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.controle.adnan.main.entities.Article;
import ma.controle.adnan.main.idao.IDao;
import ma.controle.adnan.main.repositories.ArticleRepository;

@Service
public class ArticleService  implements IDao<Article>{
	
	@Autowired
	private ArticleRepository artRep;

	@Override
	public Article create(Article o) {
		// TODO Auto-generated method stub
		return artRep.save(o);
	}

	@Override
	public boolean delete(Article o) {
		try {
			artRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Article update(Article o) {
		return artRep.save(o);
	}

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return artRep.findAll();
	}

	@Override
	public Article findById(long id) {
		// TODO Auto-generated method stub
		return artRep.findById(id).orElse(null);
	}

}
