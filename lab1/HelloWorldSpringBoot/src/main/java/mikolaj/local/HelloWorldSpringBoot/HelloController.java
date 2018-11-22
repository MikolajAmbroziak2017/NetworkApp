package mikolaj.local.HelloWorldSpringBoot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello World!");
        return "Hello World";
    }
}
