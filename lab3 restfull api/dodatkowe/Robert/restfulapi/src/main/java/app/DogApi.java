package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class DogApi {

    @Autowired
    private PetManager manager;

    @DeleteMapping("/dogs/{id}")
    public ResponseEntity<Void> deleteDogById(@PathVariable("id") Integer id) {
        if(manager.deleteDogById(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/dogs", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resources<DogResource>> getAllDogs() {
        Resources<DogResource> resources = new Resources<>(
                manager.getAllDogs()
                        .stream()
                        .map(DogResource::new)
                        .collect(Collectors.toList()));

        // Zwracamy odnośnik do kolekcji wszystkich psów
        resources.add(linkTo(methodOn(DogApi.class)
                .getAllDogs())
                .withSelfRel());

        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/dogs/{id}", method = RequestMethod.GET)
    public ResponseEntity<DogResource> getDogById(@PathVariable("id") Integer id) {
        Dog resultDog = manager.getDogById(id);

        if(resultDog == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new DogResource(resultDog));
    }

    @RequestMapping(value = "/dogs/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<DogResource> updateDogById(@PathVariable("id") Integer id,
                                             @RequestParam Map<String, String> paramsToUpdate) {
        Dog dogToUpdate = manager.getDogById(id);

        if(dogToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        dogToUpdate.update(paramsToUpdate);

        return ResponseEntity.ok().body(new DogResource(dogToUpdate));
    }

    @RequestMapping(value = "/dogs", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DogResource addDog(@RequestBody Dog newDog) {
        manager.getMammals().add(newDog);

        return new DogResource(newDog);
    }

    @RequestMapping(value = "/dogs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DogResource> replaceDogById(@RequestBody Dog newDog, @PathVariable("id") Integer id) {
        if(!manager.replaceDogById(id, newDog)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new DogResource(newDog));
    }
}
