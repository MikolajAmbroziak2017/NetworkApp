package app;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PetMenager {
   private List<Mammal> mammals;
   private List<Dog> dogList;
   private List<Cat> catList;
    public PetMenager(){
        mammals= new ArrayList<Mammal>();
        dogList=new ArrayList<Dog>();
        catList=new ArrayList<Cat>();
        mammals.add(new Dog("Piotrek","4","male","Placki"));
        mammals.add(new Dog("Marcin","4","female","TooForYou"));
        mammals.add(new Cat("Kowal","4","male","Whiskeys"));
        mammals.add(new Cat("Adam","2","female","HotWings"));
        catList.add(new Cat("Adam","2","female","HotWings"));
        dogList.add(new Dog("Adam","2","female","HotWings"));

    }


    public String addDog(String name,String numberOfPaw,String sex,String race){
        Dog dog=new Dog(name,numberOfPaw,sex,race);
       if( mammals.add(dog))
        return "udalo sie dodac psa";
       return "blad przy dodawnaniu";
    }
    public String addCat(String name,String numberOfPaw,String sex,String favFood){
        Cat cat=new Cat(name,numberOfPaw,sex,favFood);
        if( mammals.add(cat))
            return "udalo sie dodac kota";
        return "blad przy dodawnaniu";
    }

    public String updateCat(int id,String name,String numberOfPaw,String sex,String favFood){
        Cat modCat=getCatById(id);
        int mammalsId=mammals.indexOf(modCat);
        mammals.set(mammalsId,new Cat(name,numberOfPaw,sex,favFood));
        return "podmieniono";
    }
    public String updateDog(int id,String name,String numberOfPaw,String sex,String race){
        Dog modDog=getDogById(id);
        int mammalsId=mammals.indexOf(modDog);
        mammals.set(mammalsId,new Dog(name,numberOfPaw,sex,race));
        return "podmieniono";
    }

    public boolean PatchDog(int id,String name)
    {
        Dog modDog=getDogById(id);
        int mammalsId=mammals.indexOf(modDog);
        mammals.set(mammalsId,new Dog(name,getDogById(id).getNumberOfPaw(),getDogById(id).getSex(),getDogById(id).getRace()));
                return getDogById(id).getName()==modDog.getName();
    }
    public boolean PatchCat(int id,String name)
    {
        Cat modCat=getCatById(id);
        int mammalsId=mammals.indexOf(modCat);
        mammals.set(mammalsId,new Cat(name,getCatById(id).getNumberOfPaw(),getCatById(id).getSex(),getCatById(id).getFavFood()));
        return getDogById(id).getName()==modCat.getName();
    }
    public void addMammal(Mammal m){
        mammals.add(m);

    }

    public List<Mammal> getAnimal()  {
        return mammals;
    }

    public List<Dog> getDogList()
    {

        dogList= mammals.stream()
                .filter(Dog.class::isInstance )
                .map(Dog.class::cast)
                .collect(Collectors.toList());
        return dogList;
    }

    public List<Cat> getCatList(){
        catList= mammals.stream()
                .filter(Cat.class::isInstance)
                .map(Cat.class::cast)
                .collect(Collectors.toList());
        return catList;
    }

    public Dog getDogById(int id){
        dogList=getDogList();
        return dogList.get(id-1);

    }
    public Cat getCatById(int id){
        catList=getCatList();
        return catList.get(id-1);
    }


    public boolean delCat(int id){
        Cat delCat=getCatById(id);
        return mammals.remove(delCat);
                  }

    public boolean delDog(int id){
        Dog delDog=getDogById(id);
        return mammals.remove(delDog);
    }


    public List<Mammal> getMammals() {
        return mammals;
    }

    public void setMammals(List<Mammal> mammals) {
        this.mammals = mammals;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public boolean deleteMammalById(Integer id) {
        return mammals.removeIf(mammal -> mammal.getId() == id);
    }

    public Mammal getMammalById(Integer id) {
        return mammals.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

}

