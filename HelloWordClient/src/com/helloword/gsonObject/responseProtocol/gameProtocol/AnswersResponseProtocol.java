package com.helloword.gsonObject.responseProtocol.gameProtocol;

import com.helloword.gsonObject.GlobalGameDetails;

public class AnswersResponseProtocol extends GlobalGameResponseProtocol {
    
    AnswerResultDetails details = new AnswerResultDetails();
    
    public AnswerResultDetails getDetails() {
        return details;
    }
    public void setDetails(AnswerResultDetails details) {
        this.details = details;
    }
    
    class AnswerResultDetails extends GlobalGameDetails {

        String correct = null;
        String incorrect = null;
        String thisScore = null;
        
        public String getCorrect() {
            return correct;
        }
        public void setCorrect(String string) {
            this.correct = string;
        }
        
        public String getIncorrect() {
            return incorrect;
        }
        public void setIncorrect(String string) {
            this.incorrect = string;
        }
        
        public String getThisScore() {
            return thisScore;
        }
        public void setThisScore(String string) {
            this.thisScore = string;
        }
    }
}
