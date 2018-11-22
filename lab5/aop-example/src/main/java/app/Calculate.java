package app;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component
public class Calculate {
    @MyAdnontation
    public int calculateSomething(){
        System.out.println("calulate");
        return 10;
    }
}
