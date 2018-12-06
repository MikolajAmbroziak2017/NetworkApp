package app;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class MammalResource extends ResourceSupport {
    private Mammal mammal;

    public MammalResource(Mammal mammal) {
        this.mammal = mammal;
        int id = mammal.getId();

        // Dodajemy odnośniki do tego psa oraz do wszystkich
        add(linkTo(methodOn(MammalApi.class)
                .getMammalById(id))
                .withSelfRel());
        add(linkTo(methodOn(MammalApi.class)
                .getAllMammals())
                .withRel("all"));
    }
}
