package com.example.demo.member.domain;

import com.example.demo.hobby.domain.dto.HobbyDto;
import com.example.demo.join.domain.entitiy.MemberHobby;
import com.example.demo.member.domain.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

public record MemberResponse(Long id, String name, Integer age, List<HobbyDto> hobby) {
    public static MemberResponse from(Member member){
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMemberHobbies()
                        .stream()
                        .map(MemberHobby::getHobby)
                        .map(HobbyDto::from)
                        .collect(Collectors.toList()));
    }
}
