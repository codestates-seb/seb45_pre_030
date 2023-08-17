package com.codestates.StackOverFlowClone.member.service;

import com.codestates.StackOverFlowClone.auth.utils.CustomAuthorityUtils;
import com.codestates.StackOverFlowClone.member.entity.Member;
import com.codestates.StackOverFlowClone.member.repository.MemberRepository;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final CustomAuthorityUtils authorityUtils;
    private final PasswordEncoder passwordEncoder;
    private final CustomBeanUtils<Member> beanUtils;

    public MemberService(MemberRepository memberRepository,
                         CustomAuthorityUtils authorityUtils,
                         PasswordEncoder passwordEncoder,
                         CustomBeanUtils<Member> beanUtils) {
        this.memberRepository = memberRepository;
        this.authorityUtils = authorityUtils;
        this.passwordEncoder = passwordEncoder;
        this.beanUtils = beanUtils;
    }

    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());

        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        Member savedMember = memberRepository.save(member);

        return savedMember;
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());

        Member updatedMember =
                beanUtils.copyNonNullProperties(member, findMember);

        return memberRepository.save(updatedMember);
    }


    public Member findMember(long memberId) {
        return findVerifiedMember(memberId);
    }

    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("memberId").descending()));
    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember);
    }

    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new RuntimeException());
        return findMember;
    }

    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent())
            throw new RuntimeException();
    }
}
