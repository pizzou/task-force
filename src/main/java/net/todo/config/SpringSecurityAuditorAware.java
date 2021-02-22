package net.todo.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		
		// Just return a string representing the username
		return Optional.ofNullable("Patrick").filter(s -> !s.isEmpty());
	}
	
}