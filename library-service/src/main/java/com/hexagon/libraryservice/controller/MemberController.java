package com.hexagon.libraryservice.controller;

import com.hexagon.libraryservice.model.Member;
import com.hexagon.libraryservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> create(@RequestBody Member member) {
        Member created = memberService.create(member);
        return ResponseEntity.created(URI.create("/api/v1/members/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable String id) {
        return memberService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(memberService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable String id, @RequestBody Member member) {
        Member updated = memberService.update(id, member);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }
}


