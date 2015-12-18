package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import api.StandardOutput;

@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/")
	public StandardOutput home() {
		StandardOutput message = new StandardOutput("home");
		return message;
	}


	@RequestMapping("/random/{numbers}")
	public @ResponseBody RandomGenerator conversion(@PathVariable("numbers") int numbers) {

		return new RandomGenerator(numbers);

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
