package ima.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ima.dao.SelectionDAO;

public interface SelectionRepositoryInterface extends CrudRepository<SelectionDAO,Long>{
	
	@Query("select e from ima.dao.SelectionDAO e where e.id = ?1")
	public SelectionDAO findByIdNumber(Long id);

}
