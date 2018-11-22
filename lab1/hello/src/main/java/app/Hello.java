package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/Hello")
    public String main() {
        return"helloTwo";
    }


@GetMapping("/")
public String main2(){return "Hello2"; }
}