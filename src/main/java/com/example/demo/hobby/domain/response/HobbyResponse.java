package com.example.demo.hobby.domain.response;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.join.domain.entitiy.MemberHobby;
import com.example.demo.member.domain.dto.MemberDto;

import java.util.List;
import java.util.stream.Collectors;

public record HobbyResponse(Long id, String name, List<MemberDto> member) {
    public static HobbyResponse from(Hobby hobby){
        return new HobbyResponse(
                hobby.getId(),
                hobby.getName(),
                hobby.getMemberHobbies()
                        .stream()
                        .map(MemberHobby::getMember)
                        .map(MemberDto::from)
                        .collect(Collectors.toList()));
    }
}

