package app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class Cat extends Mammal {

   private String favFood;

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }


    public Cat(String name, String numberOfPaw, String sex, String favFood,Integer id) {
        super(name, numberOfPaw, sex,id);
        this.favFood = favFood;

    }
    @Override
    public String toString() {
        return this.favFood + " " + super.toString();
    }


}
