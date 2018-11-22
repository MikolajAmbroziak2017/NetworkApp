package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/showAnimals")
    public ResponseEntity <List<Mammal>> getAnimal(){ //pzzekazujemy liste do clienta
        ResponseEntity <List<Mammal>> listResponseEntity= new ResponseEntity<List<Mammal>>(petmenager.getAnimal(),HttpStatus.OK); // obsługa błędu serweru
        return listResponseEntity;
    }

    @GetMapping("/showNoWorkAnimals")
    public ResponseEntity <List<Mammal>> getNoWorkAnimal(){ //pzzekazujemy liste do clienta
        ResponseEntity <List<Mammal>> listResponseEntity= new ResponseEntity<List<Mammal>>(petmenager.getAnimal(),HttpStatus.INTERNAL_SERVER_ERROR);
        return listResponseEntity;
    }


    @GetMapping("/addMammal")
    public void addAnimal(){
        petmenager.addMammal(
            new Dog(1,"Miki","6","gender","SuperDoog!"));

        }
    }
// laborka 3 typy wstrzykiwania zależności