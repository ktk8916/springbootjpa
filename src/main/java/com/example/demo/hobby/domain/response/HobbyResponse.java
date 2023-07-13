package com.example.demo.hobby.domain.response;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.join.Connect;
import com.example.demo.member.domain.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

public record HobbyResponse(Long id, String name, List<MemberDto> member) {
    public static HobbyResponse from(Hobby hobby){
        return new HobbyResponse(
                hobby.getId(),
                hobby.getName(),
                hobby.getConnects()
                        .stream()
                        .map(Connect::getMember)
                        .map(MemberDto::from)
                        .collect(Collectors.toList()));
    }
    public record MemberDto(Long id, String name, Integer age){
        public static MemberDto from(Member member){
            return new MemberDto(member.getId(), member.getName(), member.getAge());
        }
    }
}

