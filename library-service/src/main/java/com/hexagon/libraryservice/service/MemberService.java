package com.hexagon.libraryservice.service;

import com.hexagon.libraryservice.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member create(Member member);
    Optional<Member> getById(String id);
    List<Member> getAll();
    Member update(String id, Member member);
    void delete(String id);
}


