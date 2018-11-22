package Zwierze;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat extends Mammal
{
    private String favouriteFood;

    @JsonCreator
    public Cat(@JsonProperty("name") String name, @JsonProperty("numberofPaw") int numberofPaw,
               @JsonProperty("sex") boolean sex, @JsonProperty("favouriteFood") String favouriteFood)
    {
        super(name,numberofPaw,sex);
        this.favouriteFood = favouriteFood;
    }

    /*
    public Cat(String name, int numberofPaw, boolean sex ,  String favouriteFood)
    {
        super(name, numberofPaw, sex);
        this.favouriteFood = favouriteFood;
    }
*/
    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    @Override
    public String toString()
    {
        return "Name: '" + this.getName() + "', Number of Paw : '" + this.getNumberOfPaw()
                + "Food: " + this.getFavouriteFood();
    }
}
