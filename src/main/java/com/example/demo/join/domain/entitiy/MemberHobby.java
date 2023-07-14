package com.example.demo.join.domain.entitiy;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemberHobby {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    public static MemberHobby createJoin(Long memberId, Long hobbyId){
        MemberHobby memberHobby = new MemberHobby();
        memberHobby.member = Member.builder()
                .id(memberId)
                .build();
        memberHobby.hobby = Hobby.builder()
                .id(hobbyId)
                .build();
        return memberHobby;
    }
}
