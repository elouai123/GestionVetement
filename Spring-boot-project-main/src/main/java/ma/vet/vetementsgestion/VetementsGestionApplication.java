package ma.vet.vetementsgestion;

import ma.vet.vetementsgestion.entity.Vetements;
import ma.vet.vetementsgestion.repository.VetementsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VetementsGestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetementsGestionApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(VetementsRepository vetementsRepository){
		return args -> {
			vetementsRepository.save(new Vetements(null,"pentalon","XXL",200,100));
			vetementsRepository.save(new Vetements(null,"jupe","M",240,30));
			vetementsRepository.save(new Vetements(null,"Chaussure","L",800,15));
			vetementsRepository.save(new Vetements(null,"T-Shirt","XXL",200,105));
			vetementsRepository.findAll().forEach(
					v -> {
						System.out.println(v.getNom());
					}
			);

		};
	}
}
