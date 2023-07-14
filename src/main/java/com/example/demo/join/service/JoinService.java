package com.example.demo.join.service;

import com.example.demo.join.domain.request.JoinRequest;
import com.example.demo.join.domain.entitiy.MemberHobby;
import com.example.demo.join.repository.JoinRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinService {

    private final JoinRepository joinRepository;

    public void joinMemberHobby(JoinRequest joinRequest) {
        MemberHobby join = MemberHobby.createJoin(
                joinRequest.memberId(),
                joinRequest.hobbyId());
        joinRepository.save(join);
    }
}
