package com.example.springboot_template.dao;

import com.example.springboot_template.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Emp addEmp(Emp emp) {
        jdbcTemplate.execute("INSERT INTO x VALUES ('"+emp.getName()+"','"+emp.getAddress()+"')");
        return emp;
    }

    public List<Emp> empFetch() {
        return jdbcTemplate.query("SELECT * FROM x", (rs, i) -> {
            Emp e = new Emp();
            e.setName(rs.getString(1));
            e.setAddress(rs.getString(2));
            return e;
        });
    }


}
