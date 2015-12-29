package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public Map<String, Object> home() {

        Map<String, Object> body = new HashMap<>();

        body.put("status", "OK");
        body.put("status2", "UP");



        return body;
    }

    @RequestMapping("/random/{numbers}")
    public
    @ResponseBody
    RandomGenerator conversion(@PathVariable("numbers") int numbers) {

        return new RandomGenerator(numbers);

    }

    @RequestMapping("/random")
    public
    @ResponseBody
    RandomGenerator conversion() {

        return conversion(1);

    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
