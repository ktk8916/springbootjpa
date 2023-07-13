package com.example.demo.join;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.hobby.service.HobbyService;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ConnectService {

    private final EntityManager em;
    private final MemberService memberService;
    private final HobbyService hobbyService;

    public void connectMemberHobby(ConnectRequest connectRequest) {
        Member member = memberService.findById(connectRequest.memberId());
        Hobby hobby = hobbyService.findById(connectRequest.hobbyId());

        Connect connect = Connect.createConnect(member, hobby);
        em.persist(connect);
    }
}
