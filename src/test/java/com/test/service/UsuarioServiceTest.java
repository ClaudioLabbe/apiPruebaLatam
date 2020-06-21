package com.test.service;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.latam.claudio.domian.Poema;
import com.latam.claudio.domian.Usuario;
import com.latam.claudio.service.PoemaService;
import com.latam.claudio.service.UsuarioService;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

	@InjectMocks
	private UsuarioService usuarioService;
	
	@Mock
	private PoemaService poemaService;
	
	@Test
	public void addTest() throws ParseException {
		usuarioService.add(usuarioFecha());
	}
	
	@Test
	public void addTestPoema() throws ParseException {
		
		when(poemaService.obtienePoema()).thenReturn(poema());
		usuarioService.add(usuario());
	}
	
	private Poema poema() {
		Poema poema = new Poema();
		
		poema.setContent("\"Oh, when I was in love with you,\\nThen I was clean and brave,\\nAnd miles around the wonder grew\\nHow well did I behave.\\n\\nAnd now the fancy passes by,\\nAnd nothing will remain,\\nAnd miles around they'll say that I\\nAm quite myself again.\"");
		poema.setTitle("title");
		poema.setUrl("url");
		
		return poema;
	}
	
	private Usuario usuario() throws ParseException {
		Usuario usuario = new Usuario();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		usuario.setNombre("Claudio");
		usuario.setApellido("Labbe");
		usuario.setFechaDeNacimiento(formato.parse("1992-06-20"));
		usuario.setCumpleaños("aun no es tu cumpleaños");
		usuario.setEdad(27);
		usuario.setPoema("Poema");
		
		return usuario;
	}
	
	private Usuario usuarioFecha() throws ParseException {
		Usuario usuario = new Usuario();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		usuario.setNombre("Claudio");
		usuario.setApellido("Labbe");
		usuario.setFechaDeNacimiento(formato.parse("1992-06-01"));
		usuario.setCumpleaños("aun no es tu cumpleaños");
		usuario.setEdad(27);
		usuario.setPoema("Poema");
		
		return usuario;
	}
}
