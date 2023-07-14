package com.example.demo.hobby.repository;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {

    @Query("select h from Hobby h left join fetch h.memberHobbies mh left join fetch mh.member")
    List<Hobby> findAllFetch(Pageable pageable);
    @Query("select h from Hobby h left join fetch h.memberHobbies mh left join fetch mh.member where h.name like :name")
    List<Hobby> findAllFetchByNameContaining(@Param("name") String name, Pageable pageable);
}
