import app.Mammal;
import app.MammalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class MammalApi {

    @Autowired
    private PetManager manager;

    @DeleteMapping("/mammals/{id}")
    public ResponseEntity<Void> deleteMammalById(@PathVariable("id") Integer id) {
        if(manager.deleteMammalById(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/mammals", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resources<MammalResource>> getAllMammals() {
        Resources<MammalResource> resources = new Resources<>(
                manager.getMammals()
                        .stream()
                        .map(MammalResource::new)
                        .collect(Collectors.toList()));

        // Zwracamy odnośnik do kolekcji wszystkich psów
        resources.add(linkTo(methodOn(MammalApi.class)
                .getAllMammals())
                .withSelfRel());

        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/mammals/{id}", method = RequestMethod.GET)
    public ResponseEntity<MammalResource> getMammalById(@PathVariable("id") Integer id) {
        Mammal resultMammal = manager.getMammalById(id);

        if(resultMammal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new MammalResource(resultMammal));
    }
}
