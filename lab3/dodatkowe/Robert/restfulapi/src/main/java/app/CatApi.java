package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CatApi {

    @Autowired
    private PetManager manager;

    @DeleteMapping("/cats/{id}")
    public ResponseEntity<Void> deleteCatById(@PathVariable("id") Integer id) {
        if(manager.deleteCatById(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resources<CatResource>> getAllCats() {
        Resources<CatResource> resources = new Resources<>(
                manager.getAllCats()
                        .stream()
                        .map(CatResource::new)
                        .collect(Collectors.toList()));

        // Zwracamy odnośnik do kolekcji wszystkich psów
        resources.add(linkTo(methodOn(CatApi.class)
                .getAllCats())
                .withSelfRel());

        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/cats/{id}", method = RequestMethod.GET)
    public ResponseEntity<CatResource> getCatById(@PathVariable("id") Integer id) {
        Cat resultCat = manager.getCatById(id);

        if(resultCat == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new CatResource(resultCat));
    }

    @RequestMapping(value = "/cats/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<CatResource> updateDogById(@PathVariable("id") Integer id,
                                             @RequestParam Map<String, String> paramsToUpdate) {
        Cat catToUpdate = manager.getCatById(id);

        if(catToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        catToUpdate.update(paramsToUpdate);

        return ResponseEntity.ok().body(new CatResource(catToUpdate));
    }

    @RequestMapping(value = "/cats", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CatResource addDog(@RequestBody Cat newCat) {
        manager.getMammals().add(newCat);

        return new CatResource(newCat);
    }

    @RequestMapping(value = "/cats/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CatResource> replaceDogById(@RequestBody Cat newCat, @PathVariable("id") Integer id) {
        if(!manager.replaceCatById(id, newCat)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new CatResource(newCat));
    }
}
