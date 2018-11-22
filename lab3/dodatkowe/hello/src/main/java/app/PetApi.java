package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetApi {
/* wstrzykiwanie poprzez pole
    @Autowired
    private Menager petmenager;
*/
/*  wstrzykiwanie poprzez konstruktor
    private Menager petmenager;
    @Autowired
    public PetApi(Menager petmenager) {
        this.petmenager = petmenager;
    }
*/
private PetMenager petmenager;

    @Autowired // wstrzykiwanie poprzez właściwość
    public void setPetmenager(PetMenager petmenager) {
        this.petmenager = petmenager;
    }


    //wyswietlanie wszystkich zwierząt
    @GetMapping("/showAnimals")
    public ResponseEntity <List<Mammal>> getAnimal(){ //pzzekazujemy liste do clienta
        ResponseEntity <List<Mammal>> listResponseEntity= new ResponseEntity<List<Mammal>>(petmenager.getAnimal(),HttpStatus.OK); // obsługa błędu serweru
        return listResponseEntity;
    }




    //wyświetlanie błędu zwrotnego
    @GetMapping("/showNoWorkAnimals")
    public ResponseEntity <List<Mammal>> getNoWorkAnimal(){ //pzzekazujemy liste do clienta
        ResponseEntity <List<Mammal>> listResponseEntity= new ResponseEntity<List<Mammal>>(petmenager.getAnimal(),HttpStatus.INTERNAL_SERVER_ERROR);
        return listResponseEntity;
    }


    //dodawanie nowych zwierzaków do listy
    @GetMapping("/addMammal")
    public void addAnimal(){
        petmenager.addMammal(
                new Dog("Miki","6","gender","SuperDoog!"));
        }



////testowe
//@GetMapping(value = "/hateoas/showAnimals", produces = MediaTypes.HAL_JSON_VALUE)
//public ResponseEntity<List<Mammal>> getHateoasAnimal()
//{
//
//    for(int i = 0;i<petmenager.getAll().size();i++)
//    {
//        if(petmenager.getAll().get(i) instanceof Dog)
//        {
//            petmenager.getDogById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/dog/" + String.valueOf(i)).withSelfRel().withType("GET"));
//            petmenager.getDogById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/dog").withSelfRel().withType("GET"));
//            petmenager.getDogById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/dog").withSelfRel().withType("POST"));
//            petmenager.getDogById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/dog/" + String.valueOf(i)).withSelfRel().withType("PUT"));
//            petmenager.getDogById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/dog/" + String.valueOf(i)).withSelfRel().withType("DELETE"));
//            petmenager.getDogById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/dog/" + String.valueOf(i)).withSelfRel().withType("PATCH"));
//        }
//        else
//        {
//            //petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash(i).withRel("localhost:8000/cat"));
//            //petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(Cat.class).getName()).withSelfRel());
//            petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/cat/" + String.valueOf(i)).withSelfRel().withType("GET"));
//            petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/cat").withSelfRel().withType("GET"));
//            petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/cat").withSelfRel().withType("POST"));
//            petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/cat/" + String.valueOf(i)).withSelfRel().withType("PUT"));
//            petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/cat/" + String.valueOf(i)).withSelfRel().withType("DELETE"));
//            petmenager.getCatById(i).add(ControllerLinkBuilder.linkTo(PetMenager.class).slash("/cat/" + String.valueOf(i)).withSelfRel().withType("PATCH"));
//        }
//    }
//    ResponseEntity<List<Mammal>> listResponseEntity=new ResponseEntity<List<Mammal>>(petmenager.getAll(), HttpStatus.OK);
//    return listResponseEntity;
//}
//
//
//
//

}

// laborka 3 typy wstrzykiwania zależności