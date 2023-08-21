package com.codestates.StackOverFlowClone.member.repository;

import com.codestates.StackOverFlowClone.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    @Query("SELECT m.memberId FROM Member m WHERE m.email = :email")
    Long findMemberIdByEmail(String email);
}
