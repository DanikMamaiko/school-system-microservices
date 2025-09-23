package com.hexagon.studentservice.dao.repository;

import com.hexagon.studentservice.dao.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
