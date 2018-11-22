package app;

public class Cat extends Mammal {

   private String favFood;

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }


    public Cat(String name, String numberOfPaw, String sex, String favFood) {
        super(name, numberOfPaw, sex);
        this.favFood = favFood;
    }
    @Override
    public String toString() {
        return this.favFood + " " + super.toString();
    }


}
