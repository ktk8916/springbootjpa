package com.example.demo.join.repository;

import com.example.demo.join.domain.entitiy.MemberHobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinRepository extends JpaRepository<MemberHobby, Long> {
}
