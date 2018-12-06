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
        mammals.add(new Dog("Piotrek","4","male","Placki",23));
        mammals.add(new Dog("Marcin","4","female","TooForYou",76));
        mammals.add(new Cat("Kowal","4 ","male","Whiskeys",13));
        mammals.add(new Cat("Adam","2","female","HotWings",43));
        catList.add(new Cat("Adam","2","female","HotWings",78));
        dogList.add(new Dog("Adam","2","female","HotWings",11));

    }
    public boolean deleteMammalById(Integer id)
    {
        return mammals.removeIf(mammal -> mammal.getId() == id);
    }

    public Mammal getMammalById(Integer id) {
        return mammals.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
public int getListId(int id){
        int listID=0;
    for (Mammal mammal : mammals)
          {
              if(mammal.getId()==id){
                  listID=mammals.indexOf(mammal);
                  return listID;
              }
    }
       return listID;
}


    public boolean addDog(String name,String numberOfPaw,String sex,String race,Integer id){
        Dog dog=new Dog(name,numberOfPaw,sex,race,id);
       return mammals.add(dog);

    }
    public boolean addCat(String name,String numberOfPaw,String sex,String favFood,Integer id){
        Cat cat=new Cat(name,numberOfPaw,sex,favFood,id);
        return mammals.add(cat);

    }

    public boolean updateCat(int id,Cat newCat){

        if(!mammals.removeIf(d -> d.getId() == id)) {
            return false;
        }
        mammals.add(newCat);

        return true;
    }

    public boolean updateDog(int id,Dog newDog){
        if(!mammals.removeIf(d -> d.getId() == id)) {
            return false;
        }
        mammals.add(newDog);

        return true;
    }

    public boolean patchDog(int id,String name)
    {

        Dog modDog=getDogById(id);
        Dog newDog =new Dog(name,modDog.getNumberOfPaw(),modDog.getSex(),modDog.getRace(),modDog.getId());
        int mammalsId=mammals.indexOf(modDog);
        mammals.set(mammalsId,newDog);
        return ((Dog)(mammals.get(mammalsId))).equals(newDog);
    }
    public boolean patchCat(int id,String name)
    {
        Cat modCat=getCatById(id);
        Cat newCat=new Cat(name,modCat.getNumberOfPaw(),modCat.getSex(),modCat.getFavFood(),modCat.getId());
        int mammalsId=mammals.indexOf(modCat);
        mammals.set(mammalsId,newCat);
        return ((Cat)(mammals.get(mammalsId))).equals(newCat);
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
        return (Dog)mammals.stream()
                .filter(Dog.class::isInstance)
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);

    }
    public Cat getCatById(int id){
        return (Cat)mammals.stream()
                .filter(Cat.class::isInstance)
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public boolean delCat(int id){

        return mammals.removeIf(mammal -> mammal.getId() == id && mammal instanceof Cat);
                  }

    public boolean delDog(int id){

        return mammals.removeIf(mammal -> mammal.getId() == id && mammal instanceof Dog);
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
}

