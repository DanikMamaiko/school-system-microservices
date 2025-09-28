package com.hexagon.libraryservice.repository;

import com.hexagon.libraryservice.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}


