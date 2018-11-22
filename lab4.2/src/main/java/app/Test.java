package app;

import org.springframework.web.bind.annotation.GetMapping;

public class Test {
    @GetMapping("/Hello")
    public String Test() {
        return"helloTwo";
    }
}
