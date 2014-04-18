package com.helloword.gsonObject.game;

import java.util.List;

import com.helloword.gsonObject.UserAnswer;

public class AnswersRequest extends GlobalGameRequest {

    List<UserAnswer> userAnswer;
    
    public List<UserAnswer> getUserAnswer() {
        return userAnswer;
    }
    public void setUserAnswer(List<UserAnswer> userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    
}
