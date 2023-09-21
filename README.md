# Question-Microservice
Quiz App Monolithic Application has been divided into 2 microservices - Question-Microservice and Quiz-Microservice

## Question Microservice
- Now we are creating two independent micro-services out of the quiz app.
- So Quiz service and Question service both will have their own independent databases.
- Now earlier quiz service needed access to the question database but now the quiz service cannot access the question service database hence we need to make a call to the question service to get the data from question database which is known as service to service call.
- Now to make these services independent we need to implement these 3 functions in question service.
- generate questions while creating the quiz
- Get questions while fetching the quiz
- get scores to get no of correct answers.
- ![screenshot](https://github.com/pranjalisingh1201/Question-Microservice/assets/75729195/2194067f-4377-4c82-a223-0a216c48c325)

