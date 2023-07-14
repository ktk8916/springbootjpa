package com.example.demo.hobby.domain.dto;

import com.example.demo.hobby.domain.entity.Hobby;

public record HobbyDto(Long id, String name){
    public static HobbyDto from(Hobby hobby){
        return new HobbyDto(hobby.getId(), hobby.getName());
    }
}