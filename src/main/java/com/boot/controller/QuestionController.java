package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.data.QuestionWrapper;
import com.boot.data.Questiontb;
import com.boot.data.Response;
import com.boot.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
//	@GetMapping("allQuestions")
//	public List<Questiontb> getAllQuestions()
//	{
//		return questionservice.getAllQuestions();
//	}
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Questiontb>> getAllQuestions()
	{
		return questionservice.getAllQuestions();
	}
	
	@GetMapping("category/{category}")//if variable name and mapped url does not matches then use @PathVariable("cat")
	public ResponseEntity<List<Questiontb>> getQuestionsByCategory(@PathVariable String category)
	{
		return questionservice.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestions(@RequestBody Questiontb question)
	{
		return questionservice.addQuestion(question);
	}
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestions(@RequestParam String category, @RequestParam int noOfQuestions)
	{
		return questionservice.getQuestionsByCatAndNoOfQ(category,noOfQuestions);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> Id)
	{
		return questionservice.getQuestionsById(Id);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	{
		return questionservice.getScore(responses);
	}

}
