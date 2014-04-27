package com.helloword.gsonObject.game;

import com.helloword.gsonObject.GlobalGameDetails;

public class AnswersResponse extends GlobalGameResponse {
    
    AnswerResultDetails details = new AnswerResultDetails();
    
    public AnswerResultDetails getDetails() {
        return details;
    }
    public void setDetails(AnswerResultDetails details) {
        this.details = details;
    }
    
    public class AnswerResultDetails extends GlobalGameDetails {
        String correct;
        String incorrect;
        String thisScore;
        
        public String getCorrect() {
            return correct;
        }
        public void setCorrect(String correct) {
            this.correct = correct;
        }
        
        public String getIncorrect() {
            return incorrect;
        }
        public void setIncorrect(String incorrect) {
            this.incorrect = incorrect;
        }
        
        public String getThisScore() {
            return thisScore;
        }
        public void setThisScore(String thisScore) {
            this.thisScore = thisScore;
        }
    }
}
