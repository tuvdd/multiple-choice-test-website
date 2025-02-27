package com.project.exam_prep.repo;

import com.project.exam_prep.dto.QuestionSetDto;
import com.project.exam_prep.dto.SimpleQuestionSetDto;
import com.project.exam_prep.entity.QuestionSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionSetRepo extends JpaRepository<QuestionSet, Integer> {
    @Query("select new com.project.exam_prep.dto.QuestionSetDto(entity) from QuestionSet as entity")
    List<QuestionSetDto> getAllQuestionSet();
    @Query("select new com.project.exam_prep.dto.SimpleQuestionSetDto(entity) from QuestionSet entity where entity.teacher.id = ?1")
    List<SimpleQuestionSetDto> getAllQuestionSetByTeacherId(Integer teacherId);

//    @Query("select new com.project.exam_prep.dto.QuestionSetDto(entity) from QuestionSet entity where entity.id = ?1")
//    Optional<QuestionSetDto> getQuestionSetById(Integer id);
}
