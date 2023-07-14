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
public class JoinService {

    private final EntityManager em;

    public void joinMemberHobby(JoinRequest joinRequest) {
        MemberHobby join = MemberHobby.createJoin(
                joinRequest.memberId(),
                joinRequest.hobbyId());
        em.persist(join);
    }
}
