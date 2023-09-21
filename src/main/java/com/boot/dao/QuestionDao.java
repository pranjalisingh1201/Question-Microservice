package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boot.data.Questiontb;

@Repository
public interface QuestionDao extends JpaRepository<Questiontb, Integer> {

	List<Questiontb> findByCategory(String category);

	@Query(value="SELECT * FROM QUESTIONTB WHERE CATEGORY=:category ORDER BY RAND() LIMIT :noOfQuestions",nativeQuery=true)
	List<Questiontb> findRandomQuestionsByCategory(@Param("category") String category,@Param("noOfQuestions") int noOfQuestions);

}
