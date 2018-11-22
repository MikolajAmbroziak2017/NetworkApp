package app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class Dog extends Mammal {
    private String race;

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }


    public Dog(String name, String numberOfPaw, String sex, String race) {
        super( name, numberOfPaw, sex);
        this.race = race;

    }

    @Override
    public String toString() {
        return this.race + " " + super.toString();
    }
}
