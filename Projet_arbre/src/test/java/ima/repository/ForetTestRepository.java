package ima.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ima.dao.ForetDAO;

public class ForetTestRepository {
	@Autowired
	private ForetRepositoryInterface repo;
	
	@Test
	public void getAllForets() {
		final Iterable<ForetDAO> selection = repo.findAll();
		// Assertions
        Assert.assertNotNull(selection);
        Assert.assertTrue(selection.iterator().hasNext());

}

}
