package com.example.demo.member.controller;

import com.example.demo.member.domain.MemberResponse;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public List<MemberResponse> searchMember(@RequestParam(value = "name", required = false) String name) {
        return memberService.searchMember(name);
    }

    @GetMapping("/{id}")
    public MemberResponse findById(@PathVariable("id") Long id){
        return MemberResponse.from(memberService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody MemberRequest memberRequest){
        memberService.save(memberRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody MemberRequest memberRequest){
        memberService.update(id, memberRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }
}
