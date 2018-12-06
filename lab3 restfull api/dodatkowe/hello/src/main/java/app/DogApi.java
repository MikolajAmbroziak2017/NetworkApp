package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class DogApi {

    private PetMenager petmenager;

    @Autowired // wstrzykiwanie poprzez właściwość
    public void setPetmenager(PetMenager petmenager) {
        this.petmenager = petmenager;
    }




    @RequestMapping(value = "/dog", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resources<MammalResource>> getAllDogs() {
        Resources<MammalResource> resources = new Resources<>(
                manager.getAllDogs()
                        .stream()
                        .map(MammalResource::new)
                        .collect(Collectors.toList()));

        // Zwracamy odnośnik do kolekcji wszystkich psów
        resources.add(linkTo(methodOn(DogApi.class)
                .getAllDogs())
                .withSelfRel());

        return ResponseEntity.ok(resources);
    }


   @PatchMapping("/dog/{id}/{new_name}")
   public ResponseEntity<Void> patchDog(@PathVariable("id") Integer id,@PathVariable("new_name") String name){

        if(petmenager.PatchDog(id,name))
            return ResponseEntity.ok().build();
   return ResponseEntity.badRequest().build();
    }


    @PostMapping("/dog/{name}/{paw}/{sex}/{race}")
    public String addNewDog(@PathVariable("name")String name, @PathVariable("paw") String numberOfPaw, @PathVariable("sex") String sex, @PathVariable("race") String race){

        return petmenager.addDog(name,numberOfPaw,sex,race);
    }
    @PutMapping("/dog/{id}/{name}/{paw}/{sex}/{race}")
    public String addNewDog(@PathVariable("id") Integer id,@PathVariable("name")String name,@PathVariable("paw") String numberOfPaw,@PathVariable("sex") String sex,@PathVariable("race") String race){

        return petmenager.updateDog(id,name,numberOfPaw,sex,race);
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @RequestMapping(method = RequestMethod.GET,value ="/dog/{dog_id}")
    public ResponseEntity<DogResource>  getDogById (@PathVariable("dog_id") Integer id) {
        if (id>petmenager.getDogList().size())
            return null;
        return ResponseEntity.ok(new DogResource(petmenager.getDogById(id), id));
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



    @RequestMapping(method = RequestMethod.DELETE,value ="/dog/{dog_id}")
    public ResponseEntity<Void> delDogById (@PathVariable("dog_id") Integer id) {
        if (petmenager.delDog(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // OPTIONS I HEAD AUTOMATYCZNIE OBSŁUGIWANE!!!

    //head dog
    @RequestMapping(value = "/dog", method = RequestMethod.HEAD)
    public HttpEntity<String> headDog()
    {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("psy w budzie", Collections.singletonList(petmenager.getDogList().toString()));

        HttpEntity<String> responseEntity = new HttpEntity<String>("test body", headers);
        return responseEntity;
    }


    //OPTIONS dog
    @RequestMapping(value = "/dog", method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS");
        return new ResponseEntity(HttpStatus.OK);
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

}
