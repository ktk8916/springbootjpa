package com.example.demo.member.domain.entity;

import com.example.demo.join.MemberHobby;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "member")
    private List<MemberHobby> memberHobbies = new ArrayList<>();

    public void update(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
