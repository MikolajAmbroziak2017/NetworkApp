package app;


import org.springframework.web.bind.annotation.*;

@RestController
public class ApiValueExample
{
    /*
    @GetMapping
    public String byHeader(@RequestHeader(value = "myName", required = false) String name) {
        return "Hello " + name;
    }
*/
    @PostMapping
    public String byParam(@RequestParam(value = "myage", required = false) Long age){
        return "You have " + age;
    }

    @RequestMapping("/getExamplePathVariable/{number}")
    public String byVariable(@PathVariable("number") long number)
    {
        return "You have " + number;
    }

    @PostMapping("/sendValue")
    public String byParam(@RequestBody BSO bso)
    {
        return bso.toString();
    }
}