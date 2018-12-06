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
    public ResponseEntity<Resources<MammalResource>> getAllCats() {
        Resources<MammalResource> resources = new Resources<>(
                manager.getAllCats()
                        .stream()
                        .map(MammalResource::new)
                        .collect(Collectors.toList()));

        // Zwracamy odnośnik do kolekcji wszystkich psów
        resources.add(linkTo(methodOn(CatApi.class)
                .getAllCats())
                .withSelfRel());

        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/cats/{id}", method = RequestMethod.GET)
    public ResponseEntity<MammalResource> getCatById(@PathVariable("id") Integer id) {
        Cat resultCat = manager.getCatById(id);

        if(resultCat == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new MammalResource(resultCat));
    }

    @RequestMapping(value = "/cats/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<MammalResource> updateCatById(@PathVariable("id") Integer id,
                                                        @RequestParam Map<String, String> paramsToUpdate) {
        Cat catToUpdate = manager.getCatById(id);

        if(catToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        catToUpdate.update(paramsToUpdate);

        return ResponseEntity.ok().body(new MammalResource(catToUpdate));
    }

    @RequestMapping(value = "/cats", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MammalResource addCat(@RequestBody Cat newCat) {
        // TODO sprawdzić czy istnieje już zwierzak o tym identyfikatorze
        manager.getMammals().add(newCat);

        return new MammalResource(newCat);
    }

    @RequestMapping(value = "/cats/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MammalResource> replaceCatById(@RequestBody Cat newCat,
                                                         @PathVariable("id") Integer id) {
        if(!manager.replaceCatById(id, newCat)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new MammalResource(newCat));
    }
}
