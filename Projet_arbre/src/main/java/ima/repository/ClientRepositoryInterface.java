package ima.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ima.dao.ClientDAO;
import ima.dao.ForetDAO;

public interface ClientRepositoryInterface extends CrudRepository<ClientDAO,Long>{
	
	@Query("select e from ima.dao.ClientDAO e where e.nom like %?1")
	public List<ClientDAO> findClientByName(String name);

}
