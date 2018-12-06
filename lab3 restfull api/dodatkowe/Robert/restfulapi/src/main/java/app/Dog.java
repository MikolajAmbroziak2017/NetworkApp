package app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Dog extends Mammal {
    private String race;

    public Dog(int id, String race, String name, int numberOfPaws, char sex) {
        super(id, name, numberOfPaws, sex);
        this.race = race;
    }

    @Override
    public String toString() {
        return super.toString() + " " + race;
    }

    public void update(Map<String, String> paramsToUpdate) {
        super.update(paramsToUpdate);

        if(paramsToUpdate.containsKey("race")) {
            race = paramsToUpdate.get("race");
        }
    }
}
