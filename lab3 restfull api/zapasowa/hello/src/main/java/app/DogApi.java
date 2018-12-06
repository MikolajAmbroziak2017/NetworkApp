package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class DogApi extends ResourceSupport {

    private PetMenager petmenager;

    @Autowired // wstrzykiwanie poprzez właściwość
    public void setPetmenager(PetMenager petmenager) {
        this.petmenager = petmenager;
    }
    //wyswietlanie wszystkich psów
    @RequestMapping(value="/dog",method = RequestMethod.GET)
    public ResponseEntity<Resources<DogResource>> getDog() {
        Resources<DogResource> resources = new Resources<>(
                petmenager.getDogList()
                        .stream()
                        .map(DogResource::new)
                        .collect(Collectors.toList()));

        // Zwracamy odnośnik do kolekcji wszystkich psów
        resources.add(linkTo(methodOn(DogApi.class)
                .getDog())
                .withSelfRel());

        return ResponseEntity.ok(resources);
    }
   @PatchMapping("/dog/{id}/{new_name}")
   public ResponseEntity<Void> patchDog(@PathVariable("id") Integer id,@PathVariable("new_name") String name){
      if (petmenager.patchDog(id,name))
            return ResponseEntity.ok().build();
   return ResponseEntity.badRequest().build();
    }


    @PostMapping("/dog/{name}/{paw}/{sex}/{race}/{id}")
    public ResponseEntity<Void> addNewDog(@PathVariable("name")String name, @PathVariable("paw") String numberOfPaw, @PathVariable("sex") String sex, @PathVariable("race") String race, @PathVariable("id") Integer id){

        if(petmenager.addDog(name,numberOfPaw,sex,race,id))
        return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/dog/{id}/{name}/{paw}/{sex}/{race}")
    public boolean addNewDog(@PathVariable("id") Integer id,@PathVariable("name")String name,@PathVariable("paw") String numberOfPaw,@PathVariable("sex") String sex,@PathVariable("race") String race){
Dog newDog=new Dog(name,numberOfPaw,sex,race,id);
        return  petmenager.updateDog(id,newDog);
    }
    @RequestMapping(method = RequestMethod.GET,value ="/dog/{id}")
    public ResponseEntity<DogResource> getDogById(@PathVariable("id") Integer id) {
        Dog resultDog = petmenager.getDogById(id);
        if(resultDog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new DogResource(resultDog));
    }
    @RequestMapping(method = RequestMethod.DELETE,value ="/dog/{dog_id}")
    public ResponseEntity<Void> delDogById (@PathVariable("dog_id") Integer id) {
        if (petmenager.delDog(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    //head dog
    @RequestMapping(value = "/dog", method = RequestMethod.HEAD)
    public HttpEntity<String> headDog()
    {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("wszystkie pieski", Collections.singletonList(petmenager.getDogList().toString()));

        HttpEntity<String> responseEntity = new HttpEntity<String>("test body", headers);
        return responseEntity;
    }

    //OPTIONS dog
    @RequestMapping(value = "/dog", method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,DELETE,OPTIONS");
        return new ResponseEntity(HttpStatus.OK);
    }



}
