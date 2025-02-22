package ima.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ima.dao.ArbreDAO;

public class ArbreTestRepository {
	@Autowired
	private ArbreRepositoryInterface repo;
	
	@Test
	public void getAllArbres() {
		final Iterable<ArbreDAO> arbres = repo.findAll();
		// Assertions
        Assert.assertNotNull(arbres);
        Assert.assertTrue(arbres.iterator().hasNext());

}

}
