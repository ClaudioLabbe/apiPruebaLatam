package com.latam.claudio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.latam.claudio.domian.Poema;

@Service
public class PoemaService {

	private String urlRandomPoems = "https://www.poemist.com/api/v1/randompoems";
	
	public Poema obtienePoema()
    {
		Poema poema = new Poema();
		try {
			 RestTemplate restTemplate = new RestTemplate();
			 
	        Poema[] poemas = restTemplate.getForObject(urlRandomPoems, Poema[].class);
	        
	        int numero = (int) (Math.random() * (poemas.length - 1));
	        
	        poema = poemas[numero];

	        return poema;
		} catch (RestClientResponseException  e) {
			
			System.out.println(e.getStatusText());
			return poema;
		}
    }
}
