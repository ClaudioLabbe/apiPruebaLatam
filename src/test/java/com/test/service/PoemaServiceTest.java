package com.test.service;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.latam.claudio.domian.Poema;
import com.latam.claudio.service.PoemaService;

@RunWith(MockitoJUnitRunner.class)
public class PoemaServiceTest {

	@InjectMocks
	private PoemaService poemaService;
	
	@Mock
    private RestTemplate restTemplate;
	
	@Test
	public void obtienePoemaTest() {
		poemaService.obtienePoema();
	}
	
//	@Test
//	public void obtienePoemaTestCatch() {
//		String urlRandomPoems = "https://www.poemist.com/api/v1/randompoemss";
//		RestTemplate restTemplate = new RestTemplate();
//		
//        when(restTemplate.getForObject(urlRandomPoems, Poema[].class)).thenReturn();
//		
//		poemaService.obtienePoema();
//	}
}
