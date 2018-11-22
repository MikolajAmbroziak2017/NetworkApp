package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class Hello {

    @Value("${size}")
    private int mySize;
    @Value("${name}")
    private String myName;

    @Autowired
    private Calculate calculate;

//    @GetMapping("/sayHello")
//    public String main(){return "hello!"+myName+mySize;}

    @GetMapping("/main")
    public void main(){calculate.calculateSomething();}

}
