package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperHeroRepo extends CrudRepository<SuperHero,Long> {
    SuperHero findByName(String name);

    @Query(value="SELECT * FROM SUPER_HERO as s WHERE s.id > :id", nativeQuery = true)
    default List<SuperHero> getAllWhenIdIsMoreThan(@Param("id") Long id) {
        return null;
    }
}
