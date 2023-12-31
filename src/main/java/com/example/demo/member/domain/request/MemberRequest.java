package com.example.demo.member.domain.request;

import com.example.demo.member.domain.entity.Member;

public record MemberRequest(String name, Integer age) {
    public Member toEntity(){
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }
}
