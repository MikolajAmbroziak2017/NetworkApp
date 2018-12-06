package app;

import Zwierze.Cat;
import Zwierze.Dog;
import Zwierze.Manager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Hello
{
    @GetMapping("/hello")
    public String main()
    {
        /*
        Manager m = new Manager();
        m.DodajZwierze(new Dog("Max", 4,true, "Owczarek"));
        m.DodajZwierze(new Dog("Max2", 3,false, "Bolg"));
        m.DodajZwierze(new Cat("Katt", 4,false, "Fish"));
        m.DodajZwierze(new Cat("Katt", 2,true, "Cheese"));

        List<Cat> c = m.getAllCats();
        List<Dog> d = m.getAllDogs();

        StringBuilder s = new StringBuilder();

        for(int i = 0;i<c.size();i++)
        {
            s.append(c.get(i).toString());
        }

        return s.toString();
        */
        return "csa";
    }

}
