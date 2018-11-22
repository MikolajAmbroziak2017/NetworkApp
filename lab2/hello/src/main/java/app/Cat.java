package app;

public class Cat extends Mammal {

   private String favFood;
   private int id;

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }


    public Cat(int id,String name, String numberOfPaw, String sex, String favFood) {
        super(name, numberOfPaw, sex);
        this.favFood = favFood;
        this.id=id;
    }
    @Override
    public String toString() {
        return this.favFood + " " + super.toString();
    }


}
