package com.latam.claudio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.latam.claudio.domian.Usuario;
import com.latam.claudio.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/add")
    public ResponseEntity<?> addUsuario(@Valid @RequestBody Usuario usuario){

        try {   
             Usuario user = usuarioService.add(usuario);
             return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);

        }catch (Exception e){
        	System.out.println(e.toString());
            return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
        }
        

    }
	

}
