package app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Getter
@Setter
public class PetManager {
    protected List<Mammal> mammals;

    public PetManager() {
        mammals = new ArrayList<>();
        mammals.add(new Dog(1, "Bulldog", "Burek", 4, 'M'));
        mammals.add(new Dog(2, "York", "Jork", 4, 'F'));
        mammals.add(new Cat(3, "Dachowiec", "Kiciuś", 4, 'M'));
        mammals.add(new Cat(4, "Dachowiec", "Kicia", 4, 'F'));
    }

    public boolean deleteMammalById(Integer id) {
        return mammals.removeIf(mammal -> mammal.getId() == id);
    }

    public Mammal getMammalById(Integer id) {
        return mammals.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean deleteDogById(Integer id) {
        return mammals.removeIf(mammal -> mammal instanceof Dog && mammal.getId() == id);
    }

    public List<Dog> getAllDogs() {
        return mammals.stream()
                .filter(Dog.class::isInstance)
                .map(Dog.class::cast)
                .collect(Collectors.toList());
    }

    public Dog getDogById(Integer id) {
        return (Dog)mammals.stream()
                .filter(Dog.class::isInstance)
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean replaceDogById(Integer id, Dog newDog) {
        if(!mammals.removeIf(d -> d.getId() == id)) {
            return false;
        }
        mammals.add(newDog);

        return true;
    }

    public boolean deleteCatById(Integer id) {
        return mammals.removeIf(mammal -> mammal instanceof Cat && mammal.getId() == id);
    }

    public List<Cat> getAllCats() {
        return mammals.stream()
                .filter(Cat.class::isInstance)
                .map(Cat.class::cast)
                .collect(Collectors.toList());
    }

    public Cat getCatById(Integer id) {
        return (Cat)mammals.stream()
                .filter(Cat.class::isInstance)
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean replaceCatById(Integer id, Cat newCat) {
        if(!mammals.removeIf(d -> d.getId() == id)) {
            return false;
        }
        mammals.add(newCat);

        return true;
    }
}

