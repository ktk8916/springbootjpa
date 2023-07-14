package com.example.demo.member.service;

import com.example.demo.member.domain.MemberResponse;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final EntityManager em;

    public List<MemberResponse> findByLikeName(String name){
        return em.createQuery("select m from Member m join fetch m.memberHobbies mh join fetch mh.hobby where m.name like :name", Member.class)
                .setParameter("name", "%" + name + "%")
                .getResultStream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }
    public Member findById(Long id){
        Member member = em.find(Member.class, id);
        if(member==null){
            throw new NullPointerException("나중에 커스텀하자");
        }
        return member;
    }

    public void save(MemberRequest memberRequest){
        em.persist(memberRequest.toEntity());
    }

    public void delete(Long id){
        Member member = findById(id);
        em.remove(member);
    }

    public void update(Long id, MemberRequest memberRequest) {
        Member member = findById(id);
        member.update(
                memberRequest.name(),
                memberRequest.age());
    }

    public List<MemberResponse> findAll() {
        return em.createQuery("select m from Member m join fetch m.memberHobbies mh join fetch mh.hobby", Member.class)
                .getResultStream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }

    public List<MemberResponse> searchMember(String name) {
        if(name==null){
            return findAll();
        } else {
            return findByLikeName(name);
        }
    }
}
