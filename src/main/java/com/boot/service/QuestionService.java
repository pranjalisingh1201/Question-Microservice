package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.dao.QuestionDao;
import com.boot.data.QuestionWrapper;
import com.boot.data.Questiontb;
import com.boot.data.Response;

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


	public ResponseEntity<List<Integer>> getQuestionsByCatAndNoOfQ(String category, int noOfQuestions) {
		// TODO Auto-generated method stub
		try {
		List<Integer> questions = questionDao.findRandomQuestionsByCategory(category,noOfQuestions);
		return new  ResponseEntity<>(questions,HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}


	public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> Id) {
		// TODO Auto-generated method stub
		try {
		List<QuestionWrapper> questionWrapper  = new ArrayList<>();
		List<Questiontb> question = new ArrayList<>();
		for(Integer id : Id)
		{
			question.add(questionDao.findById(id));
		}
		
		for(Questiontb q : question)
		{
			QuestionWrapper ques = new QuestionWrapper();
			ques.setId(q.getId());
			ques.setQuestionTitle(q.getQuestionTitle());
			ques.setOption1(q.getOption1());
			ques.setOption2(q.getOption2());
			ques.setOption3(q.getOption3());
			ques.setOption4(q.getOption4());
			questionWrapper.add(ques);
		}
		
		return new  ResponseEntity<>(questionWrapper,HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}


	public ResponseEntity<Integer> getScore(List<Response> responses) {
		// TODO Auto-generated method stub
		try {
		int result = 0;
		for(Response res : responses)
		{
			Questiontb question = questionDao.findById(res.getId());
			if(res.getResponse().equals(question.getRightAnswer()))result++;
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(Integer.MIN_VALUE,HttpStatus.BAD_REQUEST);

}
}
