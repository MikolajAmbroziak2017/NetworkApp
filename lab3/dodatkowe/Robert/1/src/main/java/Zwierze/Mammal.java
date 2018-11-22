package Zwierze;

abstract public class Mammal
{
    private String name;
    private int numberOfPaw;
    private boolean sex;

    public Mammal(String name , int numberofPaw, boolean sex)
    {
        this.name = name;
        this.numberOfPaw = numberofPaw;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Name: '" + this.getName() + "', Paws: '" + this.getNumberOfPaw();
    }

    public String getName() {
        return name;
    }

    public boolean getSex() {
        return sex;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getNumberOfPaw() {
        return numberOfPaw;
    }

    public void setNumberOfPaw(int numberOfPaw) {
        this.numberOfPaw = numberOfPaw;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
