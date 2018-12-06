package com.example.demo;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;
import static com.example.demo.Skill.BAR;
import static com.example.demo.Skill.FIRE_BALL;
import static com.example.demo.Skill.INVISABLE;

@RestController
public class SuperHeroApi {
    @Autowired
    private SuperHeroRepo superHeroRepo;

    @GetMapping("/create")
    public void create(){
        SuperHero superHero= new SuperHero();
        superHero.setSkill(INVISABLE);
        superHero.setName("Pawełek");
        superHero.setAge(12);
        superHeroRepo.save(superHero);

        SuperHero superHero2= new SuperHero();
        superHero2.setSkill(FIRE_BALL);
        superHero2.setName("Kasia");
        superHero2.setAge(11);
        superHeroRepo.save(superHero2);

        SuperHero superHero1= new SuperHero();
        superHero1.setSkill(BAR);
        superHero1.setName("Paweł");
        superHero1.setAge(13);
        superHeroRepo.save(superHero1);
    }

    @GetMapping("/getHero")
    public SuperHero getHero(){
       Optional<SuperHero> byId= superHeroRepo.findById(1L);
       return byId.get();
}
    @GetMapping("/getHeroByName/{name}")
    public SuperHero getHeroByName(@RequestParam String name){
       return superHeroRepo.findByName(name);

    }
    @GetMapping("/getHeroByName/{id}")
    public List<SuperHero> wieksze(@RequestParam Long id){
        return superHeroRepo.getAllWhenIdIsMoreThan(id);

    }
}
