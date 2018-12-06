package com.example.demo;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class SuperHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    private int age;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Skill skill;

    public SuperHero() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skill=" + skill +
                '}';
    }
}
