package org.example.oauth2.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;

    private String role = "USER";

    @Column(unique = true)
    private String email;

    private String provider; // google, naver, kakao 어떤 인증제공자인가?

    private LocalDateTime signedAt = LocalDateTime.now();

    @Builder
    public Member(String provider, String nickname, String name, String email) {
        this.provider = provider;
        this.nickname = nickname;
        this.name = name;
        this.email = email;
    }
}
