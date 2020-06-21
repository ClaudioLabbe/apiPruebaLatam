package com.latam.claudio.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latam.claudio.domian.Usuario;
import com.latam.claudio.domian.Poema;

@Service
public class UsuarioService {

	@Autowired
	private PoemaService poemaService;
	
	public Usuario add(Usuario usuario) {
		
		usuario.setEdad(calcularEdad(usuario.getFechaDeNacimiento()));
		
		LocalDate fechaNac = usuario.getFechaDeNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(cumpleaños(fechaNac) == true) {
			Poema poema = poemaService.obtienePoema();
			usuario.setCumpleaños("Feliz cumpleaños!!!");
			usuario.setPoema(poema.getContent());
		}
		else {
			usuario.setCumpleaños("Faltan " + calculateDiasFaltantes(fechaNac) + " dias para tu cumpleaños");
		}
		
		return usuario;
	}
	
	private int calcularEdad(Date date) {

		LocalDate fechaNac = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		
		return periodo.getYears();
	}
	
	private boolean cumpleaños(LocalDate fechaNac) {
		
		
		LocalDate ahora = LocalDate.now();
		
		if(fechaNac.getYear() == ahora.getYear()) {
			return false;
		}
		if((fechaNac.getDayOfMonth() + 1) == ahora.getDayOfMonth() && fechaNac.getMonth() == ahora.getMonth()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private String calculateDiasFaltantes(LocalDate date){   
		LocalDate ahora = LocalDate.now();
		
		LocalDate diasDelAnio = LocalDate.of(ahora.getYear(), 12, 31);
		
		date = date.plusDays(1);
		
		int dia = date.getDayOfYear() - ahora.getDayOfYear();
		
		if(date.getYear() == ahora.getYear() && date.getDayOfYear() == ahora.getDayOfYear()) {
			dia = diasDelAnio.getDayOfYear();
		}
		else if(dia < 0) {
			dia = -dia + diasDelAnio.getDayOfYear();
		}
		
		return String.valueOf(dia);
	}
}
