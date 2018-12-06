package app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
public abstract class  Mammal   {
    private String name;
    private String numberOfPaw;
    private String sex;
    private Integer id;


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNumberOfPaw() {
//        return numberOfPaw;
//    }
//
//    public void setNumberOfPaw(String numberOfPaw) {
//        this.numberOfPaw = numberOfPaw;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public void setMammal_id(Integer id) {
//        this.mammal_id = id;
//    }
//
//    public Integer getId() {
//        return mammal_id;
//    }

    public Mammal(String name, String numberOfPaw, String sex, Integer id) {

        this.name = name;
        this.numberOfPaw = numberOfPaw;
        this.sex = sex;
        this.id=id;
    }
    public String toString() {
        return "name: "+this.name+ " " +"number of paws: "+this.numberOfPaw+ " "+"sex: "+this.sex+ " " ;
    }
}
