package ejemplo.modelo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ejemplo.modelo.repositorio.RepositorioUsuario;

public class UsuarioServicio implements UserDetailsService {

	@Autowired
	private RepositorioUsuario repous;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return repous.findByEmail(email);
	}

}
