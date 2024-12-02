package org.example.oauth2.DAO;

import org.example.oauth2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoty extends JpaRepository<Member, Integer> {




}
