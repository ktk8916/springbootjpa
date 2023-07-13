package com.example.demo.join;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Connect {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    public static Connect createConnect(Member member, Hobby hobby){
        Connect connect = new Connect();
        connect.member = member;
        connect.hobby = hobby;
        member.getConnects().add(connect);
        hobby.getConnects().add(connect);
        return connect;
    }
}
