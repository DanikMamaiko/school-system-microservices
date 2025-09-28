package com.hexagon.libraryservice.service.impl;

import com.hexagon.libraryservice.model.Member;
import com.hexagon.libraryservice.repository.MemberRepository;
import com.hexagon.libraryservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member create(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> getById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member update(String id, Member member) {
        Member existing = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Member not found: " + id));
        existing.setFullName(member.getFullName());
        existing.setEmail(member.getEmail());
        existing.setPhone(member.getPhone());
        return memberRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        memberRepository.deleteById(id);
    }
}


