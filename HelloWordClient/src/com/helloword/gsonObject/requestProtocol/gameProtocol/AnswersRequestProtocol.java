package com.helloword.gsonObject.requestProtocol.gameProtocol;

import java.util.List;

import com.helloword.gsonObject.UserAnswer;

public class AnswersRequestProtocol extends GlobalGameRequestProtocol {

    List<UserAnswer> userAnswer;
    
    public List<UserAnswer> getUserAnswer() {
        return userAnswer;
    }
    public void setUserAnswer(List<UserAnswer> userAnswer) {
        this.userAnswer = userAnswer;
    }
}
