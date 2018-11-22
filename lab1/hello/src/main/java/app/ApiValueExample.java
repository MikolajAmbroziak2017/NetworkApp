package app;

import org.springframework.web.bind.annotation.*;

@RestController ("/apiii")
public class ApiValueExample {

@GetMapping //obsluga zapytania by Header
    public String byHeader(@RequestHeader(value = "myName", required = false) String name) {
        return "Hello" + name;

    }

//
//    @PostMapping //obsługa by Parametr request
//    //@RequestMapping(method=RequestMethod.POST) rownoznaczne z @PostMapping
//    public String byParam(@RequestParam(value = "myAge", required = false) int age) {
//        return "You have " + age;
//
//    }

    @RequestMapping(method=RequestMethod.PUT, value="/getHeight/{myHeight}/{numer2}")// rownoznaczne z @PostMapping
    public String byVariable(@PathVariable("myHeight") Long height,@PathVariable("numer2") Long numer2) {
        return "You have " + (height+numer2);

    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! KOlejna cześc inne zadanie razem z klasą bso

    @RequestMapping("/sendValue")
    public String byBody(@RequestBody BSO bso) {
        return bso.toString()+"przesłane przez api";

    }
}