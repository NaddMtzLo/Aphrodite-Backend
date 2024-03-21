package org.generation.aphrodite.controller;

import java.util.ArrayList;

import org.generation.aphrodite.model.Usuario;
import org.generation.aphrodite.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


	@RestController // Se utiliza para crear controladores y devuelven directamente datos en lugar de vistas.

	@RequestMapping (path = "/api/usuarios/") // Se utiliza para asignar solicitudes HTTP a métodos de controlador específicos o a controladores completos. Especifica la URL a la que responderá el método o la clase anotada.

	public class UsuariosController {
	    private final UsuarioService usuarioService;
	    
	   @Autowired // Ésta inyecta dependencias automáticamente en un componente Spring. 
	   public UsuariosController (UsuarioService usuarioService) {
		    this.usuarioService = usuarioService;
		}//Constructor
	  
	    @GetMapping // Ésta mapea las solicitudes HTTP GET a métodos específicos del controlador.
	    public ArrayList <Usuario> getUsuarios ( ) {
			return usuarioService.getAllUsuarios( );
	    }//primer GET
	    
	  	@GetMapping (path = "{usuaId}") 
	  	public Usuario getUsuario ( @PathVariable("usuaId") int usuaId ) {  // Permite capturar valres dinámicos de la URL y utilizarlos dentro del controlador.
	  	    	return usuarioService.getUsuario ( usuaId );
	  	}//segundo GET
	  	
	  	@PostMapping // Ésta mapea las solicitudes HTTP POST a métodos específicos del controlador. 
	  	public Usuario addUsuario (@RequestBody Usuario usuario) { // Los datos relevantes se envían en el cuerpo de la solicitud en lugar de la URL.
		    return usuarioService.addUsuario(usuario);
	  	}//POST
	  	
	  	@PutMapping(path = "{usuaId}") // Ésta mapea las solicitudes HTTP PUT a métodos específicos del controlador.
	  	public Usuario updateUsuario(@PathVariable("usuaId") int usuaId,
				@RequestParam (required = false) String nombre, // Se utiliza para vincular los parámetros de una solicitud ya sea en URL o en cuerpo de la solicitud. 
				@RequestParam (required = false) String correo,
				@RequestParam (required = false) String telefono) {
			    	return usuarioService.updateUsuario( usuaId, nombre, correo, telefono);
			}//PUT
	  	
	  	@DeleteMapping(path = "{usuaId}") // Ésta mapea las solicitudes HTTP DELETE a métodos específicos del controlador.
		public Usuario deleteUsuario (@PathVariable("usuaId") int usuaId ) {
		    return usuarioService.deleteUsuario(usuaId);
		}//DELETE
	
}//Class UsuariosController
