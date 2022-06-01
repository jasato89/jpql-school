package com.ironhack.school.repository;

import com.ironhack.school.model.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {


    public Grade findById(int id);
    public List<Grade> findAllByStudentNameContains(String contain);

    @Query(value = "SELECT sectionId, AVG(score) from Grade " +
            "GROUP BY sectionId ORDER BY AVG(score) ASC")
    public List<Object[]> findAverageScoreBySection();

    /*

    Section | AVERAGE SCORE
    [
    [Section 1, 9.5],
    [Section 2, 7.5],
    [Section 2 , 7.5]
    ]
    */






}
