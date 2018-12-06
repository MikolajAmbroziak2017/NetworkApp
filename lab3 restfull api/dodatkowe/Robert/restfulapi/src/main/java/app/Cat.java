package app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Cat extends Mammal {
    private String favouriteFood;

    public Cat(int id, String favouriteFood, String name, int numberOfPaws, char sex) {
        super(id, name, numberOfPaws, sex);
        this.favouriteFood = favouriteFood;
    }

    @Override
    public String toString() {
        return super.toString() + " " + favouriteFood;
    }

    public void update(Map<String, String> paramsToUpdate) {
        super.update(paramsToUpdate);

        if(paramsToUpdate.containsKey("favouriteFood")) {
            favouriteFood = paramsToUpdate.get("favouriteFood");
        }
    }
}
