package com.example.demo.hobby.domain.entity;

import com.example.demo.join.MemberHobby;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Hobby {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "hobby")
    private List<MemberHobby> memberHobbies = new ArrayList<>();
}
