package Zwierze;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Manager
{
    private List<Mammal> Zwierzeta;

    public  Manager()
    {
        Zwierzeta = new ArrayList<Mammal>();
        Zwierzeta.add(new Dog("Max", 4,true, "Owczarek"));
        Zwierzeta.add(new Cat("Katt", 4,false, "Fish"));
        Zwierzeta.add(new Cat("Katt2", 2,true, "Cheese"));
        Zwierzeta.add(new Dog("Max2", 3,false, "Bolg"));

    }

    public  List<Mammal> getAll () {return Zwierzeta;}
    public void addMammal(Mammal m ) {Zwierzeta.add(m);}
    public Mammal getMamnal(int i) {return Zwierzeta.get(i);}
    public Dog getDog(int i) {return (Dog)Zwierzeta.get(i);}
    public Cat getCat(int i) {return (Cat)Zwierzeta.get(i);}

    public void DodajZwierze(Mammal m)
    {
        Zwierzeta.add(m);
    }

    public List<Cat> getAllCats()
    {
        List<Cat> Koty = new ArrayList<Cat>();

        for(int i = 0;i<Zwierzeta.size();i++)
        {
            if(Zwierzeta.get(i) instanceof Cat)
                Koty.add((Cat) Zwierzeta.get(i));
        }

        return Koty;
    }
    public List<Dog> getAllDogs()
    {
        List<Dog> Psy = new ArrayList<Dog>();

        for(int i = 0;i<Zwierzeta.size();i++)
        {
            if(Zwierzeta.get(i) instanceof Dog)
                Psy.add((Dog) Zwierzeta.get(i));
        }
        return  Psy;
    }
}
