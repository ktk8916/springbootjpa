package com.example.demo.member.repository;

import com.example.demo.member.domain.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByNameContaining(String name);
    @Query("select m from Member m left join fetch m.memberHobbies mh left join fetch mh.hobby")
    List<Member> findAllFetch(Pageable pageable);
    @Query("select m from Member m left join fetch m.memberHobbies mh left join fetch mh.hobby where m.name like :name")
    List<Member> findAllFetchByNameContaining(@Param("name") String name, Pageable pageable);
}
