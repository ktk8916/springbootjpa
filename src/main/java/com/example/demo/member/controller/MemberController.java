package com.example.demo.member.controller;

import com.example.demo.member.domain.MemberResponse;
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
    public List<MemberResponse> searchMember(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        return memberService.searchMember(name, page);
    }

    @GetMapping("/{id}")
    public MemberResponse findById(@PathVariable("id") Long id){
        return MemberResponse.from(memberService.findById(id));
    }

    @PostMapping
    public void insert(@RequestBody MemberRequest memberRequest){
        memberService.insert(memberRequest);
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
