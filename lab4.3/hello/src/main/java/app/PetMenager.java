package app;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PetMenager {
   private List<Mammal> mammals;
    public PetMenager(){
        mammals= new ArrayList<Mammal>();
        mammals.add(new Dog("Piotrek","4","male","Placki"));
        mammals.add(new Dog("Marcin","4","female","TooForYou"));
        mammals.add(new Cat("Kowal","4","male","Whiskeys"));
        mammals.add(new Cat("Adam","2","female","HotWings"));
    }

    public void addMammal(Mammal m){mammals.add(m);}
    public List<Mammal> getAnimal()  {return mammals;};

    @Override
    public String toString() {
        return super.toString();
    }
}
