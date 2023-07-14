package com.example.demo.join.controller;

import com.example.demo.join.domain.request.JoinRequest;
import com.example.demo.join.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/join")
public class JoinController {

    private final JoinService joinService;

    @PostMapping
    public void joinMemberHobby(@RequestBody JoinRequest joinRequest){
        joinService.joinMemberHobby(joinRequest);
    }
}
