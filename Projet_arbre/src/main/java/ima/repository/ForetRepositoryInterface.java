package ima.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import ima.dao.ForetDAO;

public interface ForetRepositoryInterface extends CrudRepository<ForetDAO,Long>{
	
	@Query("select e from ima.dao.ForetDAO e where e.nom_f like %?1")
	public ForetDAO findForetByName(String name);

}
