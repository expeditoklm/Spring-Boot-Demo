package bj.formation.demoprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "bj.formation.demoprojet.entities") // Vérifie que le package est correct
@EnableJpaRepositories(basePackages = "bj.formation.demoprojet.repositories")

public class DemoprojetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoprojetApplication.class, args);
	}

}
