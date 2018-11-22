package app;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class CatResource extends ResourceSupport {

    private Cat cat;

    public CatResource(Cat cat,int id) {
        this.cat = cat;


        // Dodajemy odnośniki do tego psa oraz do wszystkich
        add(linkTo(methodOn(CatApi.class)
                .getCatById(id))
                .withSelfRel());
        // Dodajemy odnośniki do tego psa oraz do wszystkich
        add(linkTo(methodOn(CatApi.class)
                .getCatById(id+1))
                .withRel("Next Cat"));

    }
}