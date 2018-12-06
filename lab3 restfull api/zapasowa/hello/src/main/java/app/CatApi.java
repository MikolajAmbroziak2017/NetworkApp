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
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CatApi {

    private PetMenager petmenager;

    @Autowired // wstrzykiwanie poprzez właściwość
    public void setPetmenager(PetMenager petmenager) {
        this.petmenager = petmenager;
    }
    //wyswietlanie wszystkich psów

    @RequestMapping(value="/cat",method = RequestMethod.GET)

        public ResponseEntity<Resources<CatResource>> getCat() {
            Resources<CatResource> resources = new Resources<>(
                    petmenager.getCatList()
                            .stream()
                            .map(CatResource::new)
                            .collect(Collectors.toList()));

            // Zwracamy odnośnik do kolekcji wszystkich psów
            resources.add(linkTo(methodOn(CatApi.class)
                    .getCat())
                    .withSelfRel());

            return ResponseEntity.ok(resources);
        }
    @PatchMapping("/cat/{id}/{new_name}")
    public ResponseEntity<Void> patchCat(@PathVariable("id") Integer id,@PathVariable("new_name") String name){
        if(petmenager.patchCat(id,name))
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/cat/{name}/{paw}/{sex}/{favFood}/{id}")
    public ResponseEntity< Void> addNewCat(@PathVariable("name")String name, @PathVariable("paw") String numberOfPaw, @PathVariable("sex") String sex, @PathVariable("favFood") String favFood, @PathVariable("id") Integer id){

        if(petmenager.addCat(name,numberOfPaw,sex,favFood,id))
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/cat/{id}/{name}/{paw}/{sex}/{favFood}")
    public boolean updateCat(@PathVariable("id") Integer id,@PathVariable("name")String name,@PathVariable("paw") String numberOfPaw,@PathVariable("sex") String sex,@PathVariable("favFood") String favFood){
Cat newCat=new Cat(name,numberOfPaw,sex,favFood,id);
        return petmenager.updateCat(id,newCat);
    }

    @RequestMapping(method = RequestMethod.GET,value ="/cat/{id}")
    public ResponseEntity<CatResource> getCatById(@PathVariable("id") Integer id) {
        Cat resultCat = petmenager.getCatById(id);

        if(resultCat == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new CatResource(resultCat));
    }
    @RequestMapping(method = RequestMethod.DELETE,value ="/cat/{cat_id}")
    public ResponseEntity<Void> delCatById (@PathVariable("cat_id") Integer id) {
        if (petmenager.delCat(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }




//metoda head
//head cat
@RequestMapping(value = "/cat", method = RequestMethod.HEAD)
public HttpEntity<String> headCat()
{
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.put("wszystkie kotki", Collections.singletonList(petmenager.getCatList().toString()));

    HttpEntity<String> responseEntity = new HttpEntity<String>("test body", headers);
    return responseEntity;
}

    //OPTIONS cat
    @RequestMapping(value = "/cat", method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,DELETE,OPTIONS");
        return new ResponseEntity(HttpStatus.OK);
    }

}
