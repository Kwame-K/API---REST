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

public class SelectionTestController {
	/** Logger */
    private static final Logger log = LoggerFactory.getLogger(SelectionTestController.class);
    
    public static final String URL_MOCK_SERVICE = "http://localhost";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();   
    
    @LocalServerPort
	protected int port;
    @Test
    public void listSelectionsRequests() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test listSelectsRequests");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/selections",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test listSelectsRequests");    	
    }
    
	@Test
	public void createArbreRequest() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test createSelectionRequest");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/createSelection?nbre_selec=11&client=5&foret=95&arbre=5",
                                     HttpMethod.POST, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
        log.info("End test createSelectionRequest");
		
	}
	
	
	@Test
    public void getSelectionRequest2() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test getArbreRequests");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/selection/2",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test getArbreRequests"); 
	    }

	
	
	}

