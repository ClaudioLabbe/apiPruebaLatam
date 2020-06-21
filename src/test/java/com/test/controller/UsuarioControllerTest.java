package com.test.controller;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.latam.claudio.controller.UsuarioController;
import com.latam.claudio.domian.Usuario;
import com.latam.claudio.service.PoemaService;
import com.latam.claudio.service.UsuarioService;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioControllerTest {

	@InjectMocks
	private UsuarioController usuarioController;
	
	@Mock
	private UsuarioService usuarioService;
	
	@Mock
	private PoemaService poemaService;
	
	private SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	
	@Test
	public void addUsuario() throws ParseException {
		
		Usuario usuario = new Usuario();
		
		when(usuarioService.add(usuario)).thenReturn(returnUsuario());
		
		usuarioController.addUsuario(usuario);
		
	}
	
	@Test
	public void catchAddUsuario() {
		
		Usuario usuario = new Usuario();
		
		when(usuarioService.add(usuario)).thenThrow(BadRequest.class);
		
		usuarioController.addUsuario(usuario);
		
	}
	
	private Usuario returnUsuario() throws ParseException {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Claudio");
		usuario.setApellido("Labbe");
		usuario.setFechaDeNacimiento(formato.parse("16-12-1992"));
		usuario.setCumpleaños("aun no es tu cumpleaños");
		usuario.setEdad(27);
		usuario.setPoema("Poema");
		
		return usuario;
	}
}
