package com.example.demo.member.service;

import com.example.demo.member.domain.MemberResponse;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import com.example.demo.member.exception.MemberNotFoundException;
import com.example.demo.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findById(Long id){
        Optional<Member> member = memberRepository.findById(id);
        return member.orElseThrow(()->new MemberNotFoundException("Not Found Member By " + id));
    }

    public void insert(MemberRequest memberRequest){
        memberRepository.save(memberRequest.toEntity());
    }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }

    public void update(Long id, MemberRequest memberRequest) {
        Member member = findById(id);
        member.update(
                memberRequest.name(),
                memberRequest.age());
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<MemberResponse> searchMember(String name, Integer page) {
        final int PAGE_SIZE = 3;

        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        List<Member> members = memberRepository.findAllFetchByNameContaining("%"+name+"%", pageable);

        return members
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }
}
