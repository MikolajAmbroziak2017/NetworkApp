package app;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Mammal implements Updatable {
    private int id;
    private String name;
    private int numberOfPaws;
    private char sex;

    public Mammal(int id, String name, int numberOfPaws, char sex) {

    }

    public void update(Map<String, String> paramsToUpdate) {
        if(paramsToUpdate.containsKey("name")) {
            name = paramsToUpdate.get("name");
        }

        if(paramsToUpdate.containsKey("numberOfPaws")) {
            numberOfPaws = Integer.parseInt(paramsToUpdate.get("numberOfPaws"));
        }

        if(paramsToUpdate.containsKey("sex")) {
            sex = paramsToUpdate.get("sex").charAt(0);
        }
    }
}
