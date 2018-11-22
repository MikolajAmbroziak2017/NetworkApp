package app;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@RestController

public class Client {
    public static void main(String[] args){
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Integer> exchange= restTemplate.exchange(
                "http://localhost:9090/getItemSize",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Integer.class
        );

        Integer body =exchange.getBody();
        System.out.println(body);

        RestTemplate restTemplate2=new RestTemplate();
        ResponseEntity<List<Item>> exchange2 =restTemplate2.exchange(
                "http://localhost:9090/getItemList",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Item>>(){});


                List<Item> body2 = exchange2.getBody();
                for(Item item:body2){
                    System.out.println(item.getName()+" "+item.getPrice()*1.23);
                }



        RestTemplate restTemplate3=new RestTemplate();
        ResponseEntity<Float> exchange3=restTemplate3.exchange(
                "http://localhost:9090/getItem",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Float.class
        );

    }
    private static void addElement(){
        RestTemplate restTemplate=new RestTemplate();
        String jsonToSent="{\n"+"\"price\":666,\n"+"\"name\":\"totem\"\n"+"}";
        HttpHeaders headers=new HttpHeaders();
        headers.add(HttpHeaders.);

    }

}
