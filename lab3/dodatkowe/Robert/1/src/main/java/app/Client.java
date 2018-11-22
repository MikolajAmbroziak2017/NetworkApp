package app;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Client
{
    public static void main(String[] args)
    {
    /*
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> exchange = restTemplate.exchange(
                "http://localhost:9090/getItemSize", HttpMethod.GET, HttpEntity.EMPTY, Integer.class);
        Integer body = exchange.getBody();
        System.out.println(body);



        RestTemplate restTemplate123 = new RestTemplate();
        ResponseEntity<List<Item>> exchange123 = restTemplate123.exchange(
                "http://localhost:9090/getItemList", HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Item>>() {
                });
        List<Item> body123 = exchange123.getBody();
        for (Item item : body123) {
            System.out.println(item.getName() + " " + item.getPrice() * 1.23);
        }
*/
        /*
        RestTemplate restTemplate123 = new RestTemplate();
        String jsonToSend = " {\n" +
                "        \"price\": 50,\n" +
                "        \"name\": \"MobilePhone\"\n" +
                "    }";

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_TYPE, "application.json");
        HttpEntity<String> stringHttpEntity = new HttpEntity<String>(jsonToSend,header);

        ResponseEntity<Boolean> exchange1234 = restTemplate123.exchange(
                "http://localhost:9090/addItem", HttpMethod.POST, stringHttpEntity,
                Boolean.class);

        Boolean bodyB = exchange1234.getBody();
        System.out.println(bodyB);
        */

        //******************************************** Zadanie na Laby 6 ********************************************
        RestTemplate restTemplate123 = new RestTemplate();
        ResponseEntity<List<Dana>> exchange123 = restTemplate123.exchange(
                "https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Dana>>() {
                });
        List<Dana> body123 = exchange123.getBody();
        for (Dana item : body123) {
            System.out.println(item.getUserId() + " " + item.getId() + " " + item.getTitle() + " " + item.getBody() + "!");
        }

        //******************************************** Zadanie na Laby 6 ********************************************
    }
}
