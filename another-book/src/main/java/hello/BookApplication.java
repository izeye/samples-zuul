package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Book application.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
@RestController
public class BookApplication {

	@GetMapping("/available")
	public String available() {
		return "Spring in Action in another-book";
	}

	@GetMapping("/checked-out")
	public String checkedOut() {
		return "Spring Boot in Action in another-book";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}
