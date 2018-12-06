package com.example.demo.app;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Service;

@Service
public class DatabaseMenager {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void createDB(){
        String sqlCreate = "Create table client(id_c int, name varchar(255),surname varchar(255), City varchar(255));";
        jdbcTemplate.execute(sqlCreate);
    }
}
