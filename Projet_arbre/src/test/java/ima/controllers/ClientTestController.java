package ima.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ima.entities.Adresse;
import ima.entities.Client;


public class ClientTestController {
	/** Logger */
    private static final Logger log = LoggerFactory.getLogger(ClientTestController.class);
    
    public static final String URL_MOCK_SERVICE = "http://localhost";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();   
    
    @LocalServerPort
	protected int port;
    
    @Test
    public void listClientsRequests() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test listClientsRequests");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/clients",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test listClientsRequests");    	
    }
    
	@Test
	public void createClientRequest() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test createClientRequest");
        Client client = new Client();
        Adresse ad = new Adresse();
        client.setNom("Hambi");
        client.setPrenom("Kez");
        ad.setCode_postal("49100");
        ad.setPays("France");
        ad.setVille("Angers");
        client.setAdresse(ad);
        
        ResponseEntity<Client> response = restTemplate.postForEntity(URL_MOCK_SERVICE+":"+port+ "/createClient", client, Client.class);          

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
        log.info("End test createClientRequest");
		
	}
	
	
	@Test
    public void getClientRequest2() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test getClientRequest2");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/client/2",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test getClientRequest2"); 
	    }
	


}
