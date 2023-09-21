package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.dao.QuestionDao;
import com.boot.data.Questiontb;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Questiontb>> getAllQuestions()
	{
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);//ResponseEntity is used to send response in the form of entity.
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	

	public ResponseEntity<List<Questiontb>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);//ResponseEntity is used to send response in the form of entity.
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Questiontb question) {
		// TODO Auto-generated method stub
		try {
			questionDao.save(question);
			return new ResponseEntity<>("success",HttpStatus.CREATED);//ResponseEntity is used to send response in the form of entity.
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
	}

}
