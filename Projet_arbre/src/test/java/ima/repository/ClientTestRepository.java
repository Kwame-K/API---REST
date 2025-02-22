package ima.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ima.dao.ClientDAO;

public class ClientTestRepository {
	@Autowired
	private ClientRepositoryInterface repo;
	
	@Test
	public void getAllClients() {
		final Iterable<ClientDAO> clients = repo.findAll();
		// Assertions
        Assert.assertNotNull(clients);
        Assert.assertTrue(clients.iterator().hasNext());
        }

}
