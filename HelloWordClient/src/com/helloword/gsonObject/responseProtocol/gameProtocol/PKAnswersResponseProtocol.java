package com.helloword.gsonObject.responseProtocol.gameProtocol;

import com.helloword.gsonObject.GlobalGameDetails;

public class PKAnswersResponseProtocol extends GlobalGameResponseProtocol {
    
PKAnswerResultDetails details = new PKAnswerResultDetails();
    
    public PKAnswerResultDetails getDetails() {
        return details;
    }
    public void setDetailsPK(PKAnswerResultDetails details) {
        this.details = details;
    }
    
    public class PKAnswerResultDetails extends GlobalGameDetails {
//    public class AnswerResultDetails {
        
        String correct = null;
        String incorrect = null;
        String totalExp = null;
        String userLevel = null;
        
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
        
        public String getTotalExp() {
            return totalExp;
        }
        public void setTotalExp(String string) {
            this.totalExp = string;
        }

        public String getUserLevel() {
            return userLevel;
        }
        public void setUserLevel(String string) {
            this.userLevel = string;
        }        
    }
    
}
