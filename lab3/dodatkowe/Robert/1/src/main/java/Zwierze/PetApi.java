package Zwierze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

//To samo z 3 typami wstrzykiwania zaleznosci
//Przez konstruktor
//Przez settery


@RestController
public class PetApi
{
    //Wstrzykniecie instacji z kontenera
    @Autowired
    private Manager getManager;

    @GetMapping("/showAnimals")
    public ResponseEntity<List<Mammal>> getAnimal()
    {
        ResponseEntity<List<Mammal>> listResponseEntity=new ResponseEntity<List<Mammal>>(getManager.getAll(), HttpStatus.OK);
        return listResponseEntity;
    }

    @GetMapping("/getNoWorkAnimals")
    public ResponseEntity <List<Mammal>> getNoWorkAnimals() {
        ResponseEntity<List<Mammal>> listResponseEntity=new ResponseEntity<List<Mammal>>(getManager.getAll(), HttpStatus.INTERNAL_SERVER_ERROR);
        return listResponseEntity;
    }

    @GetMapping("/addMammal")
    public void addAnimal(){
        getManager.addMammal(new Dog("dasdas",4,false ,"dasdas"));
    }

    //***************************** ******** Zadanie 2 *****************************

    @Autowired
    public void setGetManager(Manager manager)
    {
        this.getManager = manager;
    }

    @GetMapping("/showAnimalsZadanie2")
    public String getAnimalZadanie2()
    {
        return getManager.getAll().toString();
    }

    @GetMapping("/addMammalZadanie2")
    public void addAnimalZadanie2()
    {
        getManager.addMammal(new Dog("allah",4,true,"PC MASTER RACE!"));
    }

    //***************************** ******** Zadanie 3 *****************************

                                                          //Dziala
    @RequestMapping(value = "/dog", method = RequestMethod.POST)
    public void addManmal(@RequestBody Dog dog)
    {
        getManager.addMammal(dog);
    }
                                                        //Dziala
    @RequestMapping(value = "/cat", method = RequestMethod.POST)
    public void addManmal(@RequestBody Cat cat)
    {
        getManager.addMammal(cat);
    }

    //GET/dog                                           //Dziala
    @RequestMapping(value = "/dogs", method = RequestMethod.GET)
    public String getDog()
    {
       return  getManager.getAllDogs().toString();
    }
    //GET/cat                                           //Dziala
    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    public String getCat()
    {
        return  getManager.getAllCats().toString();
    }


    //GET/dog/4                                         //Dziala
    @RequestMapping(value = "/Dog/{id}", method = RequestMethod.GET)
    public String getDog(@PathVariable("id") int id)
    {
        return getManager.getAllDogs().get(id).toString();
    }

    //GET/cat/4                                        //Dziala
    @RequestMapping(value = "/Cat/{id}", method = RequestMethod.GET)
    public String getCat(@PathVariable("id") int id)
    {
        return getManager.getAllCats().get(id).toString();
    }



    //Put dog/4                                     //Dziala
    @RequestMapping(value = "/Dog/{id}", method = RequestMethod.PUT)
    public void updateManmal(@PathVariable("id") int id,@RequestBody Dog dog)
    {
        getManager.getDog(id).setName(dog.getName());
        getManager.getDog(id).setNumberOfPaw(dog.getNumberOfPaw());
        getManager.getDog(id).setSex(dog.getSex());
        getManager.getDog(id).setRace(dog.getRace());
    }

    //Put dog/4                                    //Dziala
    @RequestMapping(value = "/Cat/{id}", method = RequestMethod.PUT)
    public void updateManmal(@PathVariable("id") int id,@RequestBody Cat cat)
    {
        getManager.getCat(id).setName(cat.getName());
        getManager.getCat(id).setNumberOfPaw(cat.getNumberOfPaw());
        getManager.getCat(id).setSex(cat.getSex());
        getManager.getCat(id).setFavouriteFood(cat.getFavouriteFood());
    }


    //Delete/Dog/1                                              //dziala
    @RequestMapping(value = "/Dog/{number}", method = RequestMethod.DELETE)
    public void deleteDog(@PathVariable("number") int number)
    {
        getManager.getAll().remove(number);
    }

    //Delete/Dog/1                                              //dziala
    @RequestMapping(value = "/Cat/{number}", method = RequestMethod.DELETE)
    public void deleteCat(@PathVariable("number") int number)
    {
        getManager.getAll().remove(number);
    }


    //Head
    @RequestMapping(value = "/Mammal", method = RequestMethod.HEAD)
    public HttpEntity<String> headManmal()
    {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("test-header", Arrays.asList("test-header-value"));

        HttpEntity<String> responseEntity = new HttpEntity<String>("test body", headers);
        return responseEntity;
    }

    //OPTIONS
    @RequestMapping(value = "/Mammal", method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS");
        return new ResponseEntity(HttpStatus.OK);
    }

    //Patch
    @RequestMapping(value = "/Dog/{id}", method = RequestMethod.PATCH)
    public void OptManmal(@PathVariable("id") int id ,@RequestBody Dog dog)
    {
        getManager.getDog(id).setName(dog.getName());
    }

    //Patch
    @RequestMapping(value = "/Cat/{id}", method = RequestMethod.PATCH)
    public void OptMammal(@PathVariable("id") int id ,@RequestBody Cat cat)
    {
        getManager.getCat(id).setName(cat.getName());
    }
}
