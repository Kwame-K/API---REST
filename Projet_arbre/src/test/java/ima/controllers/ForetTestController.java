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



public class ForetTestController {
	/** Logger */
    private static final Logger log = LoggerFactory.getLogger(ForetTestController.class);
    
    public static final String URL_MOCK_SERVICE = "http://localhost";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();   
    
    @LocalServerPort
	protected int port;
    @Test
    public void listForetRequests() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test listForetRequests");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/forets",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test listForetRequests");    	
    }
    
	@Test
	public void createForetRequest() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test createForetRequest");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/createForet?nom_f=lolq&region=lyas&pays=france",
                                     HttpMethod.POST, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
        log.info("End test createForetRequest");
		
	}
	
	
	@Test
    public void getForetRequest2() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        log.info("Start test getForetRequest2");
        ResponseEntity<String> response = restTemplate.exchange(URL_MOCK_SERVICE+":"+port+ "/foret/2",
                                     HttpMethod.GET, entity, String.class);                

        Assert.assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        log.info("End test getForetRequest2"); 
	    }

	
	}
