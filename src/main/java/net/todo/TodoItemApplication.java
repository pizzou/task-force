package net.todo;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import net.todo.config.SpringSecurityAuditorAware;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication
@EnableSwagger2
public class TodoItemApplication {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}

	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(TodoItemApplication.class, args);
	}

}
