package com.quiz.MiniQuiz;
public class QuizPOJO{
private int id;
private String questionText;
private String optionA;
private String optionB;
private String optionC;
private String optionD;
private char correctOption;
private String topic;

public QuizPOJO(int id,String questionText,String optionA,String optionB,String optionC,String optionD,char correctOption,String topic){
this.id=id;
this.questionText=questionText;
this.optionA=optionA;
this.optionB=optionB;
this.optionC=optionC;
this.optionD=optionD;
this.correctOption=correctOption;
this.topic=topic;
}

public int getId(){
return id;
}

public String getQuestionText(){
return questionText;
}

public String getOptionA(){
return optionA;
}

public String getOptionB(){
return optionB;
}

public String getOptionC(){
return optionC;
}

public String getOptionD(){
return optionD;
}

public String getTopic(){
return topic;
}

public char getCorrectOption(){
return correctOption;
}
}