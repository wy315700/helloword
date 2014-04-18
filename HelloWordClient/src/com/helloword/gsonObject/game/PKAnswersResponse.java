package com.helloword.gsonObject.game;

import com.helloword.gsonObject.GlobalGameDetails;

public class PKAnswersResponse extends GlobalGameResponse {

    PKAnswerResultDetails details = new PKAnswerResultDetails();

    public PKAnswerResultDetails getDetails() {
        return details;
    }
    public void setDetailsPK(PKAnswerResultDetails details) {
        this.details = details;
    }

    public class PKAnswerResultDetails extends GlobalGameDetails {
        String correct;
        String incorrect;
        String totalExp;
        String userLevel;

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

        public String getTotalExp() {
            return totalExp;
        }
        public void setTotalExp(String totalExp) {
            this.totalExp = totalExp;
        }

        public String getUserLevel() {
            return userLevel;
        }
        public void setUserLevel(String userLevel) {
            this.userLevel = userLevel;
        }
    }

}
