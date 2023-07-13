package com.example.demo.hobby.repository;

import com.example.demo.hobby.domain.entity.Hobby;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HobbyEmRepository implements HobbyRepository{

    private final EntityManager em;

    @Override
    public List<Hobby> findAll() {
        return em
                .createQuery("select h from Hobby h join fetch h.connects c join fetch c.member", Hobby.class)
                .getResultList();
    }

    @Override
    public Hobby findById(Long id) {
        return em.find(Hobby.class, id);
    }

    @Override
    public List<Hobby> findByLikeName(String name) {
        return em
                .createQuery("select h from Hobby h join fetch h.connects c join fetch c.member where h.name like :name", Hobby.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public void save(Hobby hobby) {
        em.persist(hobby);
    }

    @Override
    public void delete(Hobby hobby) {
        em.remove(hobby);
    }
}
