package Zwierze;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dog extends Mammal
{
    private String race;

        @JsonCreator
        public Dog(@JsonProperty("name") String name, @JsonProperty("numberofPaw") int numberofPaw,
                     @JsonProperty("sex") boolean sex, @JsonProperty("race") String race)
        {
            super(name,numberofPaw,sex);
            this.race = race;
        }
    /*

        public Dog(String name , int numberofPaw, boolean sex , String race)
        {
            super(name,numberofPaw,sex);
            this.race = race;
        }
    */

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString()
    {
        return "Name: '" + this.getName() + "', Number of Paw : '" + this.getNumberOfPaw()
                + "', Race: '" + this.getRace();
    }
}
