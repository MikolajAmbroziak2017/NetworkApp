package app;

public class Dog extends Mammal {
    private String rase;

    public void setRace(String race) {
        this.rase = race;
    }

    public String getRace() {
        return rase;
    }


    public Dog(String name, String numberOfPaw, String sex, String rase) {
        super(name, numberOfPaw, sex);
        this.rase = rase;
    }
    @Override
    public String toString() {
        return this.rase + " " + super.toString();
    }
}
