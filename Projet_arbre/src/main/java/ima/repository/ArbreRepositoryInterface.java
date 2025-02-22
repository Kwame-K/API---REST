package ima.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ima.dao.ArbreDAO;
import ima.dao.ForetDAO;

public interface ArbreRepositoryInterface extends CrudRepository<ArbreDAO,Long>{
	
	@Query("select e from ima.dao.ArbreDAO e where e.nom_arbre like %?1")
	public ArbreDAO findArbreByName(String name);
	
	
	@Query("SELECT famille, SUM(nbre_selec) as nombre FROM arbre,selection WHERE arbre.id_arbre=selection.arbre_id_arbre GROUP BY famille")
	public Iterable<ArbreDAO> findArbreByEssence();
	
	
	@Query("SELECT nom_f, nbre_selec from selection ,foret WHERE selection.foret_id_foret = foret.id_foret")
	public Iterable<ArbreDAO> findArbreByForet();

}
