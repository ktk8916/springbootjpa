package com.example.demo.hobby.repository;

import com.example.demo.hobby.domain.entity.Hobby;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository {
    List<Hobby> findAll();
    Hobby findById(Long id);
    List<Hobby> findByLikeName(String name);
    void save(Hobby hobby);
    void delete(Hobby hobby);

}
