package CRUD.API.WEB;

import CRUD.API.WEB.entities.Client;
import CRUD.API.WEB.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CrudThymeleafApplication /*implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(CrudThymeleafApplication.class, args);
	}

/*
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public void run(String... args) throws Exception {
		Client client1 = new Client ("Jorge","Fdez", "640280000", "jfdez@gmail.com", LocalDate.of(1981, 1, 22));
		clientRepository.save(client1);

		Client client2 = new Client ("Andre","Carrillo", "63333000", "andrecar@gmail.com",LocalDate.of(1977, 1, 22));
		clientRepository.save(client2);
}*/
}