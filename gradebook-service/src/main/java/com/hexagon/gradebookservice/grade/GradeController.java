package com.hexagon.gradebookservice.grade;

import com.hexagon.gradebookservice.dal.entity.Grade;
import com.hexagon.gradebookservice.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/grade")
public class GradeController {

    private final GradeService gradeService;

    @QueryMapping
    public Grade gradeById(@Argument Long id) {
        return gradeService.getGradeById(id).orElse(null);
    }

    @MutationMapping
    public Grade saveGrade(@Argument String studentName, @Argument String subject, @Argument Integer score) {
        Grade grade = new Grade();
        grade.setStudentName(studentName);
        grade.setSubject(subject);
        grade.setScore(score);
        return gradeService.saveGrade(grade);
    }
}