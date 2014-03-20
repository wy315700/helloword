package com.helloword.gsonObject.requestProtocol.gameProtocol;

import java.util.List;

public class AnswersRequestProtocol extends GlobalGameRequestProtocol {

    List<UserAnswer> userAnswer;
    
    public List<UserAnswer> getUserAnswer() {
        return userAnswer;
    }
    public void setUserAnswer(List<UserAnswer> userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    public static class UserAnswer {
        
        String chosen = null;
        String time = null;
        
        public String getChosen() {
            return chosen;
        }
        public void setChosen(String string) {
            this.chosen = string;
        }
        
        public String getTime() {
            return time;
        }
        public void setTime(String string) {
            this.time = string;
        }
    }
}
