package app;

import org.springframework.hateoas.ResourceSupport;

public abstract class  Mammal extends ResourceSupport {
    private String name;
    private String numberOfPaw;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfPaw() {
        return numberOfPaw;
    }

    public void setNumberOfPaw(String numberOfPaw) {
        this.numberOfPaw = numberOfPaw;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Mammal(String name, String numberOfPaw, String sex) {

        this.name = name;
        this.numberOfPaw = numberOfPaw;
        this.sex = sex;
    }
    public String toString() {
        return "name: "+this.name+ " " +"number of paws: "+this.numberOfPaw+ " "+"sex: "+this.sex+ " " ;
    }zz
}
