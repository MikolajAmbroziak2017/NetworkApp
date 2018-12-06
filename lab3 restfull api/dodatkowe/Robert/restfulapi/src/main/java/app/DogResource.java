package app;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class DogResource extends ResourceSupport {

    private Dog dog;

    public DogResource(Dog dog) {
        this.dog = dog;
        int id = dog.getId();

        // Dodajemy odnośniki do tego psa oraz do wszystkich
        add(linkTo(methodOn(DogApi.class)
                .getDogById(id))
                .withSelfRel());
        add(linkTo(methodOn(DogApi.class)
                .getAllDogs())
                .withRel("allDogs"));
    }
}
