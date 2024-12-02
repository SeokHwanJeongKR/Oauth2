package org.example.oauth2.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.oauth2.DAO.MemberRepositoty;
import org.example.oauth2.domain.Member;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberService extends DefaultOAuth2UserService {

    private final MemberRepositoty memberRepositoty;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        
        log.info("oAuth2User: {}", oAuth2User);

        Member member = Member.builder()
                .name("USER1")
                .email("USER1@gmail.com")
                .nickname("USER1")
                .build();

        return oAuth2User;
    }
}
