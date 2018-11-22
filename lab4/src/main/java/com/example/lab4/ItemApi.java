package com.example.lab4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemApi {
   private List<Item> itemList;



    public ItemApi() {
        itemList=new ArrayList<>();
        itemList.add(new Item(30,"TV"));
        itemList.add(new Item(50,"Mobilephone"));
        itemList.add(new Item(100,"Laptop"));
        itemList.add(new Item(10,"Keyboard"));
        itemList.add(new Item(20,"Motherboard"));
    }
    @GetMapping("/getItemList")
    public List<Item> getItemList(@RequestParam Integer maxSize) {
        if(maxSize==null)
            return itemList;
        return itemList.subList(0,maxSize);
    }
    @PostMapping("/addItem")
    public boolean addItem(@RequestBody Item item){
        return itemList.add(item);
    }

    @GetMapping("/getItemSize")
    public int getItemSize(){
        return itemList.size();
    }

}

