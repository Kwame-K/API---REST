package ima.controllers;

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

public class ArbreTestController {
	/** Logger */
    private static final Logger log = LoggerFactory.getLogger(ArbreTestController.class);
    
    public static final String URL_MOCK_SERVICE = "http://localhost";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();   
    
    @LocalServerPort
	protected int port;
    @Test
    public void listArbreRequests() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test listPlantingRequests");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/arbres",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test listArbresRequests");    	
    }
    
	@Test
	public void createArbreRequest() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test createArbreRequest");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/createArbre?nom_p=01&famille=005&nbre=12031995&prix_unitaire=45",
                                     HttpMethod.POST, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
        log.info("End test createArbreRequest");
		
	}
	
	
	@Test
    public void getArbreRequest2() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test getArbreRequests");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/arbre/2",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test getArbreRequests"); 
	    }


	}
