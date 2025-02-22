package ima.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ima.dao.SelectionDAO;

public class SelectionTestRepository {
	@Autowired
	private SelectionRepositoryInterface repo;
	
	@Test
	public void getAllSelections() {
		final Iterable<SelectionDAO> selections = repo.findAll();
		// Assertions
        Assert.assertNotNull(selections);
        Assert.assertTrue(selections.iterator().hasNext());
	}

}
