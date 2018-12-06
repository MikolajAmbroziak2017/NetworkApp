package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@RestController
public class CatApi {

    private PetMenager petmenager;

    @Autowired // wstrzykiwanie poprzez właściwość
    public void setPetmenager(PetMenager petmenager) {
        this.petmenager = petmenager;
    }
    //wyswietlanie wszystkich psów
    @GetMapping("/cat")
    public ResponseEntity<List<Cat>> getCat() { //pzzekazujemy liste do clienta
        ResponseEntity <List<Cat>> listResponseEntity = new ResponseEntity<List<Cat>>(petmenager.getCatList(), HttpStatus.OK); // obsługa błędu serweru
        return listResponseEntity;
    }
    @PatchMapping("/cat/{id}/{new_name}")
    public ResponseEntity<Void> patchCat(@PathVariable("id") Integer id,@PathVariable("new_name") String name){

        if(petmenager.PatchCat(id,name))
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/cat/{name}/{paw}/{sex}/{race}")
    public String addNewCat(@PathVariable("name")String name, @PathVariable("paw") String numberOfPaw, @PathVariable("sex") String sex, @PathVariable("race") String race){

        return petmenager.addCat(name,numberOfPaw,sex,race);
    }
    @PutMapping("/cat/{id}/{name}/{paw}/{sex}/{race}")
    public String updateCat(@PathVariable("id") Integer id,@PathVariable("name")String name,@PathVariable("paw") String numberOfPaw,@PathVariable("sex") String sex,@PathVariable("race") String race){

        return petmenager.updateCat(id,name,numberOfPaw,sex,race);
    }
    @RequestMapping(method = RequestMethod.GET,value ="/cat/{cat_id}")
    public CatResource  getCatById (@PathVariable("cat_id") Integer id) {
        if (id>petmenager.getCatList().size())
            return null;
        return new CatResource(petmenager.getCatById(id),id);
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
    headers.put("kotki w piwnicy", Collections.singletonList(petmenager.getCatList().toString()));

    HttpEntity<String> responseEntity = new HttpEntity<String>("test body", headers);
    return responseEntity;
}

    //OPTIONS cat
    @RequestMapping(value = "/cat", method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS");
        return new ResponseEntity(HttpStatus.OK);
    }

}
